package com.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.PollDAO;
import com.backend.model.Poll;
import com.backend.service.PollService;
import com.backend.util.Constant;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	private PollDAO pollDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Poll save(Poll poll) {
		return pollDAO.save(poll);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		pollDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Poll findById(Integer id) {
		return pollDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<Poll> findAll() {
		return (List<Poll>) pollDAO.findAll();
	}

}
