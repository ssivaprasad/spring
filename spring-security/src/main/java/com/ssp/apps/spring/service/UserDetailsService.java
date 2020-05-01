package com.ssp.apps.spring.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ssp.apps.spring.dto.UserPrincipal;
import com.ssp.apps.spring.entity.User;
import com.ssp.apps.spring.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsService
    implements org.springframework.security.core.userdetails.UserDetailsService {

  @Autowired
  private UserDetailsRepository userDetailsRepository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    log.info("== >> Trying to get UserDetails From DB:");
    Optional<User> user = userDetailsRepository.findByUserName(userName);
    user.orElseThrow(() -> new UsernameNotFoundException("No User found with name: " + userName));
    return user.map(UserPrincipal::new).get();
  }
}
