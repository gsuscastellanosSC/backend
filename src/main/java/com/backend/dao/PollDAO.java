package com.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Poll;

@Repository
public interface PollDAO extends CrudRepository<Poll, Integer> {

}
