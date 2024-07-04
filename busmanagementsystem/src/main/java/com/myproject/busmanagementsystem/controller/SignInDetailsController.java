package com.myproject.busmanagementsystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.busmanagementsystem.dto.SignIn;
import com.myproject.busmanagementsystem.service.SignInDetailsService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
/*
@RestController Combines @Controller and @ResponseBody, indicating that this class is a controller 
where every method returns a domain object instead of a view.

@Request Mapping Maps HTTP requests to handler methods of @Controller classes.

@Validated Activates validation on annotated elements like method parameters or return values.
*/

@RestController
@RequestMapping("/signIn")
@Validated
public class SignInDetailsController {
	@Autowired
	private SignInDetailsService signInDetailsService;

	/*
	 @APIResponses: Defines the possible responses for a REST API operation.
	 
	 @Post, @Put, @Get, @Delete: HTTP methods for handling POST, PUT, GET, and DELETE requests respectively.
	 
	 @Valid: Activates validation on annotated method arguments.
	 
	 @RequestParam: Binds a parameter in the request to a method parameter.
	 
	 @RequestBody: Binds the HTTP request body to a method parameter in a controller.
	 */
	
	// save
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessfully Saved") })
	@RequestMapping(method = RequestMethod.POST,path = "/saveSignInDetails")
	public SignIn saveSignInDetails(@Valid @RequestBody SignIn signIn) {
		return signInDetailsService.saveSignInDetails(signIn);
	}

	// update

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully updated"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.PUT,path = "/updateSignInDetails")
	public SignIn updateSignInDetails(@Valid @RequestParam int id, @RequestBody SignIn signIn) {
		return signInDetailsService.updateSignInDetails(id, signIn);
	}

	// delete

	@ApiResponses(value = { @ApiResponse(code = 202, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteSignInDetails")
	public SignIn deleteLoginDetails(@Valid @RequestParam int id) {
		return signInDetailsService.deleteSignInDetails(id);
	}

	// get id

	@ApiResponses(value = { @ApiResponse(code = 203, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getSignInDetailsById")
	public Optional<SignIn> getSignInDetailsById(@Valid @RequestParam int id) {
		return signInDetailsService.getSignInDetailsById(id);
	}

	// get name

	@ApiResponses(value = { @ApiResponse(code = 204, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Name not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getSignInDetailsByName")
	public SignIn getSignInDetailsByName(@Valid @RequestBody String signInName) {
		return signInDetailsService.getSignInDetailsByName(signInName);
	}

	// get email

	@ApiResponses(value = { @ApiResponse(code = 205, message = "Sucessfully Details geted"),
			@ApiResponse(code = 404, message = "Email is not Found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getSignInDetailsByEmail")
	public SignIn getSignInDetailsByEmail(@Valid @RequestBody String email) {
		return signInDetailsService.getSignInDetailsByEMail(email);
	}

	// get phone number

	@ApiResponses(value = { @ApiResponse(code = 206, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Phone Number is not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getSignInDetailsByPhoneNumber")
	public SignIn getSignInDetailsByPhoneNum(@Valid @RequestBody String phoneNum) {
		return signInDetailsService.getSignInDetailsByPhoneNumber(phoneNum);
	}

}
