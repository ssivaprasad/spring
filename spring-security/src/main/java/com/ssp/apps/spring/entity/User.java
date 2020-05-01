package com.ssp.apps.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @Column(name = "username")
  private String userName;
  
  @Column(name = "password")
  private String password;
  
  @Column(name = "enabled")
  private boolean active;
  
  
  private String roles;
  
}
