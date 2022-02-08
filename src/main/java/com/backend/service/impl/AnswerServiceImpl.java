package com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.AnswerDAO;
import com.backend.model.Answer;
import com.backend.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDAO answerDAO;

	@Override
	public Answer save(Answer answer) {
		return answerDAO.save(answer);
	}

	@Override
	public void delete(Integer id) {
		answerDAO.deleteById(id);

	}

	@Override
	public Answer findById(Integer id) {
		return answerDAO.findById(id).orElse(null);
	}

	@Override
	public List<Answer> findAll() {
		return (List<Answer>) answerDAO.findAll();
	}

}
