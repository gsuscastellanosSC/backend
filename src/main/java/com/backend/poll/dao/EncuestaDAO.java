package com.backend.poll.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.poll.model.Encuesta;

public interface EncuestaDAO extends CrudRepository<Encuesta, Integer> {

}
