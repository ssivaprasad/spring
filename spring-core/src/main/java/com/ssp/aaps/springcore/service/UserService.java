package com.ssp.aaps.springcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ssp.aaps.springcore.dao.UserDao;

@Component
public class UserService {

  @Autowired
  private UserDao userDao;

  public void saveUser() {
    userDao.createUser();
  }

}
