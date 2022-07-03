package com.mzl.integralconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzl.integralapi.service.RankService;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.integralconsumer.annotation.AccessLimit;
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
public class IntegralRankController {

    @Reference
    private RankService rankService;

    @GetMapping("/rankByIntegral")
    @ApiOperation(value = "用户积分排行榜")
    public RetResult rankByIntegral(){
        return rankService.rankByIntegral();
    }

}
