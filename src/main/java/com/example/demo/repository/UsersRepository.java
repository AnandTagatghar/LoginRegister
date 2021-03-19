package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	public Users findByemailIgnoreCase(String email);
	
	@Query("from register r where r.email=:e and r.password=:p")
	public Users findBypassword(@Param("e") String email, @Param("p") String password);
}
