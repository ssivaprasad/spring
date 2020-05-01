package com.ssp.apps.thymeleaf.controller;

import com.ssp.apps.thymeleaf.dto.UserDto;
import com.ssp.apps.thymeleaf.entity.User;
import com.ssp.apps.thymeleaf.mapper.UserMapper;
import com.ssp.apps.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String getAllUsers(ModelMap model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", userMapper.conver2UserDtoList(users));
        return "user-list";
    }


    @GetMapping("view-user")
    public String viewUserDetails(ModelMap model) {
        UserDto userDto = new UserDto(UUID.randomUUID().toString(), "Siva", "Somarouthu", 31, new Date());
        model.addAttribute("user", userDto);
        return "view-user";
    }
}
