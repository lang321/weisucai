package com.weisucai.test;

import com.weisucai.dao.UserDao;
import com.weisucai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.resources.cldr.wae.CalendarData_wae_CH;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
        User u = new User();
        u.setUsername("admin5");
        u.setPassword("1213");
        u.setBirthday(LocalDateTime.now());
        u.setGender("男");
        u.setCredit(100);
        u.setIncome(9000.0f);
        int rs = userDao.saveUser(u);
        System.out.println(rs);
    }

    @Test
    public void findUser() {
        User u = new User();
        u.setPhone("18260754784");
        u.setPassword("123");
        User user = userDao.findUser(u);
        System.out.println(user);

    }

    @Test
    public void testLocalDate() {
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d);
    }

    //根据用户id查找用户
    @Test
    public void findById() {
        int id = 1;
        User user = new User();
        user.setId(id);
        User rs = userDao.selectById(user);
        System.out.println(rs);
    }

    @Test
    public void selectByOpenId(){
        User user = new User();
        user.setQq("2470077BB2D01A37D6ED714EC7D9EB56 ");
        User rs = userDao.selectByOpenId(user);
        System.out.println(rs);
    }
}
