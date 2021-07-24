package com.khanhhq.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khanhhq.learning.model.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<StudentDTO, String> {
	@Query(value = "select * from [Student] where studentEmail in "
			+ "(select email from [User] where email = ?1)", nativeQuery = true)
	StudentDTO studentDetail(String email);
	@Transactional
	@Modifying
	@Query(value = "update [Student] set fullName = ?1, phone = ?2, description = ?3, interests = ?4, img = ?5 where studentEmail = ?6", nativeQuery = true)
	void updateProfileStudent(String fullName,String phone, String description,String interests,String img,String email);
}
