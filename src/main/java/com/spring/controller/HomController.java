package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by binlix26 on 4/06/17.
 */
@Controller
public class HomController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
