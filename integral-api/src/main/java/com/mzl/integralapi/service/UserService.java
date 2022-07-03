package com.mzl.integralapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.response.RetResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
public interface UserService extends IService<User> {

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    RetResult selectUserById(Integer userId);

    /**
     * 根据用户id查询用户总积分
     * @param userId
     * @return
     */
    RetResult selectIntegralById(Integer userId);

    /**
     * 用户活动签到
     * @param userId
     * @param activityId
     * @return
     */
    RetResult activitySign(Integer userId, Integer activityId);
}
