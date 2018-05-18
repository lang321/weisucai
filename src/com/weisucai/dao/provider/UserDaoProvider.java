package com.weisucai.dao.provider;

import com.weisucai.domain.User;
import org.apache.ibatis.jdbc.SQL;

import static com.weisucai.util.common.GetWordConstants.USERTABLE;

public class UserDaoProvider {
    public String insertUser(User user) {
        return new SQL() {
            {
                INSERT_INTO(USERTABLE);
                if (user.getUsername() != null && !user.getUsername().equals("")) {
                    VALUES("username", "#{username}");
                }
                if (user.getPassword() != null && !user.getPassword().equals("")) {
                    VALUES("password", "#{password}");
                }
                if (user.getBirthday() != null) {
                    VALUES("birthday", "#{birthday}");
                }
                if (user.getCredit() != null) {
                    VALUES("credit", "#{credit}");
                }
                if (user.getGender() != null && user.getGender() != "") {
                    VALUES("gender", "#{gender}");
                }
                if (user.getIdNumber() != null && user.getIdNumber() != "") {
                    VALUES("idNumber", "#{idNumber}");
                }
                if (user.getImage() != null && user.getImage() != "") {
                    VALUES("image", "#{image}");
                }
                if (user.getIncome() != 0) {
                    VALUES("income", "#{income}");
                }
                if (user.getIntegral() != null) {
                    VALUES("integral", "#{integral}");
                }
                if (user.getLevel() != null) {
                    VALUES("level", "#{level}");
                }
                if (user.getPhone() != null && user.getPhone() != "") {
                    VALUES("phone", "#{phone}");
                }
                if (user.getQq() != null && user.getQq() != "") {
                    VALUES("qq", "#{qq}");
                }
            }
        }.toString();
    }
}
