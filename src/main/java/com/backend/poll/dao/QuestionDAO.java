package com.backend.poll.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.poll.model.Question;

public interface QuestionDAO extends CrudRepository<Question, Integer> {

}
