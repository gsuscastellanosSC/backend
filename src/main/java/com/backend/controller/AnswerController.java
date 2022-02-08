package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

}
