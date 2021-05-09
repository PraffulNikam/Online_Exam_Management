package com.securview.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long examId;

	private String examName;
	private int totalQuestions;
	private int examDuration;
	private int passingScore;
	private Timestamp creatationDate;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "exam_question_set", joinColumns = { @JoinColumn(name = "exam_id") }, inverseJoinColumns = {
			@JoinColumn(name = "question_id") })
	private Set<Question> questions = new HashSet<>();


	@ManyToOne
	@JoinColumn(name = "course_aid")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "userID")
	private Users userID;

	
}
