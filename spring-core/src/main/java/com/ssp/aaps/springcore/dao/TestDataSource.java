package com.ssp.aaps.springcore.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | Test | Data Source");

  }

}
