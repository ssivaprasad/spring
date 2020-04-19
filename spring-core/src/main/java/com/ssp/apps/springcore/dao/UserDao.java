package com.ssp.apps.springcore.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  @Autowired
  // @Qualifier("testDataSource")
  private DataSource dataSource;


  @Autowired
  private List<DataSource> dataSources;

  public void createUser() {
    dataSource.getConnection();
    System.out.println("== >> UserDao: createUser");
  }

}
