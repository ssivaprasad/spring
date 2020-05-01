package com.ssp.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.function.BiPredicate;


@Slf4j
@Controller
@RequestMapping("/login")
@SessionAttributes("userId")
public class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String submit(@RequestParam String userName, @RequestParam String password, ModelMap model) {
        log.info("== >> User Name: {} , Password: {}", userName, password);

        BiPredicate<String, String> biPredicate = (userId, pass) -> "in28Minutes".equals(userId) && "hello".equals(pass);
        if (!biPredicate.test(userName, password)) {
            model.addAttribute("invalidCredentials", "Bad Credentials.");
            return "login";
        }

        model.addAttribute("userId", userName);

        return "dashboard";
    }


}
