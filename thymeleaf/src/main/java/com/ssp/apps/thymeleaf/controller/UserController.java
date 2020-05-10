package com.ssp.apps.thymeleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssp.apps.thymeleaf.dto.UserDto;
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

    @RequestMapping
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", userMapper.conver2UserDtoList(users));
        return "users/user-list";
    }


    @RequestMapping("/view-user")
    public String viewUserDetails(ModelMap model, @RequestParam(name = "id") String userId) {
        log.info("== >> UserId: {}", userId);
        User user = userService.getUser(userId);
        model.addAttribute("pageOperation", "VIEW");
        model.addAttribute("isViewMode", true);
        model.addAttribute("user", userMapper.convert2Dto(user));
        return "users/view-user";
    }

    @RequestMapping("/create-user")
    public String createUser(ModelMap model) {
        model.addAttribute("user", new UserDto());
        return "users/create-user";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(ModelMap model, UserDto userDto) {
        userService.createUser(new User(userDto.getId(), userDto.getFirstName(),
                userDto.getLastName(), userDto.getAge(), userDto.getDateOfBirth()));
        return getAllUsers(model);
    }
}
