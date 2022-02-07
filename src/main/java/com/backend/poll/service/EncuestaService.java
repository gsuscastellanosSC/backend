package com.backend.poll.service;

import java.util.List;

import com.backend.poll.model.Encuesta;

public interface EncuestaService {

	public Encuesta save(Encuesta poll);

	public void delete(Integer id);

	public Encuesta findById(Integer id);

	public List<Encuesta> findAll();

}
