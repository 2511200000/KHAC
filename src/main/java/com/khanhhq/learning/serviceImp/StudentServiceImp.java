package com.khanhhq.learning.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanhhq.learning.model.StudentDTO;
import com.khanhhq.learning.repository.StudentRepository;
import com.khanhhq.learning.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void saveStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

	@Override
	public StudentDTO studentDetail(String email) {
		// TODO Auto-generated method stub
		return studentRepo.studentDetail(email);
	}

	@Override
	public void updateProfileStudent(String fullName, String phone, String description, String interests, String img,
			String email) {
		// TODO Auto-generated method stub
		studentRepo.updateProfileStudent(fullName, phone, description, interests, img, email);
	}

	 

	 

}
