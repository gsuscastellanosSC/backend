package com.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.backend.util.Constant;

@Entity
@Table(name = Constant.POLL)
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer poll_id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "poll_question", joinColumns = { @JoinColumn(name = "poll_id") }, inverseJoinColumns = {
			@JoinColumn(name = "question_id") })
	private List<Question> question = new ArrayList<>();

	public Poll() {

	}

	public Integer getPoll_id() {
		return poll_id;
	}

	public void setPoll_id(Integer poll_id) {
		this.poll_id = poll_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

}
