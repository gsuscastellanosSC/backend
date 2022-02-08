package com.backend.model;

import java.io.Serializable;
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
import com.backend.util.QuestionTypeEnum;

@Entity
@Table(name = Constant.QUESTION)
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer question_id;
	private String question;
	private QuestionTypeEnum type;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = Constant.QUESTION_UNDERSCORE_ANSWER, joinColumns = {
			@JoinColumn(name = Constant.QUESTION_UNDERSCORE_ID) }, inverseJoinColumns = {
					@JoinColumn(name = Constant.ANSWER_UNDERSCORE_ID) })
	private List<Answer> answers = new ArrayList<>();

	private static final long serialVersionUID = Constant.ONE_LONG;

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionTypeEnum getType() {
		return type;
	}

	public void setType(QuestionTypeEnum type) {
		this.type = type;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answer) {
		this.answers = answer;
	}

}
