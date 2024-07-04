package com.myproject.busmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.SignInDetailsDao;
import com.myproject.busmanagementsystem.dto.SignIn;

//indicate that a class holds business logic and is a service provider in the application's service layer.
@Service
public class SignInDetailsService {
	@Autowired
	private SignInDetailsDao signInDetailsDao;
	
	public SignIn saveSignInDetails(SignIn signIn) {
		return signInDetailsDao.saveSignInDetails(signIn);
	}

	public SignIn updateSignInDetails(int id,SignIn signIn) {
		SignIn uSignIn=signInDetailsDao.updateSignInDetails(id, signIn);
		if (uSignIn!=null) {
			return uSignIn;
		}
		else {
			return null;
		}
	}
  

    public  SignIn deleteSignInDetails(int id) {
    	SignIn signIn=signInDetailsDao.deleteSignInDetails(id);
    	if (signIn!=null) {
			return signIn;
		}
    	else {
			return null;
		}
    }
    
    public Optional<SignIn> getSignInDetailsById(int id) {
    	Optional<SignIn> signIn=signInDetailsDao.getSignInDetailsById(id);
    	if (signIn!=null) {
			return signIn;
		}
    	else {
			return null;
		}
    }

    public SignIn getSignInDetailsByName(String signInName) {
    	SignIn signIn=signInDetailsDao.getSignInDetailsByName(signInName);
    	if (signIn !=null) {
			return signIn;
		}
    	else {
			return null;
		}
    }

    public SignIn getSignInDetailsByPhoneNumber(String phoneNum) {
    	SignIn signIn=signInDetailsDao.getSignInDetailsByPhoneNumber(phoneNum);
    	if (signIn!=null) {
			return signIn;
		}
    	else {
			return null;
		}
    }
    
    public SignIn getSignInDetailsByEMail(String email) {
    	SignIn signIn=signInDetailsDao.getSignInDetailsByEMail(email);
    	if (signIn!=null) {
			return signIn;
		}
    	else {
			return null;
		}
    }
}
