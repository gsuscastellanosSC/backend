package com.backend.poll.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.poll.model.Client;

public interface ClientDAO extends CrudRepository<Client, Integer> {

}
