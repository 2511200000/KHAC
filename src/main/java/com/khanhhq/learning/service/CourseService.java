package com.khanhhq.learning.service;

import java.util.List;

 
import com.khanhhq.learning.model.CourseDTO;

public interface CourseService {
	List<CourseDTO> getAll();
	void setStatusForCourse(String courseID);
	List<CourseDTO> searchCourse(String title);
	CourseDTO getCourseById(String courseID);
	
 }
