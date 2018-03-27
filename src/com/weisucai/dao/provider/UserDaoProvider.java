package com.weisucai.dao.provider;

import com.weisucai.domain.User;
import org.apache.ibatis.jdbc.SQL;

import static com.weisucai.util.common.GetWordConstants.USERTABLE;

public class UserDaoProvider {
    public String insertUser(User user){
        return new SQL(){
            {
                INSERT_INTO(USERTABLE);
                if(user.getUsername()!=null && !user.getUsername().equals("")){
                    VALUES("username","#{username}");
                }
                if(user.getPassword()!=null && !user.getPassword().equals("")){
                    VALUES("password","#{password}");
                }
                if(user.getAge()!=null){
                    VALUES("age","#{age}");
                }
            }
        }.toString();
    }
}
