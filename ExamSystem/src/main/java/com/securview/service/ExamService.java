package com.securview.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Exam;
import com.securview.model.Question;
import com.securview.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}

	public Exam getExamById(Long id) throws ResourceNotFoundException {
		Optional<Exam> ExamOption = examRepository.findById(id);

		if (ExamOption.isPresent()) {
			return ExamOption.get();
		} else {
			throw new ResourceNotFoundException("does not exist for given id");
		}
	}

	public Exam createExam(Exam exam) {
		return examRepository.save(exam);
	}

	public Exam updateExam(Exam exam) throws ResourceNotFoundException {
		
		Optional<Exam> findExamById = examRepository.findById(exam.getExamId());
		if(findExamById.isPresent()) {
			return examRepository.save(exam);
		}else {
			throw new ResourceNotFoundException("No record exist for given exam id: "+exam.getExamId());
		}
	}

	public void deleteExamById(Long id) throws ResourceNotFoundException {
		Optional<Exam> exam = examRepository.findById(id);

		if (exam.isPresent()) {
			examRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("No record exist for given exam id");
		}
	}

	public List<Question> getQuestionsByExamById(Long examId) throws ResourceNotFoundException {
		List<Question> questionsList = examRepository.getQuestionsByExam(Arrays.asList(examId));
		return questionsList;
	}

}
