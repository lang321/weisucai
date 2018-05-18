package com.weisucai.controller;

import com.weisucai.dao.AreaDao;
import com.weisucai.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaDao areaDao;

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @RequestMapping(value = "/getAreas",method = RequestMethod.POST)
    @ResponseBody
    public List<Area> getAreas() {
        List<Area> areas;
        areas = areaDao.selectAll();
        return areas;
    }
}
