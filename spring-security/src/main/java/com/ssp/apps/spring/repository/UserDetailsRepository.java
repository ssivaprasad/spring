package com.ssp.apps.spring.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.ssp.apps.spring.entity.User;

public interface UserDetailsRepository extends CrudRepository<User, Integer> {

  Optional<User> findByUserName(String userName);

}
