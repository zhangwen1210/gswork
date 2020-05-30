package com.servyou.gswork.controller;

import com.servyou.gswork.po.User;
import com.servyou.gswork.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: gswork->IndexController
 * @description: 包含首页，登录页等controller
 * @author: zhangwen
 * @create: 2020-05-27 10:49
 **/
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserService userService;

    /**
     * 进入登录页
     * @param model
     * @return
     */
    @RequestMapping(value = "/loginpage")
    public String houtaiLoginPage(Model model){
        logger.info("跳转登录页");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(@ModelAttribute(value = "user") User user, Model model, HttpServletRequest request){
        User loginUser = userService.login(user);
        if (loginUser == null){
            logger.info("登录失败！");
            return "loginfail";
        }else {
            logger.info("登录成功！登录用户名："+user.getUsername());
            request.getSession().setAttribute("loginUser",loginUser);
            return "index";
        }
    }

}
