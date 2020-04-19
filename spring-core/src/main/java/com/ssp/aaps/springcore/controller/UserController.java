package com.ssp.aaps.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ssp.aaps.springcore.service.UserService;

@Controller
public class UserController {

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void createuser() {
    userService.saveUser();
  }



}
