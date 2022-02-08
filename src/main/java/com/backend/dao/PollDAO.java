package com.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Poll;

@Repository
public interface PollDAO extends JpaRepository<Poll, Integer> {

}
