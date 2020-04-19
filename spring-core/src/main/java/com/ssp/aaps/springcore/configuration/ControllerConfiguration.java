package com.ssp.aaps.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.ssp.aaps.springcore.dto.User;

@Configuration
@ComponentScan("com.ssp.aaps.springcore.controller")
public class ControllerConfiguration {


  @Bean
  public DataSourceProcessor dataSourceProcessor() {
    return new DataSourceProcessor();
  }

  @Bean
  @Scope("prototype")
  public User user() {
    return new User("Siva", "Very Secret");
  }
}
