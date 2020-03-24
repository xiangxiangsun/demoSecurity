package com.example.demoSecurity.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-12
 */

@Component("myAccessDeniedHandler")
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        //返回json形式的错误信息

        httpServletResponse.setCharacterEncoding("UTF-8");

        httpServletResponse.setContentType("application/json");

//        httpServletResponse.getWriter().println("{\"code\":403,\"msg\":\"sorry，你没有权限访问呀！\",\"data\":\"\"}");
        httpServletResponse.getWriter().println("{\"code\":403,\"msg\":\""+e.getMessage()+"\"}");

        httpServletResponse.getWriter().flush();

    }
}
