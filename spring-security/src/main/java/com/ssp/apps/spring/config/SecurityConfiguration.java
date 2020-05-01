package com.ssp.apps.spring.config;

import javax.sql.DataSource;

import com.ssp.apps.spring.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserDetailsService userDetailsService;

  // @formatter:off
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   /* 
    * With Spring Security Default Schema and Default UserDetailsService
    * 
    * auth.jdbcAuthentication().dataSource(dataSource);
    * */
    
   /* 
    * With Spring Security Custom Database table names and Structures and Default UserDetailsService  
    * 
    * auth.jdbcAuthentication().dataSource(dataSource)
    .usersByUsernameQuery("select username,password,enabled from Users where username = ?")
    .authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
    */
    
    
    auth.userDetailsService(userDetailsService);
  }
  //@formatter:on

  // @formatter:off
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
    .antMatchers("/admin").hasRole("ADMIN")
    .antMatchers("/users").hasAnyRole("USER", "ADMIN")
    .antMatchers("/","/ssp/authenticate").permitAll().and()
    .formLogin();
  }
  //@formatter:on


  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
