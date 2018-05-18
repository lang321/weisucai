package com.weisucai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/designer")
public class DesignerController {
    @RequestMapping("/index")
    public String index(){
        return "/designer/index.html";
    }
}
