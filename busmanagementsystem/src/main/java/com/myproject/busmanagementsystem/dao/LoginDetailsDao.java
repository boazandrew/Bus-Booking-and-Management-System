package com.myproject.busmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.Login;
import com.myproject.busmanagementsystem.repo.LoginDetailsRepo;

@Repository
public class LoginDetailsDao {

	@Autowired
	private LoginDetailsRepo loginDetailsRepo;

	public Optional<Login> findByEmail(String email) {
		return loginDetailsRepo.findByEmail(email);
	}

	public Login save(Login login) {
		return loginDetailsRepo.save(login);
	}

	public Optional<Login> getLoginDetailsByEmail(String email) {
		return loginDetailsRepo.findByEmail(email);
	}
}
