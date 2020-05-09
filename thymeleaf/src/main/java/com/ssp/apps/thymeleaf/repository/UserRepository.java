package com.ssp.apps.thymeleaf.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ssp.apps.thymeleaf.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByFirstName(String firstName);

}
