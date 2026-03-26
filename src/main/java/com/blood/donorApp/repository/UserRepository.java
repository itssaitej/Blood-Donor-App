package com.blood.donorApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blood.donorApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByUsername(String username);
}

