package com.khanhhq.learning.service;

import com.khanhhq.learning.model.StudentDTO;

public interface StudentService {
	void saveStudent(StudentDTO student);
	StudentDTO studentDetail(String email);
	void updateProfileStudent(String fullName,String phone, String description,String interests,String img,String email);
 }
