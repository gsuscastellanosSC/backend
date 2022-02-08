package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

}
