package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimaraslan.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
