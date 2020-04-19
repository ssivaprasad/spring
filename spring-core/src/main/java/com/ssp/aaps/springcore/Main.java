package com.ssp.aaps.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ssp.aaps.springcore.configuration.CustomConfiguration;
import com.ssp.aaps.springcore.controller.UserController;
import com.ssp.aaps.springcore.dto.User;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);

    for (String name : context.getBeanDefinitionNames()) {
      System.out.println("Bean Name: " + name);
    }
    UserController userController = context.getBean("userController", UserController.class);
    userController.createuser();


    User user1 = context.getBean("user", User.class);
    User user2 = context.getBean("user", User.class);
    System.out.println("user1: " + System.identityHashCode(user1));
    System.out.println("user2: " + System.identityHashCode(user2));

    ((ConfigurableApplicationContext) context).close();

  }

}
