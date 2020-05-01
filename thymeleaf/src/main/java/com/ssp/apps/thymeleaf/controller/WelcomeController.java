package com.ssp.apps.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welome(ModelMap map) {
        map.addAttribute("userName", "Siva Prasad");
        return "welcome";
    }
}
