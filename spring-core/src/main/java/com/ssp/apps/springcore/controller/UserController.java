package com.ssp.apps.springcore.controller;

import org.springframework.stereotype.Controller;
import com.ssp.apps.springcore.dto.User;
import com.ssp.apps.springcore.service.UserService;

@Controller
public class UserController {

  private UserService userService;

  private User userDetails;

  public UserController(UserService userService, User userDetails) {
    this.userService = userService;
    this.userDetails = userDetails;
  }


  /*
   * @Autowired public void setUserService(UserService userService) { this.userService =
   * userService; }
   */

  public void createuser() {
    System.out.println("==>> Logged in User: " + System.identityHashCode(userDetails));
    userService.saveUser();
  }



}
