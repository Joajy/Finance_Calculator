package com.finance.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/deposit")
    public String deposit(){
        return "deposit";
    }

    @GetMapping("/loan")
    public String loan(){
        return "loan";
    }

    @GetMapping("/saving")
    public String saving(){
        return "saving";
    }

}
