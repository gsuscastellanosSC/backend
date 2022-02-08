package com.backend.controller;

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

import com.backend.model.Answer;
import com.backend.service.AnswerService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@PostMapping(Constant.SLASH_ANSWERS)
	public Answer save(@RequestBody Answer answer) {
		return answerService.save(answer);
	}

	@GetMapping(Constant.SLASH_ANSWERS)
	public List<Answer> findAll() {
		return answerService.findAll();
	}

	@GetMapping(Constant.SLASH_ANSWERS_SLASH_BRACKET_ID_BRACKET)
	public Answer findById(@PathVariable Integer id) {
		return answerService.findById(id);
	}

	@PutMapping(Constant.SLASH_ANSWERS_SLASH_BRACKET_ID_BRACKET)
	public Answer update(@RequestBody Answer answer, @PathVariable Integer id) {

		Answer answerServiceUpdated = answerService.findById(id);
		answerServiceUpdated.setAnswer(answer.getAnswer());

		return answerService.save(answerServiceUpdated);
	}

	@DeleteMapping(Constant.SLASH_ANSWERS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		answerService.delete(id);
	}

}
