package com.ssp.aaps.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ssp.aaps.springcore.configuration.CustomConfiguration;
import com.ssp.aaps.springcore.controller.UserController;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);

    UserController userController = context.getBean("userController", UserController.class);
    userController.createuser();

    ((ConfigurableApplicationContext) context).close();

  }

}
