package com.backend.dao;

import org.springframework.data.repository.CrudRepository;
import com.backend.model.Question;

public interface QuestionDAO extends CrudRepository<Question, Integer> {

}
