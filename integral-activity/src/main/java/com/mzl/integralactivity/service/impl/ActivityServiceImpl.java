package com.mzl.integralactivity.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzl.integralactivity.mapper.ActivityMapper;
import com.mzl.integralapi.service.ActivityService;
import com.mzl.integralcommon.constant.RedisKeyConstant;
import com.mzl.integralcommon.dto.ActivityDTO;
import com.mzl.integralcommon.entity.Activity;
import com.mzl.integralcommon.enums.RetCodeEnum;
import com.mzl.integralcommon.response.RetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 配置/添加活动(管理员)
     * @param activity
     * @return
     */
    @Override
    public RetResult addActivity(Activity activity) {
        activityMapper.insert(activity);
        return RetResult.success(RetCodeEnum.ADD_ACTIVITY_SUCCESS);
    }

    /**
     * 定时进行积分发放
     */
    @Override
    public void issueIntegral() {
        //查询所有的未过期活动
//        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        List<Activity> activityList = activityMapper.selectValidActivity(now);
        log.info("定时进行积分发放----->有效的任务为：" + activityList);
        activityList.forEach(activity -> {
            //异步线程来发放积分
            asyncIssueIntegral(activity);
        });

    }

    /**
     * 异步线程池来发放积分
     * @param activity
     */
    @Async("issueIntegralExecutor")
    public void asyncIssueIntegral(Activity activity){
        //发送积分的key为 issue:integral:活动id  值为 发送的积分数
        String key = RedisKeyConstant.ISSUE_INTEGRAL_KEY_PREFIX + activity.getActivityId();
        //有效期为300s(5分钟)
        redisTemplate.opsForValue().set(key, 100, 300, TimeUnit.SECONDS);
    }

}
