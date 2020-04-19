package com.ssp.apps.springcore.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("sit")
public class TestDataSource implements DataSource {

  public void getConnection() {
    System.out.println("== >> | Test | Data Source");
  }

  @PostConstruct
  public void init() {
    System.out.println("== >> |Test DataSource | Initialising Data Source");
  }

  @PreDestroy
  public void close() {
    System.out.println("== >> |Test DataSource | Closing Data Source");
  }

}
