package com.lne.fmmall.interceptor;

import io.lettuce.core.dynamic.annotation.Command;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 拦截所有请求，目的是为给token续命（前端每次请求都带上token）
 */
@Component
public class KeepTokenAliveInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null ){
            return true;
        }
        String s = stringRedisTemplate.boundValueOps(token).get();
        if(s != null){
            stringRedisTemplate.boundValueOps(token).expire(2, TimeUnit.MINUTES);
            return true;
        }
        return true;
    }
}
