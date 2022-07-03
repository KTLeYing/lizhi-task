package com.mzl.integralconsumer.interceptor;

import com.mzl.integralcommon.constant.RedisKeyConstant;
import com.mzl.integralcommon.enums.RetCodeEnum;
import com.mzl.integralconsumer.annotation.AccessLimit;
import com.mzl.integralconsumer.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName :   SignInterceptor
 * @Description: 签到拦截器
 * @Author: mzl
 * @CreateDate: 2022/7/3 22:45
 * @Version: 1.0
 */
@Slf4j
public class SignInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(request.getRequestURI());
        //判断请求是否属于方法的请求
        if(handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;

            Enumeration<String> s = request.getParameterNames();
            while (s.hasMoreElements()){
                String parameter = s.nextElement();
            }
            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = method.getMethodAnnotation(AccessLimit.class);
            //没有改注解则放行
            if (accessLimit == null){
                return true;
            }

            Integer userId = Integer.valueOf(request.getParameter("userId"));
            log.info("签到拦截器----->用户id：" + userId);
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();

            //不存在key，则允许签到
            if (!redisTemplate.hasKey(RedisKeyConstant.SIGN_KEY_PREFIX + userId)){
                redisTemplate.opsForValue().set(RedisKeyConstant.SIGN_KEY_PREFIX + userId, 1, seconds, TimeUnit.SECONDS);
            }else if ((Integer)redisTemplate.opsForValue().get(RedisKeyConstant.SIGN_KEY_PREFIX + userId) < maxCount){
                redisTemplate.opsForValue().increment(RedisKeyConstant.SIGN_KEY_PREFIX + userId);
            }else {
                throw new CustomException(RetCodeEnum.REQUEST_FLUENTLY);
            }
        }
        return true;
    }

}
