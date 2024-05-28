package com.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
