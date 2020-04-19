package com.ssp.aaps.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ssp.aaps.springcore.configuration.CustomConfiguration;
import com.ssp.aaps.springcore.service.UserService;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);

    UserService userService = context.getBean("userService", UserService.class);
    userService.saveUser();

    ((ConfigurableApplicationContext) context).close();

  }

}
