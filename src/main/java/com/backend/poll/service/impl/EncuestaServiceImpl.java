package com.backend.poll.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.poll.dao.EncuestaDAO;
import com.backend.poll.model.Encuesta;
import com.backend.poll.service.EncuestaService;
import com.backend.poll.util.Constant;

@Service
public class EncuestaServiceImpl implements EncuestaService {

	@Autowired
	private EncuestaDAO pollDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Encuesta save(Encuesta poll) {
		return pollDAO.save(poll);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		pollDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Encuesta findById(Integer id) {
		return pollDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<Encuesta> findAll() {
		return (List<Encuesta>) pollDAO.findAll();
	}

}
