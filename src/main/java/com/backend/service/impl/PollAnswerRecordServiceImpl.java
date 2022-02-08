package com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.PollAnswerRecordDAO;
import com.backend.model.PollAnswerRecord;
import com.backend.service.PollAnswerRecordService;
import com.backend.util.Constant;

@Service
public class PollAnswerRecordServiceImpl implements PollAnswerRecordService {

	@Autowired
	private PollAnswerRecordDAO pollAnswerRecordDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public PollAnswerRecord save(PollAnswerRecord pollAnswerRecord) {
		return pollAnswerRecordDAO.save(pollAnswerRecord);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		pollAnswerRecordDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public PollAnswerRecord findById(Integer id) {
		return pollAnswerRecordDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<PollAnswerRecord> findAll() {
		return (List<PollAnswerRecord>) pollAnswerRecordDAO.findAll();
	}

}
