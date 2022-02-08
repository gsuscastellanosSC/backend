package com.backend.service;

import java.util.List;

import com.backend.model.PollAnswerRecord;

public interface PollAnswerRecordService {

	public PollAnswerRecord save(PollAnswerRecord pollAnswerRecord);

	public void delete(Integer id);

	public PollAnswerRecord findById(Integer id);

	public List<PollAnswerRecord> findAll();

}
