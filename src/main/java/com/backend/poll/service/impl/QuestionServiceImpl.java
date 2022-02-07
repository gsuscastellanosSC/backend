package com.backend.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.poll.dao.QuestionDAO;
import com.backend.poll.model.Question;
import com.backend.poll.service.QuestionService;
import com.backend.poll.util.Constant;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Question save(Question question) {
		return questionDAO.save(question);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		questionDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Question findById(Integer id) {
		return questionDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<Question> findAll() {
		return (List<Question>) questionDAO.findAll();
	}

}
