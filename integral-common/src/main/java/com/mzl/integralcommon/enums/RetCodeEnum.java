package com.mzl.integralcommon.enums;

import lombok.Getter;

/**
 * @EnumName :   RetCodeEnum
 * @Description: 返回结果状态码枚举
 * @Author: mzl
 * @CreateDate: 2022/7/1 1:01
 * @Version: 1.0
 */
@Getter
public enum RetCodeEnum {

    //通用枚举(5xx)
    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),
    NULL_POINT_EXCEPTION(501, "空指针异常~"),
    SERVICE_DEGRADE(502, "系统繁忙，服务降级"),
    REQUEST_FLUENTLY(503, "请求过于频繁，请稍后再操作"),

    //积分活动枚举(6xx)
    ADD_ACTIVITY_SUCCESS(601, "配置/添加活动成功"),


    //用户积分枚举(7xx)
    SIGN_SUCCESS(701, "用户签到成功"),
    SIGN_FAIL(702, "用户签到失败"),

    //排行榜枚举(8xx)

    ;

    private Integer code;
    private String message;

    RetCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (RetCodeEnum item : RetCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (RetCodeEnum item : RetCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
