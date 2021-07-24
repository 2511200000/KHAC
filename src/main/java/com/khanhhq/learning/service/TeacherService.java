package com.khanhhq.learning.service;

import com.khanhhq.learning.model.TeacherDTO;

public interface TeacherService {
	void saveTeacher(TeacherDTO teacher);
	public TeacherDTO teacherDetail(String email);
	void updateProfileTeacher(String fullName,String phone, String description,String email);
}
