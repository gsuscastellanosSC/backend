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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.backend.util.Constant;

@Entity
@Table(name = Constant.POLL)
public class Poll implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer poll_id;
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = Constant.RESTAURANT_UNDERSCORE_ID)
	private Restaurant restaurant;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = Constant.POLL_UNDERSCORE_QUESTION, joinColumns = {
			@JoinColumn(name = Constant.POLL_UNDERSCORE_ID) }, inverseJoinColumns = {
					@JoinColumn(name = Constant.QUESTION_UNDERSCORE_ID) })
	private List<Question> questions = new ArrayList<>();

	private static final long serialVersionUID = Constant.ONE_LONG;

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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
