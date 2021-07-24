package com.khanhhq.learning.controller;

  import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khanhhq.learning.model.AdminDTO;
import com.khanhhq.learning.model.StudentDTO;
import com.khanhhq.learning.model.TeacherDTO;
import com.khanhhq.learning.model.UserDTO;
import com.khanhhq.learning.service.AdminService;
import com.khanhhq.learning.service.StudentService;
import com.khanhhq.learning.service.TeacherService;
import com.khanhhq.learning.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;
	
	@Value("${image-path}")
	private String IMAGE_PATH;

	
	@RequestMapping(value = { "", "/", "/home" })
	public String homePage() {
		return "homeAdmin";
	}

	@RequestMapping(value = "/manageUser")
	public String manageUser(HttpSession session) {
		try {

			List<UserDTO> user = userService.getAll();
			session.setAttribute("LIST_USER", user);
		} catch (NumberFormatException e) {
			session.setAttribute("ERRORS", "User not exist!!");
		}
		return "listUser";
	}

	@RequestMapping("/searchUser")
	public String searchUser(HttpServletRequest request,HttpSession session, @RequestParam(name = "searchValue") String searchValue) {
		try {

			List<UserDTO> result = userService.searchUser(searchValue);
			if (!(result.isEmpty())) {
				request.setAttribute("SEARCH", result);
				session.setAttribute("SEARCH_VALUE", searchValue);
			} else {
				request.setAttribute("ERRORS", "User not exist!!!!!");
			}

		} catch (NumberFormatException e) {
			request.setAttribute("ERRORS", "User not exist!!!!!");
		}
		return "adminSearchUser";
	}

	@RequestMapping("/createUserPage")
	public String createUserPage() {
		return "createUser";
	}

	@PostMapping("/createUser")
	public String createUser(HttpServletRequest request, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "role") String role) {
		boolean status = true;
		if (email.trim().length() == 0 || password.trim().length() == 0 || confirmPass.trim().length() == 0) {
			request.setAttribute("ERROR_CREATE", "You must filled in all infomation");
			return "createUser";
		} else if (!password.trim().equals(confirmPass.trim())) {
			request.setAttribute("ERROR_CREATE", "Password invalid");
			return "createUser";
		} else {
			adminService.saveAdmin(new AdminDTO(email));
			studentService.saveStudent(new StudentDTO(email));
			teacherService.saveTeacher(new TeacherDTO(email));
			userService.saveUser(new UserDTO(email, password, role, status));
			return "redirect:/admin/manageUser";
		}

	}

	@RequestMapping("/setRoleUser/{email}")
	public String setRole(@PathVariable(name = "email") String email) {
		userService.setStatusForUser(email);
		return "redirect:/admin/manageUser";
	}
	@RequestMapping("/searchToDelete/{email}")
	public String searchToDelete(HttpSession session,@PathVariable(name = "email") String email) {
		userService.setStatusForUser(email);
		String searchValue = (String) session.getAttribute("SEARCH_VALUE");
 		return "redirect:/admin/searchUser?searchValue="+searchValue+"";
	}

	@RequestMapping("/user-details/{email}&{role}")
	public String viewDetailUser(@PathVariable(name = "email") String email, @PathVariable(name = "role") String role,
			HttpServletRequest request, HttpSession session) {
		UserDTO user = userService.findUserByEmail(email);
		if (role.equals("GV")) {
			TeacherDTO teacher = teacherService.teacherDetail(email);	
 			request.setAttribute("TEACHER_DETAIL", teacher);
			request.setAttribute("USER_DETAIL", user);
			session.setAttribute("EMAIL", email);
 		}else if(role.equals("HS")) {
 			StudentDTO student = studentService.studentDetail(email);
  			request.setAttribute("STUDENT_DETAIL", student);
			request.setAttribute("USER_DETAIL", user);
			session.setAttribute("EMAIL", email);
 		}else {
 			AdminDTO admin = adminService.adminDetail(email);
 			request.setAttribute("ADMIN_DETAIL", admin);
			request.setAttribute("USER_DETAIL", user);
			session.setAttribute("EMAIL", email);
 		}
		return "userDetail";
	}

	@RequestMapping("/updateProfileTeacher")
	public String updateProfileTeacher(@RequestParam(name = "fullName") String fullName,
			@RequestParam(name = "phone") String phone, @RequestParam(name = "description") String description,
			@RequestParam(name = "password") String password, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "role") String role, HttpSession session, HttpServletRequest request) {
		String email = (String) session.getAttribute("EMAIL");
 
		teacherService.updateProfileTeacher(fullName, phone, description, email);
		userService.updateInfomation(password, role, email);
//		return "redirect:/admin/user-details/" + email + "&" + roleCallBack + "";
		return "redirect:/admin/manageUser";

	}
	
	@PostMapping("/updateProfileStudent")
	public String updateProfileStudent(@RequestParam(name = "fullName") String fullName,
			@RequestParam(name = "phone") String phone, @RequestParam(name = "description") String description,
			@RequestParam(name = "password") String password, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "role") String role,@RequestParam(name = "interests") String interests,
			@RequestParam(name = "imgFile") MultipartFile file, @RequestParam(name = "image") String imageDB,
			HttpSession session, HttpServletRequest request) throws Exception  {
			String email = (String) session.getAttribute("EMAIL");
 			if(!file.isEmpty()) {
				byte[] bytes = file.getBytes();
		        String image = file.getOriginalFilename();
		        Path path = Paths.get(IMAGE_PATH + image);
	 	        Files.write(path, bytes);
			
			studentService.updateProfileStudent(fullName, phone, description, interests, image, email);
			userService.updateInfomation(password, role, email);
			}else {
			studentService.updateProfileStudent(fullName, phone, description, interests, imageDB, email);
			userService.updateInfomation(password, role, email);
			}
			
//		return "redirect:/admin/user-details/" + email + "&" + roleCallBack + "";
		return "redirect:/admin/manageUser";

	}
	
	@PostMapping("/updateProfileAdmin")
	public String updateProfileAdmin(@RequestParam(name = "fullName") String fullName,
			@RequestParam(name = "password") String password, @RequestParam(name = "confirmPass") String confirmPass,
			@RequestParam(name = "imgFile") MultipartFile file, @RequestParam(name = "image") String imageDB,
			HttpSession session, HttpServletRequest request) throws Exception  {
			String email = (String) session.getAttribute("EMAIL");
 			if(!file.isEmpty()) {
				byte[] bytes = file.getBytes();
		        String image = file.getOriginalFilename();
		        Path path = Paths.get(IMAGE_PATH + image);
	 	        Files.write(path, bytes);
			
	 	    adminService.updateProfileAdmin(fullName, image, email);
 			userService.updateInfomation(password, "AD", email);
			}else {
				adminService.updateProfileAdmin(fullName, imageDB, email);
 			userService.updateInfomation(password, "AD", email);
			}
			
//		return "redirect:/admin/user-details/" + email + "&" + roleCallBack + "";
		return "redirect:/admin/manageUser";

	}

}
