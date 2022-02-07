package com.backend.service;

import java.util.List;

import com.backend.model.Poll;

public interface PollService {

	public Poll save(Poll poll);

	public void delete(Integer id);

	public Poll findById(Integer id);

	public List<Poll> findAll();

}
