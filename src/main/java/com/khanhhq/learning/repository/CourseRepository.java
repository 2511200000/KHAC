package com.khanhhq.learning.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khanhhq.learning.model.CourseDTO;
 
@Repository
public interface CourseRepository extends JpaRepository<CourseDTO, String>{
	@Transactional
	@Modifying
	@Query(value = "update [Course] set status = 'false' where courseID = ?1", nativeQuery = true)
	void setStatusForCourse(String courseID);
	@Query(value = "Select * from [Course] where title like %:title%", nativeQuery = true)
	List<CourseDTO> searchCourseByTitle(@Param("title") String title);
}
