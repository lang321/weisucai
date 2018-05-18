package com.weisucai.service.impl;

import com.weisucai.dao.ArticleDao;
import com.weisucai.domain.Article;
import com.weisucai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    //根据文章的id查找文章
    @Override
    public Article getArticleById(Integer id) {
        Article article = new Article();
        article.setId(id);
        return articleDao.selectById(article);
    }
    //添加文章
    @Override
    public Integer addArticle(Article article) {
        return articleDao.add(article);
    }
    //分页
    @Override
    public List<Article> getArticlesRange(Map<String, Object> params) {
        return articleDao.selectRange(params);
    }

    //文章总条数
    @Override
    public Integer getArticleNumber(Map<String, Object> params) {
        return articleDao.getNumber(params);
    }
}
