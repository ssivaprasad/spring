package com.ssp.aaps.springcore.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("uat")
public class UatDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | UAT | Data Source");

  }

}
