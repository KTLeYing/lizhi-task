package com.mzl.integralconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzl.integralapi.service.ActivityService;
import com.mzl.integralcommon.entity.Activity;
import com.mzl.integralcommon.response.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :   IntegralActivityController
 * @Description:  积分活动控制器
 * @Author: mzl
 * @CreateDate: 2022/7/1 10:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("integralActivity")
@Api(value = "积分活动模块", tags = "积分活动模块接口")
public class IntegralActivityController {

    @Reference
    private ActivityService activityService;

    @PostMapping("/addActivity")
    @ApiOperation(value = "配置/添加活动(管理员)")
    public RetResult addActivity(@RequestBody Activity activity){
        System.out.println(activity);
        return activityService.addActivity(activity);
    }
}
