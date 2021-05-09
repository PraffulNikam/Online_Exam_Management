package com.securview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.securview.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

	@Query("SELECT s FROM Question s WHERE course_id = :courseIds")
	List<Question> findAllByCourse(@Param("courseIds") List<Long> courseIdList);

}
