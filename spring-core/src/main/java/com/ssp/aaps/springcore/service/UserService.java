package com.ssp.aaps.springcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ssp.aaps.springcore.dao.UserDao;
import com.ssp.aaps.springcore.dto.User;

@Component
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private User userDetails;

  public void saveUser() {
    System.out.println("==>> Logged in User: " + System.identityHashCode(userDetails));
    userDao.createUser();
  }

}
