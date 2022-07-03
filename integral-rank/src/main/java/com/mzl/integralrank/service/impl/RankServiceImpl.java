package com.mzl.integralrank.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzl.integralapi.service.RankService;
import com.mzl.integralcommon.constant.RedisKeyConstant;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.integralrank.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        Set rankSet = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(RedisKeyConstant.TOTAL_INTEGRAL_KEY, 0, -1);
        Iterator<String> it = rankSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
        }
        return RetResult.success();
    }
}
