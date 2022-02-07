package com.backend.service;

import java.util.List;

import com.backend.model.Question;

public interface QuestionService {

	public Question save(Question question);

	public void delete(Integer id);

	public Question findById(Integer id);

	public List<Question> findAll();
}
