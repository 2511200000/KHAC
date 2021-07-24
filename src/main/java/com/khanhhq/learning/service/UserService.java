package com.khanhhq.learning.service;

import java.util.List;

 
import com.khanhhq.learning.model.UserDTO;

 public interface UserService {
	List<UserDTO> getAll();

	List<UserDTO> searchUser(String email);
	
	void saveUser(UserDTO user);
	
	void setStatusForUser(String email);
	UserDTO findUserByEmail(String email);
	void updateInfomation(String password,String role,String email);
	 
}
