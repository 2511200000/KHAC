package com.khanhhq.learning.serviceImp;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanhhq.learning.model.AdminDTO;
import com.khanhhq.learning.repository.AdminRepository;
import com.khanhhq.learning.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public void saveAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
		adminRepo.save(admin);
	}

	@Override
	public AdminDTO adminDetail(String email) {
		// TODO Auto-generated method stub
		return adminRepo.adminDetail(email);
	}

	@Override
	public void updateProfileAdmin(String fullName, String image, String email) {
		// TODO Auto-generated method stub
		adminRepo.updateProfileAdmin(fullName, image, email);
	}

	 

}
