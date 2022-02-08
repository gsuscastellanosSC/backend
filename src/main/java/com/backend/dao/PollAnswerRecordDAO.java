package com.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.model.PollAnswerRecord;

public interface PollAnswerRecordDAO extends CrudRepository<PollAnswerRecord, Integer> {

}
