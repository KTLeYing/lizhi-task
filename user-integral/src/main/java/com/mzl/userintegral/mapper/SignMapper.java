package com.mzl.userintegral.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mzl.integralcommon.dto.PageDTO;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.vo.SignVO;

import java.sql.Timestamp;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mzl
 * @since 2022-07-03
 */
public interface SignMapper extends BaseMapper<Sign> {

    /**
     * 分页模糊查询用户的签到历史表
     * @param page
     * @param pageDTO
     * @return
     */
    IPage<SignVO> selectSignByPage(Page<SignVO> page, PageDTO pageDTO);

    /**
     * 查询某用户打卡签到此次活动的次数
     * @param userId
     * @param now
     * @param activityId
     * @return
     */
    Integer countNumToday(Integer userId, Integer activityId, String now);
}
