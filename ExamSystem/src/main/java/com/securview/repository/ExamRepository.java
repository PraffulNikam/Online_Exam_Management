package com.securview.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.securview.model.Exam;
import com.securview.model.Question;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

	@Query("SELECT q FROM Exam e JOIN e.questions q WHERE e.examId = :examId")
	List<Question> getQuestionsByExam(@Param("examId") List<Long> examIdList);

	
}