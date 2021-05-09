package com.securview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securview.exceptions.ResourceNotFoundException;
import com.securview.model.Course;
import com.securview.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		Course entity = courseService.getCourseById(id);
		return new ResponseEntity<Course>(entity, HttpStatus.OK);
	}

	@PostMapping("/")
	public Course addCourse(@RequestBody Course user) {
		return courseService.addCourse(user);
	}
	
	@PutMapping("/")
	public Course updateCourse(@RequestBody Course course) throws ResourceNotFoundException {
		return courseService.updateCourse(course);
	}

	@DeleteMapping("/{id}")
	public void deleteCourseId(@PathVariable("id") Long id) throws ResourceNotFoundException {
		courseService.deleteCourseById(id);
	}

}
