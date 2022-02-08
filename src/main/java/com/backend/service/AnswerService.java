package com.backend.service;

import java.util.List;

import com.backend.model.Answer;

public interface AnswerService {

	public Answer save(Answer answer);

	public void delete(Integer id);

	public Answer findById(Integer id);

	public List<Answer> findAll();

}
