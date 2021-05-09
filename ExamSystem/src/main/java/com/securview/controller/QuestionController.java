package com.securview.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Question;
import com.securview.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	Logger logger = Logger.getLogger(QuestionController.class.getName());
	@Autowired
	private QuestionService questionService;

	@GetMapping("/course/{courseId}")
	public List<Question> getQuestionByCourse(@PathVariable Long courseId) {
		return questionService.getQuestionsByCourse(courseId);
	}

	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Question question = questionService.getQuestionById(id);
		return question;
	}

	@PostMapping("/")
	public Question saveQuestion(@RequestBody Question user) throws ResourceNotFoundException {
		return questionService.addQuestion(user);
	}

	@DeleteMapping("/{id}")
	public void deleteQuestionId(@PathVariable("id") Long id) throws ResourceNotFoundException {
		questionService.deleteQuestionById(id);
	}

}
