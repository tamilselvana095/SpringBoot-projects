package com.angular.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
