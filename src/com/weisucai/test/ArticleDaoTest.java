package com.weisucai.test;

import com.weisucai.dao.AreaDao;
import com.weisucai.dao.ArticleDao;
import com.weisucai.domain.Area;
import com.weisucai.domain.Article;
import com.weisucai.domain.User;
import net.sf.cglib.core.Local;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.HtmlUtils;

import java.net.Inet4Address;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void findById() {
        int id = 1;
        Article article = new Article();
        article.setId(id);
        Article rs = articleDao.selectById(article);
        System.out.println(rs);
        System.out.println(rs.getOwer());
    }

    //分页
    @Test
    public void fenye() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageIndex", 1);
        params.put("pageSize", 2);
        params.put("area",1);
        params.put("original",1);
        params.put("keyWord","tit");
        params.put("time",100);
        List<Article> rs = articleDao.selectRange(params);
        System.out.println("共有" + rs.size() + "条数据");
        System.out.println(rs);
//        System.out.println(rs.get(0).getOwer());
//        System.out.println(rs.get(0).getShortDate());
    }
    //获取数据总条数
    @Test
    public void getNumber() {
        Map<String, Object> params = new HashMap<>();
        params.put("area",1);
        params.put("original",1);
        params.put("time",100);
        Integer rs = articleDao.getNumber(params);
        System.out.println("共有" + rs + "条数据");
        System.out.println(rs);
    }

    //添加文章
    @Test
    public void add() {
        Article article = new Article();
        Area area = new Area();
        area.setId(1);
        article.setArea(area);
        article.setType("图文");
        article.setOriginal(1);
        article.setTitle("title  afdsafds");
        article.setContent("content");
        article.setPrice(1);
        article.setReleaseTime(LocalDateTime.now());
        User user = new User();
        user.setId(7);
        article.setOwer(user);

        System.out.println(article.getId());
        System.out.println("----");
        Integer rs = articleDao.add(article);
        System.out.println(rs);
        System.out.println(article.getId());
    }

    @Test
    public void test1(){
//        System.out.println(Math.floor(1.33));
//        String s = HtmlUtils.htmlEscape("<html>fdsa</html>");
//        String s1 = HtmlUtils.htmlUnescape(s);
//        System.out.println(s);
//        System.out.println(s1);

        String name = UUID.randomUUID().toString();
        System.out.println(name);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));

    }

}
