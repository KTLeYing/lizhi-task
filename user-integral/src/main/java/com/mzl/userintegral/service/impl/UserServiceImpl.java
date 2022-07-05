package com.mzl.userintegral.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzl.integralapi.service.UserService;
import com.mzl.integralcommon.constant.RedisKeyConstant;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.enums.RetCodeEnum;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.userintegral.mapper.SignMapper;
import com.mzl.userintegral.mapper.UserMapper;
import com.mzl.userintegral.utlils.RedissonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SignMapper signMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonUtil redissonUtil;

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Override
    public RetResult selectUserById(Integer userId) {
        User user = userMapper.selectById(userId);
        return RetResult.success(user);
    }

    /**
     * 根据用户id查询用户总积分【通过数据库查询，性能低，不推荐】
     * @param userId
     * @return
     */
    @Override
    public RetResult selectIntegralById(Integer userId){
        Double integralNum = userMapper.selectIntegralById(userId);
        return RetResult.success(integralNum);
    }

    /**
     * 根据用户id查询用户总积分【通过Redis查询，性能高】
     * @param userId
     * @return
     */
    @Override
    public RetResult selectIntegralById1(Integer userId) {
        Double integralNum = redisTemplate.opsForZSet().score(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId);
        //如果redis没有，则查询数据库(万一redis数据的丢失)
        if (integralNum == null){
            log.info("根据用户id查询用户总积分----->Redis中没有，查数据库了...");
            integralNum = userMapper.selectIntegralById(userId);
        }
        return RetResult.success(integralNum);
    }

    /**
     * 用户活动签到
     * @param userId
     * @param activityId
     * @return
     */
    @Override
    public RetResult activitySign(Integer userId, Integer activityId) {
        //判断活动是否结束
        if(redisTemplate.hasKey(RedisKeyConstant.ISSUE_INTEGRAL_KEY_PREFIX + activityId) || (Integer)redisTemplate.opsForValue().get(RedisKeyConstant.ISSUE_INTEGRAL_KEY_PREFIX + activityId) > 0){
            //未结束
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String now = simpleDateFormat.format(new Date());
            //判断用户今天领取的积分是否超过100
            Integer signNumToday = signMapper.countNumToday(userId, activityId, now);
            log.info("用户活动签到----->签到数：" + signNumToday);
            //用户今天此活动等等签到数超过20次(100积分)，则限制
            if(signNumToday >= 20){
                return RetResult.success(RetCodeEnum.SIGN_FAIL);
            }
            //用户今天积分还不够100， 则进行签到，使用分布式锁（共享变量的保护）
            try{
                log.info("用户活动签到----->打印：============={} 线程访问开始============",Thread.currentThread().getName());
                //尝试获取锁，等待3秒，自己获得锁后一直不解锁则5秒后自动解锁(释放)
                boolean lock = redissonUtil.tryLock(RedisKeyConstant.REDISSON_KEY, TimeUnit.SECONDS, 3L, 5L);
                if (lock) {
                    log.info("用户活动签到----->线程:{}，获取到了锁",Thread.currentThread().getName());
                    log.info("用户活动签到----->线程:{}，======获得锁后进行相应的操作======" + Thread.currentThread().getName());
                    //获得锁之后可以进行相应的逻辑处理(签到)
                    redisTemplate.opsForValue().increment(RedisKeyConstant.ISSUE_INTEGRAL_KEY_PREFIX + activityId, -5);
                    //添加签到记录到数据库
                    Timestamp nowDate = new Timestamp(System.currentTimeMillis());
                    Sign sign = new Sign();
                    sign.setUserId(userId);
                    sign.setActivityId(activityId);
                    sign.setSignTime(nowDate);
                    sign.setNote("我签到了");
                    signMapper.insert(sign);
                    //修改数据库的用户总积分(与Redis保持一致)
                    userMapper.updateIntegral(userId);
                    //添加用户Redis的zset的积分（累计）
                    Double score = redisTemplate.opsForZSet().score(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId);
                    if (score == null){
                        //首次签到
                        redisTemplate.opsForZSet().add(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId, 5);
                    }else {
                        redisTemplate.opsForZSet().add(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId, redisTemplate.opsForZSet().score(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId) + 5);
                    }
                    //处理完后释放锁(一定要，不然死锁)
                    redissonUtil.unlock(RedisKeyConstant.REDISSON_KEY);
                    log.info("用户活动签到----->线程:{}，=============处理完，释放锁================" + Thread.currentThread().getName());
                }
            }catch (Exception e){
                log.info("用户活动签到----->错误信息：{}",e.toString());
                log.info("用户活动签到----->线程：{} 获取锁失败",Thread.currentThread().getName());
            }
            return RetResult.success(RetCodeEnum.SIGN_SUCCESS);
        }else {
            //已结束
            return RetResult.success(RetCodeEnum.SIGN_FAIL);
        }
    }


}
