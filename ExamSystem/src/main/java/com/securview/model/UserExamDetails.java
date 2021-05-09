package com.securview.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
public class UserExamDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userExamId;

	@ManyToOne
	@JoinColumn(name = "examId")
	private Exam exam;

	@ManyToOne
	@JoinColumn(name = "userID")
	private Users userID;
	
	private String examStatus;
	private Timestamp examStartDate;
	private Timestamp examSubmitDate;
	
	private Long percentage;
	private String result;
}
