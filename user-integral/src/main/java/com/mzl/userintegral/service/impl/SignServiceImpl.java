package com.mzl.userintegral.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzl.integralapi.service.SignService;
import com.mzl.integralcommon.dto.PageDTO;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.response.RetResult;
import com.mzl.integralcommon.vo.SignVO;
import com.mzl.userintegral.mapper.SignMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mzl
 * @since 2022-07-03
 */
@Service
@Transactional
@Slf4j
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign> implements SignService {

    @Autowired
    private SignMapper signMapper;

    /**
     * 分页模糊查询用户的签到历史表
     * @param pageDTO 分页对象
     * @return
     */
    @Override
    public RetResult selectSignByPage(PageDTO pageDTO) {
        //如果当前页为空或为0，则默认为第一页
        if (pageDTO.getCurrentPage() == null || pageDTO.getCurrentPage() == 0){
            pageDTO.setCurrentPage(1);
        }
        //每页大小固定为10
        pageDTO.setPageSize(10);
        Page<SignVO> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        IPage<SignVO> signVOIPage = signMapper.selectSignByPage(page, pageDTO);
        return RetResult.success(signVOIPage);
    }
}
