package com.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.backend.util.Constant;

@Entity
@Table(name = Constant.POLL_ANSWER_RECORD)
public class PollAnswerRecord implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer poll_answer_record_id;

	@ManyToOne(optional = false)
	@JoinColumn(name = Constant.POLL_UNDERSCORE_ID)
	private Poll poll;

	@ManyToOne(optional = false)
	@JoinColumn(name = Constant.USER_UNDERSCORE_ID)
	private User user;

	private static final long serialVersionUID = Constant.ONE_LONG;

	public Integer getPoll_answer_record_id() {
		return poll_answer_record_id;
	}

	public void setPoll_answer_record_id(Integer poll_answer_record_id) {
		this.poll_answer_record_id = poll_answer_record_id;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
