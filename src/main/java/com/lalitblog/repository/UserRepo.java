package com.lalitblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalitblog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
