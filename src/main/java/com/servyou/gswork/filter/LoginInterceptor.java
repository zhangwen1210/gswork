package com.servyou.gswork.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: gswork->LoginInterceptor
 * @description: 登录拦截器
 * @author: zhangwen
 * @create: 2020-05-29 09:39
 **/
public class LoginInterceptor implements HandlerInterceptor {


    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入拦截器进行登录检查");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if (user == null)  {
            response.sendRedirect("/loginpage");
            //request.getRequestDispatcher("/loginpage").forward(request,response);
            logger.info("当前尚未登录,请先登录!");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
