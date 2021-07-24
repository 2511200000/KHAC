package com.khanhhq.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.khanhhq.learning.model.CategoryDTO;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryDTO, String>{
	@Query(value = "select * from [Category] where categoryID in "
			+ "(select category from [Course])", nativeQuery = true)
	List<CategoryDTO> listCategory();
}
