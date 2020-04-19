package com.ssp.aaps.springcore.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UatDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | UAT | Data Source");

  }

}
