package com.weisucai.controller;

import com.weisucai.domain.User;
import com.weisucai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/user/register.html";
    }

    @RequestMapping(value = "/registerPro", method = RequestMethod.POST)
    @ResponseBody
    public Object registerPro(@RequestBody User user) {
        System.out.println(user);
        int rs = 0;
        try {
            rs = userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs == 1)
            return "ok";
        return "error";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("login");
        return "/user/login.html";
    }

    @RequestMapping(value = "/loginPro", method = RequestMethod.POST)
    @ResponseBody
    public Object loginPro(@RequestBody User user, HttpSession session) {
        Map<String, String> rs = new HashMap<String, String>();
        User u = userService.login(user);
        if (u != null) {
            session.setAttribute("user",u);
            rs.put("Status", "ok");
        }else{
            rs.put("Status", "error");
        }
        return rs;
    }


    @RequestMapping(value = "/loginTest", method = RequestMethod.GET)
    public void index(HttpServletResponse response) throws IOException, InterruptedException {
        System.out.println("login");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('登录成功123');window.location.href='/index.html'</script>");
        out.flush();
    }

}
