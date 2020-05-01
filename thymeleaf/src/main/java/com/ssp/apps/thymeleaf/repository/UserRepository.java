package com.ssp.apps.thymeleaf.repository;

import com.ssp.apps.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
