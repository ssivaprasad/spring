package com.ssp.apps.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.ssp.apps.springcore.dao.DataSource;
import com.ssp.apps.springcore.dao.UatDataSource;

@Configuration
@Import({ControllerConfiguration.class, ServiceConfiguration.class, DaoConfiguration.class})
public class CustomConfiguration {

  @Bean
  public DataSource uatDataSource() {
    return new UatDataSource();
  }


}
