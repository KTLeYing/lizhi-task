package com.mzl.integralapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzl.integralcommon.entity.Sign;
import com.mzl.integralcommon.entity.User;
import com.mzl.integralcommon.response.RetResult;

/**
 * @InterfaceName :   RankService
 * @Description: TODO
 * @Author: mzl
 * @CreateDate: 2022/7/3 9:49
 * @Version: 1.0
 */
public interface RankService extends IService<User> {

    /**
     * 用户积分排行榜
     * @return
     */
    RetResult rankByIntegral();

}
