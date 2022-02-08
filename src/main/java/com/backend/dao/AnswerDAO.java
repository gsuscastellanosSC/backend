package com.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.model.Answer;

public interface AnswerDAO extends CrudRepository<Answer, Integer> {

}
