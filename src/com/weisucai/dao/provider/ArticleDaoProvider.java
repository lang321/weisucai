package com.weisucai.dao.provider;

import com.weisucai.domain.Article;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.weisucai.util.common.GetWordConstants.ARTICLE;


public class ArticleDaoProvider {
    //动态插入数据
    public String insertArticle(Article model) {
        return new SQL() {
            {
                INSERT_INTO(ARTICLE);
                if (model.getOwer() != null) {
                    VALUES("area", "#{area.id}");
                }
                if (model.getType() != null && model.getType() != "") {
                    VALUES("type", "#{type}");
                }
                if (model.getOriginal() != null) {
                    VALUES("original", "#{original}");
                }
                if (model.getTitle() != null && model.getTitle() != "") {
                    VALUES("title", "#{title}");
                }
                if (model.getContent() != null && model.getContent() != "") {
                    VALUES("content", "#{content}");
                }
                if (model.getPrice() != null) {
                    VALUES("price", "#{price}");
                }
                if (model.getReleaseTime() != null) {
                    VALUES("releaseTime", "#{releaseTime}");
                }
                if (model.getOwer() != null) {
                    VALUES("ower", "#{ower.id}");
                }

            }
        }.toString();
    }

    //分页，pageIndex[Inter],pageZize[Integer],area[Integer],
    //  time[Integer],original[Integer] ,keyWord[String]
    public String selectRange(Map<String, Object> params) {
        Integer pageIndex = (Integer) params.get("pageIndex");
        Integer pageSize = (Integer) params.get("pageSize");
        String sql = new SQL() {
            {
                SELECT(" top(#{pageSize}) *");
                FROM(ARTICLE);
                //子查询
                String subSql = new SQL() {
                    {
//                        SELECT("top(#{(pageIndex-1)*pageSize}) id");
                        SELECT("top(" + (pageIndex - 1) * pageSize + ") id");
                        FROM(ARTICLE);
                        if (params.get("area") != null) {
                            WHERE("area=#{area}");
                        }
                        if (params.get("type") != null) {
                            WHERE("type=#{type}");
                        }
                        if (params.get("original") != null) {
                            WHERE("original=#{original}");
                        }
                        //user
                        if (params.get("userId") != null) {
                            WHERE("ower=#{userId}");
                        }
                        //时间范围 单位小时
                        if (params.get("time") != null) {
                            Integer hours = (Integer) params.get("time");
                            WHERE("DATEDIFF(HOUR,releaseTime,GETDATE()) < " + hours);
                        }
                        if (params.get("keyWord") != null) {
                            //模糊查询 SQL注入风险
//                            WHERE("title like '%"+params.get("keyWord")+"%'");
                            WHERE("title like '%'+#{keyWord}+'%'");
                        }
                        ORDER_BY(" releaseTime desc");
                    }
                }.toString();

                WHERE("id not in(" + subSql + ")");
                if (params.get("area") != null) {
                    WHERE("area=#{area}");
                }
                if (params.get("type") != null) {
                    WHERE("type=#{type}");
                }
                if (params.get("original") != null) {
                    WHERE("original=#{original}");
                }
                //user
                if (params.get("userId") != null) {
                    WHERE("ower=#{userId}");
                }
                if (params.get("time") != null) {
                    Integer hours = (Integer) params.get("time");
                    WHERE("DATEDIFF(HOUR,releaseTime,GETDATE()) < " + hours);
                }
                if (params.get("keyWord") != null) {
                    WHERE("title like '%'+#{keyWord}+'%'");
                }
//                WHERE("order by realseTime desc");
                ORDER_BY(" releaseTime desc");
            }
        }.toString();
//        sql += " where id not in (select top("+(pageIndex-1)*pageSize+") id from "+ARTICLE+") ";
        return sql;
    }

    public String getNumber(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("COUNT(id)");
                FROM(ARTICLE);
                if (params.get("area") != null) {
                    WHERE("area=#{area}");
                }
                if (params.get("type") != null) {  //图文|视频
                    WHERE("type=#{type}");
                }
                if (params.get("original") != null) {
                    WHERE("original=#{original}");
                }
                //时间范围 单位小时
                if (params.get("time") != null) {
                    Integer hours = (Integer) params.get("time");
                    WHERE("DATEDIFF(HOUR,releaseTime,GETDATE()) < " + hours);
                }
            }
        }.toString();
    }
}
