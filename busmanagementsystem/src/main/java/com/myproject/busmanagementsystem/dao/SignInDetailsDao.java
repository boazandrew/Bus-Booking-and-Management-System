package com.myproject.busmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.SignIn;
import com.myproject.busmanagementsystem.repo.SignInDetailsRepo;

//responsible for interacting with the database.
@Repository
public class SignInDetailsDao {
	
	// Encapsulate the data access logic of Booking Details 
	//Implementing the CRUD operations
	//provide abstraction layer between business and database it make easy to maintain and test
			
	//@Autowired is an annotation in Spring that automatically injects the required dependency into a class field or constructor
	@Autowired
	private SignInDetailsRepo signInDetailsRepo;

	//Save
	public SignIn saveSignInDetails(SignIn signIn) {
		return signInDetailsRepo.save(signIn);
	}

	//Update
	public SignIn updateSignInDetails(int id, SignIn signIn) {
		if (signInDetailsRepo.findById(id).isPresent()) {
			signIn.setId(id);
			return signInDetailsRepo.save(signIn);
		} else {
			return null;
		}
	}

	//Delete
	public SignIn deleteSignInDetails(int id) {
		Optional<SignIn> optionalSignInDetails = signInDetailsRepo.findById(id);
		if (signInDetailsRepo.findById(id).isPresent()) {
			SignIn signIn=optionalSignInDetails.get();
			signInDetailsRepo.delete(signIn);
			return signIn;
		} else {
			return null;
		}
	}

	//Get SignIn Details by using id
	public Optional<SignIn> getSignInDetailsById(int id) {
		return signInDetailsRepo.findById(id);
	}

	//Get SignIn Details by using Name
	public SignIn getSignInDetailsByName(String signInName) {
		return signInDetailsRepo.findSignInDetailsByName(signInName);
	}

	//Get SignIn Details by using Phone Number
	public SignIn getSignInDetailsByPhoneNumber(String phoneNum) {
		return signInDetailsRepo.findSignIndetailsByPhoneNumber(phoneNum);
	}

	//Get SignIn Details By using Email
	public SignIn getSignInDetailsByEMail(String email) {
		return signInDetailsRepo.findSignInDetailsByEmail(email);
	}
}
