package com.mzl.integralcommon.constant;

/**
 * @ClassName :   RedisKeyConstant
 * @Description: Redis的key的常量
 * @Author: mzl
 * @CreateDate: 2022/7/3 20:12
 * @Version: 1.0
 */
public class RedisKeyConstant {

    //积分发放的Redis的key前缀
    public static final String ISSUE_INTEGRAL_KEY_PREFIX = "issue:integral:";

    //redission分布式锁的key
    public final static String REDISSON_KEY = "RedissonKey";

    //用户签到的key前缀
    public static final String SIGN_KEY_PREFIX = "user:sign:";

    //用户总积分的key前缀
    public static final String TOTAL_INTEGRAL_KEY = "user:total:integral";

}
