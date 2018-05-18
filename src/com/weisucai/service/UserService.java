package com.weisucai.service;

import com.weisucai.domain.User;

public interface UserService {
    int saveUser(User user)throws Exception;
    //根据手机号和密码登录
    User login(User user);
    //根据openID登录
    User findUserByOpenId(User user);
}
