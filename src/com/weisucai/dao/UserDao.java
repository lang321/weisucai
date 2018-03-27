package com.weisucai.dao;

import com.weisucai.dao.provider.UserDaoProvider;
import com.weisucai.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface UserDao {
    @InsertProvider(type = UserDaoProvider.class ,method = "insertUser")
    int saveUser(User user);
}
