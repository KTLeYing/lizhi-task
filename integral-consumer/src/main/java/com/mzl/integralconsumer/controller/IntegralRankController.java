package com.mzl.integralconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzl.integralapi.service.RankService;
import com.mzl.integralcommon.response.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName :   IntegralActivityController
 * @Description: 积分排行榜控制器
 * @Author: mzl
 * @CreateDate: 2022/7/1 10:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("integralRank")
@Api(value = "积分排行模块", tags = "积分排行模块接口")
public class IntegralRankController {

    @Reference
    private RankService rankService;

    @GetMapping("/rankByIntegral")
    @ApiOperation(value = "用户积分排行榜")
    public RetResult rankByIntegral(){
        return rankService.rankByIntegral();
    }

    @GetMapping("/zSetAdd")
    @ApiOperation(value = "添加用户积分(只用于个人测试)")
    public RetResult zSetAdd(Integer userId){
        return rankService.zSetAdd(userId);
    }




}
