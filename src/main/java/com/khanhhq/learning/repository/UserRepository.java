package com.khanhhq.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khanhhq.learning.model.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String> {
	@Query(value = "Select * from [User] where email like %:email%", nativeQuery = true)
	List<UserDTO> searchUserByEmail(@Param("email") String email);
	@Transactional
	@Modifying
	@Query(value = "update [User] set status = 'false' where email = ?1", nativeQuery = true)
	void setStatusForUser(String email);
	UserDTO findUserByEmail(String email);
	@Transactional
	@Modifying
	@Query(value = "update [User] set password = ?1, role = ?2 where email = ?3", nativeQuery = true)
	void updateInfomation(String password,String role,String email);
	 
	
}
