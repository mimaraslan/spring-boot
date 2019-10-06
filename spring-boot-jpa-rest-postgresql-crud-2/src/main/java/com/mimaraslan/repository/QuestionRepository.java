package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimaraslan.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}