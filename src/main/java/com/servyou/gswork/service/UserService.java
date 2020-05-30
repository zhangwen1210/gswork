package com.servyou.gswork.service;

import com.servyou.gswork.po.User;

/**
 * @program: gswork->UserService
 * @description: 用户服务层
 * @author: zhangwen
 * @create: 2020-05-27 11:35
 **/
public interface UserService {
    public User login(User user);
}
