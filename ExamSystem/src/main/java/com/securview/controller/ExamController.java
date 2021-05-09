package com.securview.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Exam;
import com.securview.model.Question;
import com.securview.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {

	Logger logger = Logger.getLogger(ExamController.class.getName());
	
	@Autowired
	private ExamService examService;

	@GetMapping("/")
	public List<Exam> getAllExams() {
		return examService.getAllExams();
	}

	@GetMapping("/{id}")
	public Exam getExamById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Exam exam = examService.getExamById(id);
		return exam;
	}

	@GetMapping("/{examId}/questions/")
	public List<Question> getQuestionsByExamById(@PathVariable("examId") Long examId) throws ResourceNotFoundException {
		List<Question> questions= examService.getQuestionsByExamById(examId);
		return questions;
	}

	
	@PostMapping("/")
	public Exam createExam(@RequestBody Exam exam) {
		return examService.createExam(exam);
	}
	
	@PutMapping("/")
	public Exam updateExam(@RequestBody Exam exam) throws ResourceNotFoundException {
		return examService.updateExam(exam);
	}

	@DeleteMapping("/{id}")
	public void deleteExamId(@PathVariable("id") Long id) throws ResourceNotFoundException {
		examService.deleteExamById(id);
	}

	
}
