package com.backend.controller;

import java.util.ArrayList;
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

import com.backend.model.Poll;
import com.backend.model.Question;
import com.backend.service.PollService;
import com.backend.service.QuestionService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class PollController {

	@Autowired
	private PollService pollService;

	@Autowired
	private QuestionService questionService;

	@PostMapping(Constant.SLASH_POLLS)
	public List<Poll> save(@RequestBody Poll poll) {

		Poll pollAns = pollService.save(poll);
		List<Poll> pollList = new ArrayList<>();

		List<Question> questions = poll.getQuestion();
		List<Question> questionsSave = new ArrayList<>();

		for (Question question : questions) {
			questionsSave.add(questionService.save(question));
		}

		pollAns.setQuestion(questionsSave);

		pollList.add(pollAns);

		return pollList;
	}

	@GetMapping(Constant.SLASH_POLLS)
	public List<Poll> findAll() {
		return pollService.findAll();
	}

	@GetMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public Poll findById(@PathVariable Integer id) {
		return pollService.findById(id);
	}

	@PutMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public Poll update(@RequestBody Poll poll, @PathVariable Integer id) {

		Poll encuestaUpdated = pollService.findById(poll.getPoll_id());

		encuestaUpdated.setName(poll.getName());
		Question questionUpdated = new Question();
		List<Question> questionList = new ArrayList<>();
		List<Question> questions = poll.getQuestion();

		for (Question questionIndex : questions) {
			questionUpdated.setQuestion(questionIndex.getQuestion());
			questionUpdated.setAnswer(questionIndex.getAnswer());
			questionUpdated.setType(questionIndex.getType());
			questionList.add(questionService.save(questionUpdated));

		}
		encuestaUpdated.setQuestion(questionList);
		return pollService.save(encuestaUpdated);
	}

	@DeleteMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		pollService.delete(id);
	}

}
