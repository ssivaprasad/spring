package com.ssp.aaps.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.ssp.aaps.springcore.dao.DataSource;
import com.ssp.aaps.springcore.dao.UatDataSource;

@Configuration
@Import({DaoConfiguration.class, ServiceConfiguration.class, ControllerConfiguration.class})
public class CustomConfiguration {

  @Bean
  public DataSource uatDataSource() {
    return new UatDataSource();
  }


}
