package com.weisucai.controller;

import com.weisucai.domain.User;
import com.weisucai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/user/register.html";
    }
    @RequestMapping(value = "/registerPro",method = RequestMethod.POST)
    @ResponseBody
    public Object registerPro(@RequestBody User user){
        System.out.println(user);
        int rs = 0;
        try {
            rs = userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(rs==1)
            return "ok";
        return "error";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        System.out.println("login");
        return "/user/login.html";
    }
    @RequestMapping(value = "/loginPro",method = RequestMethod.POST)
    public String loginPro(User user){
        return "";
    }
}
