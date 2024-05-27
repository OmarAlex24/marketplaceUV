package com.omar.restapicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.restapicrud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByCarnetNumberIgnoreCase(String carnet);
}
