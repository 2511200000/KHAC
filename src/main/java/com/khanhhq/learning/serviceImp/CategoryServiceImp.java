package com.khanhhq.learning.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanhhq.learning.model.CategoryDTO;
import com.khanhhq.learning.repository.CategoryRepository;
import com.khanhhq.learning.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<CategoryDTO> listCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.listCategory();
	}

}
