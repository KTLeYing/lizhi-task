package com.mzl.integralrank.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzl.integralapi.service.RankService;
import com.mzl.integralcommon.constant.RedisKeyConstant;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.integralrank.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mzl
 * @since 2022-07-03
 */
@Service
@Transactional
@Slf4j
public class RankServiceImpl extends ServiceImpl<UserMapper, User> implements RankService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户积分排行榜
     * @return
     */
    @Override
    public RetResult rankByIntegral() {
        Set<ZSetOperations.TypedTuple<Object>> rankSet = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(RedisKeyConstant.TOTAL_INTEGRAL_KEY, 0, Long.MAX_VALUE);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = rankSet.iterator();
        //存储排行好的结果列表
        List<JSONObject> rankList = new ArrayList<>();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            Object value = typedTuple.getValue();
            Double score = typedTuple.getScore();
            log.info("用户积分排行榜----->排行后，用户id：" + value + "用户积分" + score);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", value);
            jsonObject.put("score", score);
            rankList.add(jsonObject);
        }
        return RetResult.success(rankList);
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public RetResult zSetAdd(Integer userId) {
        Double score = redisTemplate.opsForZSet().score(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId);
        if (score == null){
            redisTemplate.opsForZSet().add(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId, 5);
        }else {
            redisTemplate.opsForZSet().add(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId, redisTemplate.opsForZSet().score(RedisKeyConstant.TOTAL_INTEGRAL_KEY, userId) + 5);
        }
        return RetResult.success();
    }

}
