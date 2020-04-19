package com.ssp.aaps.springcore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  @Autowired
  @Qualifier("testDataSource")
  private DataSource dataSource;

  public void createUser() {
    System.out.println("== >> UserDao: createUser");
  }

}
