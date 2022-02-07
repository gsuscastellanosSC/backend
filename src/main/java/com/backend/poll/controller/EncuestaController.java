package com.backend.poll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.poll.model.Encuesta;
import com.backend.poll.service.EncuestaService;
import com.backend.poll.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class EncuestaController {

	@Autowired
	private EncuestaService encuestaService;

	@PostMapping(Constant.SLASH_ENCUESTAS)
	public Encuesta save(@RequestBody Encuesta poll) {
		return encuestaService.save(poll);
	}

	@GetMapping(Constant.SLASH_ENCUESTAS)
	public List<Encuesta> findAll() {
		return encuestaService.findAll();
	}

	@GetMapping(Constant.SLASH_ENCUESTAS_SLASH_BRACKET_ID_BRACKET)
	public Encuesta findById(@PathVariable Integer id) {
		return encuestaService.findById(id);
	}

	@PutMapping(Constant.SLASH_ENCUESTAS_SLASH_BRACKET_ID_BRACKET)
	public Encuesta update(@RequestBody Encuesta poll, @PathVariable Integer id) {

		Encuesta encuestaUpdated = encuestaService.findById(poll.getId());

		encuestaUpdated.setName(poll.getName());

		return encuestaService.save(encuestaUpdated);
	}

	@DeleteMapping(Constant.SLASH_ENCUESTAS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		encuestaService.delete(id);
	}

}
