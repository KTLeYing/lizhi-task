package com.mzl.userintegral.mapper;

import com.mzl.integralcommon.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mzl
 * @since 2022-07-01
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id查询用户总积分
     * @param userId
     * @return
     */
    Double selectIntegralById(Integer userId);

    /**
     * 修改数据库的用户总积分(与Redis保持一致)
     * @param userId
     */
    void updateIntegral(Integer userId);
}
