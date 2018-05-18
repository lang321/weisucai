package com.weisucai.service.impl;

import com.weisucai.dao.UserDao;
import com.weisucai.domain.User;
import com.weisucai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    UserDao userDao222;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @Override
    public int saveUser(User user) throws Exception {
        int rs = 0;
//        userDao.saveUser(user);
//        userDao222.toString();
        rs = userDao.saveUser(user);
        return rs;
    }

    /**
     * 根据手机号和密码登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        User uRs = userDao.findUser(user);
        return uRs;
    }

    @Override
    public User findUserByOpenId(User user) {
        return userDao.selectByOpenId(user);
    }
}
