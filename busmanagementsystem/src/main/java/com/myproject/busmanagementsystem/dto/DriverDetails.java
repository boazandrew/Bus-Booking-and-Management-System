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
@Table(name = "driver")
public class DriverDetails {

	//Attributes 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private int id;

	@NotBlank(message = "Name is Mandatory")
	private String name;

	@NotBlank(message = "Address cannot be Blank")
	private String Address;

	@Column(name = "phone_num")
	@Pattern(regexp = "^\\d{10}$", message = "Phone Number must be exactly 10 digits")
	@NotBlank(message = "Phone number was not blank")
	private String phno;

	@NotBlank(message = "email is mandatory")
	@Email(message = "Invalid Email Formet")
	@Column(name = "email")
	private String email;

	//Getters and Setters for Driver Details
	
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
