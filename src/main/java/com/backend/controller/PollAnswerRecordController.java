package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.PollAnswerRecord;
import com.backend.service.PollAnswerRecordService;
import com.backend.service.UserService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class PollAnswerRecordController {

	@Autowired
	private PollAnswerRecordService pollAnswerRecordService;
	@Autowired
	private UserService userService;

	@PostMapping(Constant.SLASH_POLL_ANSWER_RECORDS)
	public PollAnswerRecord save(@RequestBody PollAnswerRecord pollAnswerRecord) {
		userService.save(pollAnswerRecord.getUser());
		return pollAnswerRecordService.save(pollAnswerRecord);
	}

	@GetMapping(Constant.SLASH_POLL_ANSWER_RECORDS)
	public List<PollAnswerRecord> findAll() {
		return pollAnswerRecordService.findAll();
	}

}
