package com.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Question;

@Repository
public interface QuestionDAO extends CrudRepository<Question, Integer> {

}
