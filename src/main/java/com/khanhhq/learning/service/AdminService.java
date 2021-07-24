package com.khanhhq.learning.service;

 
import com.khanhhq.learning.model.AdminDTO;

public interface AdminService {
	void saveAdmin(AdminDTO admin);
	AdminDTO adminDetail(String email);
	void updateProfileAdmin(String fullName,String image,String email);
	 
}
