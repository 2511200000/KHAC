package com.khanhhq.learning.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanhhq.learning.model.UserDTO;
import com.khanhhq.learning.repository.UserRepository;
import com.khanhhq.learning.service.UserService;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
 	@Override
	 public List<UserDTO> searchUser(String email){
		 return userRepo.searchUserByEmail(email);
	 }
	@Override
	public void saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}
	@Override
	public void setStatusForUser(String email) {
		 userRepo.setStatusForUser(email);
	}
	@Override
	public UserDTO findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findUserByEmail(email);
	}
	@Override
	public void updateInfomation(String password, String role, String email) {
		// TODO Auto-generated method stub
		userRepo.updateInfomation(password, role, email);
	}
	 
 

	 

}
