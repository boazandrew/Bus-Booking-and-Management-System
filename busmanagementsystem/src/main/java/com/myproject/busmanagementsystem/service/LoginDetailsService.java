package com.myproject.busmanagementsystem.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.LoginDetailsDao;
import com.myproject.busmanagementsystem.dto.Login;
import com.myproject.busmanagementsystem.dto.SignIn;
import com.myproject.busmanagementsystem.repo.LoginDetailsRepo;
import com.myproject.busmanagementsystem.repo.SignInDetailsRepo;

@Service
public class LoginDetailsService {

	@Autowired
	private SignInDetailsRepo signInDetailsRepo;
	
	@Autowired
	private LoginDetailsRepo loginDetailsRepo;
	
	@Autowired
	private LoginDetailsDao loginDetailsDao;

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger logger = LoggerFactory.getLogger(LoginDetailsService.class);

	//in Generate OTP use random option to generate random numbers
	public String generateOtp() {
		Random random = new Random();
		return String.format("%06d", random.nextInt(1000000));
	}

	//Java mail sender and Simple mail message to give content and OTP to send the particular email id
	public void sendOtpEmail(String to, String otp) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject("Your otp code");
			message.setText("Your otp code is : " + otp);
			javaMailSender.send(message);
			logger.info("otp email sent sucessfully to {}", to);
		} catch (Exception e) {
			logger.error("Error sending OTP email", e);
		}
	}

	//give request OTP for login purpose compare the Login email and SignIn email after generate OTP to the given email if
	public void requestOtp(String email) {
		SignIn signIn = signInDetailsRepo.findByEmail(email);
		if (signIn != null) {
			String otp = generateOtp();
			signIn.setOtp(otp);
			signInDetailsRepo.save(signIn);
			sendOtpEmail(email, otp);
		} else {
			throw new RuntimeException("User Not found");
		}
	}

	//After generate OTP we can verify the OTP after go to booking page
	public boolean verifyOtp(Login login) {
		SignIn signIn = signInDetailsRepo.findByEmail(login.getEmail());
		if (signIn != null && signIn.getOtp().equals(login.getOtp())) {
			saveLogin(login.getEmail(), login.getOtp());
			return true;
		}
		return false;
	}
	
	private void saveLogin(String email,String otp) {
		Login login=new Login();
		login.setEmail(email);
		login.setOtp(otp);
		loginDetailsRepo.save(login);
	}
}
