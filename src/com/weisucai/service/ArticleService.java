package com.weisucai.service;

import com.weisucai.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    //根据文章的id查找文章
    Article getArticleById(Integer id);
    //添加文章
    Integer addArticle(Article article);

    /**
     * 分页查询
     * @param params
     * pageIndex,pageSize,area,time(小时),original,keyWord(String)
     * @return
     */
    List<Article> getArticlesRange(Map<String, Object> params);

    Integer getArticleNumber(Map<String, Object> params);
}
