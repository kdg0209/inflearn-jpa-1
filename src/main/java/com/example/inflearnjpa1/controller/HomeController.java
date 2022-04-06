package com.example.inflearnjpa1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {


    @RequestMapping("/")
    public String home() {
        log.info("HomeController");
        return "home";
    }
}
