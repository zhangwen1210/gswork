package com.servyou.gswork.service.impl;

import com.servyou.gswork.mapper.UserMapper;
import com.servyou.gswork.po.User;
import com.servyou.gswork.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: gswork->UserServiceImpl
 * @description: 用户服务层实现类
 * @author: zhangwen
 * @create: 2020-05-27 11:39
 **/
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录验证
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        logger.info("开始调用数据层进行登录验证");
        User loginUser = userMapper.getUser(user);
        logger.info("登录验证结束！");
        return loginUser;
    }
}
