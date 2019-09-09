package com.cqgcxy.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/href")
public class HrefController {
    @RequestMapping("/list")
    public String hrefList(){
        return "student-list";
    }
}
