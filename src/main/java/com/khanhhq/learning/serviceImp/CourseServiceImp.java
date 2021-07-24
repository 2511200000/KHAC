package com.khanhhq.learning.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.khanhhq.learning.model.CourseDTO;
import com.khanhhq.learning.repository.CourseRepository;
import com.khanhhq.learning.service.CourseService;
 
@Service
public class CourseServiceImp implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public List<CourseDTO> getAll() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public void setStatusForCourse(String courseID) {
		// TODO Auto-generated method stub
		courseRepo.setStatusForCourse(courseID);
	}

	@Override
	public List<CourseDTO> searchCourse(String title) {
		// TODO Auto-generated method stub
		return courseRepo.searchCourseByTitle(title);
	}

	@Override
	public CourseDTO getCourseById(String courseID) {
		// TODO Auto-generated method stub
		  Optional<CourseDTO> optional = courseRepo.findById(courseID);
		  CourseDTO course = null;
	        if (optional.isPresent()) {
	        	course = optional.get();
	        } else {
	            throw new RuntimeException("Course not found for id: " + courseID);
	        }
	        return course;
	}

	 
	 

	 
	
}
