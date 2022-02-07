package com.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.model.Poll;

public interface PollDAO extends CrudRepository<Poll, Integer> {

}
