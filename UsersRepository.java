package com.cwm.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cwm.demo.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    boolean existsByUsername(String username);
    
    
    Optional<Users> findByUsername (String username);
}
