package com.weisucai.dao;

import com.weisucai.dao.provider.ArticleDaoProvider;
import com.weisucai.domain.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
    /**
     * 根据文章的id查找文章
     *
     * @param model
     * @return
     */
    @Select("select * from article where id = #{id} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "area", property = "area",
                    one = @One(select = "com.weisucai.dao.AreaDao.selectById",
                            fetchType = FetchType.LAZY)),
            @Result(column = "type", property = "type"),
            @Result(column = "original", property = "original"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "price", property = "price"),
            @Result(column = "releaseTime", property = "releaseTime"),
            @Result(column = "ower", property = "ower",
                    one = @One(select = "com.weisucai.dao.UserDao.selectById",
                            fetchType = FetchType.LAZY))
    })
    Article selectById(Article model);

    //分页 动态查询 time 为多少小时内的文章
    // 分页，pageIndex,pageSize,area,time[],original[],user
    @SelectProvider(type = ArticleDaoProvider.class, method = "selectRange")
    @Results({
            //特殊的列的映射
//            @Result(column = "releaseTime",property = "shortDate"),
            @Result(column = "area", property = "area",
                    one = @One(select = "com.weisucai.dao.AreaDao.selectById",
                            fetchType = FetchType.EAGER)),
            @Result(column = "ower", property = "ower",
                    one = @One(select = "com.weisucai.dao.UserDao.selectById",
                            fetchType = FetchType.EAGER))
    })
    List<Article> selectRange(Map<String, Object> params);

    //动态插入文章
    @InsertProvider(type = ArticleDaoProvider.class, method = "insertArticle")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    Integer add(Article model);

    @SelectProvider(type = ArticleDaoProvider.class,method = "getNumber")
    Integer getNumber(Map<String, Object> params);
}
