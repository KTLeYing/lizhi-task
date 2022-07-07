package com.mzl.integralconsumer.mock;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzl.integralapi.service.UserService;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.enums.RetCodeEnum;
import com.mzl.integralcommon.response.RetResult;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName :   UserServiceMock
 * @Description: 自定义服务降级的处理实现类,实现用户服务接口,定义消费者(客户端)具体降级逻辑
 * @Author: mzl
 * @CreateDate: 2022/7/7 22:35
 * @Version: 1.0
 */
public class UserServiceMock implements UserService {
    @Override
    public RetResult selectUserById(Integer userId) {
        return RetResult.success(RetCodeEnum.SERVICE_DEGRADE);
    }

    @Override
    public RetResult selectIntegralById(Integer userId) {
        return RetResult.success(RetCodeEnum.SERVICE_DEGRADE);
    }

    @Override
    public RetResult activitySign(Integer userId, Integer activityId) {
        return RetResult.success(RetCodeEnum.SERVICE_DEGRADE);
    }

    @Override
    public RetResult selectIntegralById1(Integer userId) {
        return RetResult.success(RetCodeEnum.SERVICE_DEGRADE);
    }


    /**
     * Service接口实现了Mybatis-plus的IService，所以要覆盖里面的接口方法
     * @return
     */
    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<User> getBaseMapper() {
        return null;
    }

    @Override
    public Class<User> getEntityClass() {
        return null;
    }
}
