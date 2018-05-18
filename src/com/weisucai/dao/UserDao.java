package com.weisucai.dao;

import com.weisucai.dao.provider.UserDaoProvider;
import com.weisucai.domain.User;
import org.apache.ibatis.annotations.*;

public interface UserDao {
    //添加用户
    @InsertProvider(type = UserDaoProvider.class ,method = "insertUser")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    Integer saveUser(User user);

    //查找用户
    @Select("select * from tb_user where phone = #{phone} and password = #{password}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "level",property = "level"),
            @Result(column = "idNumber",property = "idNumber"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "signature",property = "signature"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "image",property = "image"),
            @Result(column = "zhifubao",property = "zhifubao"),
            @Result(column = "qq",property = "qq"),
            @Result(column = "integral",property = "integral"),
            @Result(column = "income",property = "income")
    })
    User findUser(User user);

    @Select("select * from tb_user where id = #{id} ")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "level",property = "level"),
            @Result(column = "idNumber",property = "idNumber"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "signature",property = "signature"),
            @Result(column = "credit",property = "credit"),
            @Result(column = "image",property = "image"),
            @Result(column = "zhifubao",property = "zhifubao"),
            @Result(column = "qq",property = "qq"),
            @Result(column = "integral",property = "integral"),
            @Result(column = "income",property = "income")
    })
    User selectById(User user);

    //根据openID查询user
    @Select("select * from tb_user where qq = #{qq}")
    User selectByOpenId(User user);
}
