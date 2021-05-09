package com.securview.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class ExamResult {

	@EmbeddedId
	private ExamResultId id; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("questionId")
	private Question question;

	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("userExamId")
	private UserExamDetails userAllocatedExam;


	@Column(columnDefinition = "TEXT")
	private String answer;
	private boolean isCorrect;
}
