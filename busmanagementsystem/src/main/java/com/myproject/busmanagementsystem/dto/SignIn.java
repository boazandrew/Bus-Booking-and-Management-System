package com.myproject.busmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "sign_in")
public class SignIn {
	
	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id",insertable = false,updatable = false)
	private int id;

	@Column(name = "signIn_Name")
	@NotBlank(message = "Name is Mandatory")
	private String name;

	@NotBlank(message = "Date of birth cannot be Blank")
	@Column(name = "Date_of_Birth")
	private String dob;

	@NotBlank(message = "Address cannot be blank")
	private String address;

	@NotBlank(message = "Email Id cannot be blank")
	@Email(message = "Invalid Email Format")
	@Column(name = "email")
	private String email;
	//this OTP is used to verify the user for login purpose
	private String otp;
	
	@NotBlank(message = "Phone number cannot be blank")
	@Pattern(regexp = "^\\d{10}$", message = "phone number must have exactly 10 digits")
	@Column(name = "phone_num")
	private String phoneNumber;

	//Getters and Setters for SignIn details
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	
}
