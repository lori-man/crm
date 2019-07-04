package com.mercury.web.interceptor;

import com.mercury.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User existUser = (User) request.getSession().getAttribute("existUser");
        if (existUser == null) {
            response.sendRedirect("/login.jsp");
            return false;
        }else {
            return true;
        }
    }
}
