package com.khanhhq.learning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khanhhq.learning.model.CategoryDTO;
import com.khanhhq.learning.model.CourseDTO;
 import com.khanhhq.learning.service.CategoryService;
import com.khanhhq.learning.service.CourseService;
  
@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired 
	private CategoryService categoryService;
	
	@RequestMapping("/manageCourse")
	public String manageCourse(HttpSession session) {
		try {
			List<CourseDTO> course = courseService.getAll();
			List<CategoryDTO> category = categoryService.listCategory();
			System.out.println(category);
 			session.setAttribute("LIST_COURSE", course);
 			session.setAttribute("LIST_CATEGORY", category);
		} catch (NumberFormatException e) {
			session.setAttribute("ERRORS", "Course not exist!!");
		}
		return "listCourse";
	}
	
	@RequestMapping("/searchCourse")
	public String searchUser(HttpServletRequest request,HttpSession session, @RequestParam(name = "searchValue") String searchValue) {
		try {
			System.out.println("2312 " + searchValue);
			List<CourseDTO> result = courseService.searchCourse(searchValue);
			if (!(result.isEmpty())) {
				request.setAttribute("SEARCH", result);
				session.setAttribute("SEARCH_VALUE", searchValue);
			} else {
				request.setAttribute("ERRORS", "Course not exist!!!!!");
			}

		} catch (NumberFormatException e) {
			request.setAttribute("ERRORS", "Course not exist!!!!!");
		}
		return "adminSearchCourse";
	}
	
	@RequestMapping("/setRoleCourse/{courseID}")
	public String setRole(@PathVariable(name = "courseID") String courseID) {
		courseService.setStatusForCourse(courseID);
		return "redirect:/course/manageCourse";
	}
	@RequestMapping("/searchToDelete/{courseID}")
	public String searchToDelete(HttpSession session,@PathVariable(name = "courseID") String courseID) {
		courseService.setStatusForCourse(courseID);
		String searchValue = (String) session.getAttribute("SEARCH_VALUE");
 		return "redirect:/course/searchCourse?searchValue="+searchValue+"";
	}
	
	@RequestMapping("/courseDetail/{courseID}")
	public String courseDetail(@PathVariable(name="courseID") String courseID,HttpServletRequest request) {
		 try {
	            CourseDTO course = courseService.getCourseById(courseID);
	            request.setAttribute("COURSE_DETAIL", course);
	        } catch (NumberFormatException e) {
	            request.setAttribute("ERRORS", "Course not exist!!");
	        }
	        return "courseDetail";
	}
	
}
