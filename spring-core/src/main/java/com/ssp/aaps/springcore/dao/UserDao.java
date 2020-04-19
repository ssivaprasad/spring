package com.ssp.aaps.springcore.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  public void createUser() {
    System.out.println("== >> UserDao: createUser");
  }

}
