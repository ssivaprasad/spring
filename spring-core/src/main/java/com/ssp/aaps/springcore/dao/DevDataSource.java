package com.ssp.aaps.springcore.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile("dev")
public class DevDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | Dev | Data Source");

  }

}
