package com.ssp.apps.thymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssp.apps.thymeleaf.entity.User;
import com.ssp.apps.thymeleaf.mapper.UserMapper;
import com.ssp.apps.thymeleaf.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", userMapper.conver2UserDtoList(users));
        return "user-list";
    }


    @GetMapping("view-user")
    public String viewUserDetails(ModelMap model, @RequestParam(name = "id") String userId) {
        log.info("== >> UserId: {}", userId);
        User user = userService.getUser(userId);
        model.addAttribute("user", userMapper.convert2Dto(user));
        return "view-user";
    }
}
