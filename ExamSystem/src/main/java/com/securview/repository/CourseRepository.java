package com.securview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securview.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
