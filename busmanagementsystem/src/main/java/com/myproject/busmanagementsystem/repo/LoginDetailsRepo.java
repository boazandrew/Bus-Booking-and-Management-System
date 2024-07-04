package com.myproject.busmanagementsystem.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.busmanagementsystem.dto.Login;

public interface LoginDetailsRepo extends JpaRepository<Login, String>{

	@Query("select l from Login l where l.email= :email")
	Optional<Login> findByEmail(@Param("email") String email);
}
