package com.mzl.integralapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzl.integralcommon.dto.PageDTO;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.response.RetResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mzl
 * @since 2022-07-03
 */
public interface SignService extends IService<Sign> {

    /**
     * 分页模糊查询用户的签到历史表
     * @param pageDTO
     * @return
     */
    RetResult selectSignByPage(PageDTO pageDTO);

}
