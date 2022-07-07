package com.mzl.integralconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzl.integralapi.service.SignService;
import com.mzl.integralapi.service.UserService;
import com.mzl.integralcommon.dto.PageDTO;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.integralconsumer.annotation.AccessLimit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :   UserIntegralController
 * @Description: 用户积分控制器
 * @Author: mzl
 * @CreateDate: 2022/7/1 10:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("userIntegral")
@Api(value = "用户积分模块", tags = "用户积分模块接口")
public class UserIntegralController {

    @Reference(check = false, loadbalance = "random", cluster = "failover", retries = 2, timeout = 3000, mock = "com.mzl.integralconsumer.mock.UserServiceMock")
    private UserService userService;

    @Reference(check = false, loadbalance = "random", cluster = "failover", retries = 2, timeout = 3000, mock = "com.mzl.integralconsumer.mock.SignServiceMock")
    private SignService signService;

    @GetMapping("/selectUserById")
    @ApiOperation(value = "根据id查询用户")
    public RetResult selectUserById(Integer userId){
        return userService.selectUserById(userId);
    }

    @GetMapping("/selectIntegralById")
    @ApiOperation(value = "根据用户id查询用户总积分【通过数据库查询，性能低，不推荐】")
    public RetResult selectIntegralById(Integer userId){
        return userService.selectIntegralById(userId);
    }

    @GetMapping("/selectIntegralById1")
    @ApiOperation(value = "根据用户id查询用户总积分【通过Redis查询，性能高】")
    public RetResult selectIntegralById1(Integer userId){
        return userService.selectIntegralById1(userId);
    }

    @GetMapping("/selectSignByPage")
    @ApiOperation(value = "分页模糊查询用户的签到历史表")
    public RetResult selectSignByPage(PageDTO pageDTO){
        return signService.selectSignByPage(pageDTO);
    }

    @GetMapping("/activitySign")
    @ApiOperation(value = "用户活动签到")
    @AccessLimit(seconds = 5, maxCount = 1)
    public RetResult activitySign(Integer userId, Integer activityId){
        return userService.activitySign(userId, activityId);
    }

}
