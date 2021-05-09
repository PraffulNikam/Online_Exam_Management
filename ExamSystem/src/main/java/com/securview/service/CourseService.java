package com.securview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Course;
import com.securview.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	public Course getCourseById(Long id) throws ResourceNotFoundException {
		Course course = courseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found for this id: "+id));
		return course;
	}

	public Course addCourse(Course exam) {
		return courseRepository.save(exam);
	}
	
	public Course updateCourse(Course course) throws ResourceNotFoundException {
		Optional<Course> courseById = courseRepository.findById(course.getCourseId());
		//courseById.map(o->courseRepository.save(course)).orElseThrow((Supplier<? extends X>) new ResourceNotFoundException("")); //).orElseThrow(new ResourceNotFoundException("this course Id is not exist"));
		if (courseById.isPresent()) {
			return courseRepository.save(course);
		} else {
			System.out.println("This course Id is not exist:"+course.getCourseId());
			throw new ResourceNotFoundException("This course Id is not exist: "+course.getCourseId());
		}
	}

	public void deleteCourseById(Long id) throws ResourceNotFoundException {
		Optional<Course> exam = courseRepository.findById(id);

		if (exam.isPresent()) {
			courseRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("No record exist for given id");
		}
	}

	

}
