package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Question;
import com.backend.service.QuestionService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@PostMapping(Constant.SLASH_QUESTIONS)
	public Question save(@RequestBody Question question) {
		return questionService.save(question);
	}

	@GetMapping(Constant.SLASH_QUESTIONS)
	public List<Question> findAll() {
		return questionService.findAll();

	}

	@GetMapping(Constant.SLASH_QUESTIONS_SLASH_BRACKET_ID_BRACKET)
	public Question update(@RequestBody Question question, @PathVariable Integer id) {

		Question questionUpdated = questionService.findById(id);

		questionUpdated.setQuestion(question.getQuestion());
		questionUpdated.setAnswer(question.getAnswer());
		questionUpdated.setType(question.getType());

		return questionService.save(questionUpdated);

	}

	@DeleteMapping(Constant.SLASH_QUESTIONS)
	public void delete(@PathVariable Integer id) {
		questionService.delete(id);
	}

}
