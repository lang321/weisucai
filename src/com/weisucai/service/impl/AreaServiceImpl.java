package com.weisucai.service.impl;

import com.weisucai.dao.AreaDao;
import com.weisucai.domain.Area;
import com.weisucai.service.AreaServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaServie {
    @Autowired
    private AreaDao areaDao;

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }


    @Override
    public Area getAreaById(Integer id) {
        Area area = new Area();
        area.setId(id);
        return areaDao.selectById(area);
    }

    @Override
    public List<Area> getAllArea() {
        return areaDao.selectAll();
    }
}
