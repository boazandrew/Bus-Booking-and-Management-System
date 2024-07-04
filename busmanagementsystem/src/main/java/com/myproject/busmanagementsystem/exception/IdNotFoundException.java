package com.myproject.busmanagementsystem.exception;

public class IdNotFoundException extends RuntimeException {
	private String message = "Id not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
}
