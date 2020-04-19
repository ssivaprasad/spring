package com.ssp.aaps.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.ssp.aaps.springcore.dao.DataSource;
import com.ssp.aaps.springcore.dao.UatDataSource;

@Configuration
@ComponentScan("com.ssp.aaps.springcore")
public class CustomConfiguration {

  @Bean
  public DataSource uatDataSource() {
    return new UatDataSource();
  }


}
