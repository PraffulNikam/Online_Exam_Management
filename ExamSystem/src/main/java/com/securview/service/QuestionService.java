package com.securview.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Question;
import com.securview.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	
	public List<Question> getQuestionsByCourse(Long courseId) {
		List<Question> questionList = questionRepository.findAllByCourse(Arrays.asList(courseId));
		return questionList;
	}

	public Question getQuestionById(Long id) throws ResourceNotFoundException {
		Optional<Question> questionOption = questionRepository.findById(id);

		if (questionOption.isPresent()) {
			return questionOption.get();
		} else {
			throw new ResourceNotFoundException("This question is not exist : "+id);
		}
	}


	public Question addQuestion(Question exam) throws ResourceNotFoundException {

		Optional<Question> questionOption = questionRepository.findById(exam.getQuestionId());

		if (questionOption.isPresent()) {
			return questionRepository.save(exam);
		} else {
			throw new ResourceNotFoundException("This question is not exist : "+exam.getQuestionId());
		}
		
	}

	public Question updateUpdate(Question exam) {

		return questionRepository.save(exam);
	}

	public void deleteQuestionById(Long id) throws ResourceNotFoundException {
		Optional<Question> questionId = questionRepository.findById(id);

		if (questionId.isPresent()) {
			questionRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("No record exist for given id");
		}
	}

}
