package com.mzl.integralapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzl.integralcommon.dto.ActivityDTO;
import com.mzl.integralcommon.entity.Activity;
import com.mzl.integralcommon.response.RetResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
public interface ActivityService extends IService<Activity> {

    /**
     * 配置/添加活动(管理员)
     * @param
     */
    RetResult addActivity(Activity activity);

    /**
     * 定时进行积分发放
     */
    void issueIntegral();

}
