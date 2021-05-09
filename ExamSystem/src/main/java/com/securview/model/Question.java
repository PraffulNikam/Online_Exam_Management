package com.securview.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	

	@Column(columnDefinition = "TEXT")
	private String questions;

	@Column(columnDefinition = "TEXT")
	private String option1;

	@Column(columnDefinition = "TEXT")
	private String option2;

	@Column(columnDefinition = "TEXT")
	private String option3;

	@Column(columnDefinition = "TEXT")
	private String option4;

	private String answer;
	private boolean ischeckbox;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "questions")
	private Set<Exam> exam = new HashSet<Exam>();

	

}
