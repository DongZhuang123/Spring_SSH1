package com.hy.spring_ssh.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginfilter implements HandlerInterceptor {
    //Controller执行前调用c此方法
//    返回true继续执行，返回false中止执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进来了");
        String stuname= (String) request.getSession().getAttribute("sname");
        System.out.println(stuname);
        System.out.println(request.getRequestURI().indexOf("/stu/login.do"));
        if(stuname==null || "".equals(stuname)){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}
