package com.weisucai.service;

import com.weisucai.domain.Area;

import java.util.List;

public interface AreaServie {
    //根据id获取领域信息
    Area getAreaById(Integer id);
    List<Area> getAllArea();
}
