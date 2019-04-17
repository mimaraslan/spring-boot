package com.mimaraslan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimaraslan.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
