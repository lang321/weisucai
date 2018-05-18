package com.weisucai.controller;

import com.weisucai.dao.ArticleDao;
import com.weisucai.domain.Article;
import com.weisucai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/articleManager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleManagerController {

    @Autowired
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/articleManager/index.html";
    }

    @RequestMapping(value = "/editArticle", method = RequestMethod.GET)
    public String editArticle(Integer id, Model model){
        Article article = articleService.getArticleById(id);
        //设置内容
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
//        article.setContent(article.getContent().replaceAll("\n", ""));
        model.addAttribute(article);
        return "/editor/editor.jsp";
    }
    /**
     * 根据id删除文章
     */
    @RequestMapping(value = "/deleteArticle",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> deleteArticleById(String id){
        if(id=="0"){
            return new HashMap<String, String>(){{
                put("deleters", "error");
            }};
        }
        return new HashMap<String, String>(){{
            put("deleters", "ok");
        }};
    }
}
