package com.weisucai.controller;

import com.weisucai.domain.User;
import com.weisucai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/isLogin",method = RequestMethod.POST)
    @ResponseBody
    public Integer isLogin(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return 0;
        }
        return 1;
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String exit(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        return "redirect:/index.html";
    }

}
