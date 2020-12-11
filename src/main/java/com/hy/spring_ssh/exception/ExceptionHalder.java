package com.hy.spring_ssh.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class ExceptionHalder implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       String msg="";
       if(e instanceof MyException){
           MyException mye= (MyException) e;
           mye.getMsg();
       }

       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("ree",msg);
       modelAndView.setViewName("500");
        return modelAndView;
    }
}
