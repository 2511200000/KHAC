package com.khanhhq.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khanhhq.learning.model.AdminDTO;

@Repository
public interface AdminRepository extends JpaRepository<AdminDTO, String>{
	@Query(value = "select * from [Admin] where adminEmail in "
			+ "(select email from [User] where email = ?1)", nativeQuery = true)
	AdminDTO adminDetail(String email);
	@Transactional
	@Modifying
	@Query(value = "update [Admin] set fullName = ?1, img = ?2 where adminEmail = ?3", nativeQuery = true)
	void updateProfileAdmin(String fullName,String image,String email);
}
