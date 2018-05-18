package com.weisucai.controller;

import com.weisucai.domain.Article;
import com.weisucai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleServie;

    public void setArticleServie(ArticleService articleServie) {
        this.articleServie = articleServie;
    }

    //分页
    @RequestMapping(value = "/getArticleRange", method = RequestMethod.POST)
    @ResponseBody
    public List<Article> getArticleRange(int pageIndex, int pageSize,
                                         Integer area, Integer time, String keyWord, Integer original) {
        List<Article> articles;
        Map<String, Object> params = new HashMap<>();
        params.put("pageIndex", pageIndex);
        params.put("pageSize", pageSize);
        if (area > 0) {
            params.put("area", area);
        }
        if (time > 0) {
            params.put("time", time);
        }
        params.put("original", original);
        if (keyWord != null) {
            params.put("keyWord", keyWord);
        }
        articles = articleServie.getArticlesRange(params);
        for (Article a :
                articles) {
            a.setShortDate(a.getReleaseTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        }
        return articles;
    }

    @RequestMapping(value = "/getAllPage", method = RequestMethod.POST)
    @ResponseBody
    public int getArticlePageNumber(int pageSize,
                                    Integer area, Integer time, String keyWord, Integer original) {
        //获取总页数
        Map<String, Object> params = new HashMap<>();
        if (area > 0) {
            params.put("area", area);
        }
        if (time > 0) {
            params.put("time", time);
        }
        params.put("original", original);
        if (keyWord != null) {
            params.put("keyWord", keyWord);
        }
        Integer num = articleServie.getArticleNumber(params);
        int pages = num % pageSize == 0 ? num / pageSize : num / pageSize + 1;
        return pages;
    }

    //需要一个参数文章id
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Integer id, Model model, HttpServletRequest request) {
        Article article = articleServie.getArticleById(id);
        model.addAttribute(article);
        LocalDateTime date = LocalDateTime.now();

//        String url = article.getContent();
        String realPath = article.getContent();
        File file = new File(realPath);
        Long length = file.length();
        byte[] bs = new byte[length.intValue()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            inputStream.read(bs);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String content = new String(bs);
        article.setContent(HtmlUtils.htmlUnescape(content));
        return "/article/detail.jsp";
    }

    //获取文章信息，根据文章的id
//    @RequestMapping(value = "/getArticleById",method = RequestMethod.POST)
//    @ResponseBody
//    public Article getArticleById(Integer id){
//        Article article = articleServie.getArticleById(id);
//        return article;
//    }
}
