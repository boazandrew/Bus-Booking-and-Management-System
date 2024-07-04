package com.myproject.busmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.busmanagementsystem.dto.Login;
import com.myproject.busmanagementsystem.service.LoginDetailsService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
@Validated
public class LoginDetailsController {

	@Autowired
	private LoginDetailsService loginDetailsService;
	
	//for Request Purpose
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Request gived Sucessfully"),
			@ApiResponse(code = 404, message = "Invalid Request") })
	@RequestMapping(method = RequestMethod.POST,path = "/requestotp")
	public ResponseEntity<String> requestOtp(@RequestBody Login login){
		loginDetailsService.requestOtp(login.getEmail());
		return ResponseEntity.ok("Otp sent your email.");
	}
	
	//For Verify purpose
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Otp is valid"),
			@ApiResponse(code = 404, message = "Invalid otp") })
	@RequestMapping(method = RequestMethod.POST,path = "/verifyotp")
	public ResponseEntity<String>verifyOtp(@RequestBody Login login){
		boolean isVerified=loginDetailsService.verifyOtp(login);
		if (isVerified) {
			return ResponseEntity.ok("OTP verified sucessfully");
		}
		else {
			return ResponseEntity.status(401).body("invaid otp");
		}
	}

}
