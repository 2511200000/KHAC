package com.khanhhq.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khanhhq.learning.model.TeacherDTO;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherDTO, String> {
	@Query(value = "select * from [Teacher] where teacherEmail in "
			+ "(select email from [User] where email = ?1)", nativeQuery = true)
	TeacherDTO teacherDetail(String email);
	@Transactional
	@Modifying
	@Query(value = "update [Teacher] set fullName = ?1, phone = ?2, description = ?3 where teacherEmail = ?4", nativeQuery = true)
	void updateProfileTeacher(String fullName,String phone, String description,String email);
}
