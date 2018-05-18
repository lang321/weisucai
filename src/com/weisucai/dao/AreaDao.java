package com.weisucai.dao;

import com.weisucai.domain.Area;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaDao {
    @Select("select * from area where id = #{id} ")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "clickNum",property = "clickNum"),
            @Result(column = "transNum",property = "transNum")
    })
    Area selectById(Area model);
    //获取所有领域信息
    @Select("select * from area ")
    List<Area> selectAll();
}
