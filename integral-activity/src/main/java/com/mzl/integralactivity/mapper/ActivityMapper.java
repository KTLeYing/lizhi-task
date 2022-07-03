package com.mzl.integralactivity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzl.integralcommon.entity.Activity;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 查询所有的未过期活动
     * @param
     * @return
     */
    List<Activity> selectValidActivity(String now);
}
