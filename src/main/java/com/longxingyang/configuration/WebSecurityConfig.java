package com.longxingyang.configuration;

import com.longxingyang.Interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by a4420 on 18/03/19.
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
    public final static String SESSION_KEY_ADMIN = "admin";

/*    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }*/

    public void addInterceptors(InterceptorRegistry registry) {
/*        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());*/

        registry.addInterceptor(new SecurityInterceptor())
                .addPathPatterns("/seller/**","/user/**")
                .excludePathPatterns("/loginPost","/sell/login.html");

/*        // 排除配置
        addInterceptor.excludePathPatterns("/sell/seller/order*//**");
        addInterceptor.excludePathPatterns("/sell*//**");

        // 拦截配置
        addInterceptor.addPathPatterns("/error");
        addInterceptor.addPathPatterns("*//**");*/

    }



}
