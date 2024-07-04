package com.myproject.busmanagementsystem.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myproject.busmanagementsystem.util.ResponseStructure;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("Id not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(NoSuchElementException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No element found for the given Id");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		List<ObjectError> errors = exception.getAllErrors();
//		Map<String, String> map = new LinkedHashMap<>();
//		for (ObjectError error : errors) {
//			String fieldName = ((FieldError) error).getField();
//			String message = ((FieldError) error).getDefaultMessage();
//			map.put(fieldName, message);
//		}
//		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
//	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        List<ValidationErrorResponse.FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationErrorResponse.FieldError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ValidationErrorResponse errorResponse = new ValidationErrorResponse("Validation failed", fieldErrors);

        return new ResponseEntity<>(errorResponse, headers, status);
    }
	
	private static final Logger logger=LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	@Autowired
	private JavaMailSender javaMailSender;

	public  ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request){
		String errorDetails=ex.getMessage();
		String errorDes=request.getDescription(false);
		
		ErrorResponse errorResponse=new ErrorResponse("An unexcepted error occurs", errorDetails);
		
		logger.error("Runtime Exception occurred: {} ", errorDetails,ex);
		sendErrorNotification(errorDetails,errorDes);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private void sendErrorNotification(String errorDetails, String errorDes) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("andrewboaz417@gmail.com");
		message.setSubject("Critical Error Notification");
		message.setText("An unexcepted error occurred:\n\nDetails: "+errorDetails+"\n\nRequest: "+errorDes);
		
		javaMailSender.send(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handleConstraintViolationException(
			ConstraintViolationException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("this field should not be null or blank");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = { NoClassDefFoundError.class })
	public ResponseEntity<Object> handleNoClassDefFoundError(NoClassDefFoundError ex, WebRequest request) {
		if (ex.getMessage().contains("javax/persistence/Entity")) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "A NoClassDefFoundError occurred: javax.persistence.Entity not found");
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "A NoClassDefFoundError occurred");
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
