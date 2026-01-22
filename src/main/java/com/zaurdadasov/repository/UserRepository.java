package com.zaurdadasov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaurdadasov.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
