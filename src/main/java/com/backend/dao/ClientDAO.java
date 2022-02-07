package com.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.model.Client;

public interface ClientDAO extends CrudRepository<Client, Integer> {

}
