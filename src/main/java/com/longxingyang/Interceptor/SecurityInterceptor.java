package com.longxingyang.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.longxingyang.configuration.WebSecurityConfig.SESSION_KEY;

/**
 * Created by a4420 on 18/03/20.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute(SESSION_KEY) != null){
            return true;
        }
        String url = "/sell/login.html";
        response.sendRedirect(url);
        return false;
    }
}