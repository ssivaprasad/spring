package com.ssp.aaps.springcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.ssp.aaps.springcore.dao.DataSource;
import com.ssp.aaps.springcore.dao.UatDataSource;

@Configuration
@Import({ControllerConfiguration.class, ServiceConfiguration.class, DaoConfiguration.class})
public class CustomConfiguration {

  @Bean
  public DataSource uatDataSource() {
    return new UatDataSource();
  }


}
