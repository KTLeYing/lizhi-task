package com.mzl.integralconsumer.mock;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzl.integralapi.service.SignService;
import com.mzl.integralcommon.dto.PageDTO;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.enums.RetCodeEnum;
import com.mzl.integralcommon.response.RetResult;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName :   SignServiceMock
 * @Description: 自定义服务降级的处理实现类,实现签到服务接口,定义消费者(客户端)具体降级逻辑
 * @Author: mzl
 * @CreateDate: 2022/7/7 22:36
 * @Version: 1.0
 */
public class SignServiceMock implements SignService {

    @Override
    public RetResult selectSignByPage(PageDTO pageDTO) {
        return RetResult.success(RetCodeEnum.SERVICE_DEGRADE);
    }



    /**
     * Service接口实现了Mybatis-plus的IService，所以要覆盖里面的接口方法
     * @param entityList
     * @param batchSize
     * @return
     */
    @Override
    public boolean saveBatch(Collection<Sign> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Sign> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Sign> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Sign entity) {
        return false;
    }

    @Override
    public Sign getOne(Wrapper<Sign> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Sign> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Sign> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Sign> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Sign> getEntityClass() {
        return null;
    }
}
