package com.myproject.busmanagementsystem.exception;

import java.util.List;

public class ValidationErrorResponse {
	private String message;
	private List<FieldError> fieldErrors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public static class FieldError {

		private String Field;
		private String message;

		public String getField() {
			return Field;
		}

		public void setField(String field) {
			Field = field;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public FieldError(String field, String message) {
			this.Field = field;
			this.message = message;
		}
	}

	public ValidationErrorResponse(String message, List<FieldError> fieldErrors) {
		this.message = message;
		this.fieldErrors = fieldErrors;
	}

}
