package com.khanhhq.learning.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanhhq.learning.model.TeacherDTO;
import com.khanhhq.learning.repository.TeacherRepository;
import com.khanhhq.learning.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService{
	@Autowired
	private TeacherRepository teacherRepo;

	@Override
	public void saveTeacher(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		teacherRepo.save(teacher);
	}

	@Override
	public TeacherDTO teacherDetail(String email) {
		// TODO Auto-generated method stub
		return teacherRepo.teacherDetail(email);
	}

	@Override
	public void updateProfileTeacher(String fullName, String phone, String description, String email) {
		// TODO Auto-generated method stub
		teacherRepo.updateProfileTeacher(fullName, phone, description, email);
	}

	 
	
	
}
