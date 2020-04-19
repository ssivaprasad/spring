package com.ssp.aaps.springcore.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DevDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | Dev | Data Source");

  }

}
