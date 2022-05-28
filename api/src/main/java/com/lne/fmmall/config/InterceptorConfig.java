package com.lne.fmmall.config;

import com.lne.fmmall.interceptor.CheckTokenInterceptor;
import com.lne.fmmall.interceptor.KeepTokenAliveInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * FileName: InterceptorConfig
 * Author:   fengsulin
 * Date:     2022/4/30 11:00
 * Description: token拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    private CheckTokenInterceptor checkTokenInterceptor;
    @Resource
    private KeepTokenAliveInterceptor keepTokenAliveInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
        .addPathPatterns("/cart/**");
//        .excludePathPatterns("/user/**");
        registry.addInterceptor(keepTokenAliveInterceptor).addPathPatterns("**/*").excludePathPatterns("/user/login");
    }

}
