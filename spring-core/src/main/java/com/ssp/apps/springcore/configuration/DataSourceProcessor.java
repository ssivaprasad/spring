package com.ssp.apps.springcore.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.ssp.apps.springcore.dao.TestDataSource;

public class DataSourceProcessor implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof TestDataSource) {
      System.out.println("== >> post Process Before Initialization: " + beanName);
    }
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof TestDataSource) {
      System.out.println("== >> post Process After Initialization: " + beanName);
    }
    return bean;
  }

}
