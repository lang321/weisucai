package com.weisucai.test;

import com.weisucai.dao.AreaDao;
import com.weisucai.dao.UserDao;
import com.weisucai.domain.Area;
import com.weisucai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void findById() {
        int id = 1;
        Area area = new Area();
        area.setId(id);
        Area rs = areaDao.selectById(area);
        System.out.println(rs);
    }
    @Test
    public void findAll() {
        List<Area> rs = areaDao.selectAll();
        System.out.println(rs);
    }

}
