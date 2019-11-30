package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faq_id")
	private int id;
	
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faq(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Faq [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "faq_question")
	private String question;
	
	@Column(name = "faq_answer")
	private String answer;

}
