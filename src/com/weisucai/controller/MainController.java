package com.weisucai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/header")
    public String header(){
        return "/header.html";
    }
    @RequestMapping(value = "/footer")
    public String footer(){
        return "/footer.html";
    }
//    如何赚钱
    @RequestMapping("/mkMoney")
    public String mkMoney(){
        return "/mkMoney.html";
    }
}
