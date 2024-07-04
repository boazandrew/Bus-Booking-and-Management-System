package com.myproject.busmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.busmanagementsystem.dto.DriverDetails;
import com.myproject.busmanagementsystem.service.DriverDetailsService;


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
@RequestMapping("/driverDetails")
@Validated
public class DriverDetailsController {

	@Autowired
	private DriverDetailsService driverDetailsService;

	/*
	 @APIResponses: Defines the possible responses for a REST API operation.
	 
	 @Post, @Put, @Get, @Delete: HTTP methods for handling POST, PUT, GET, and DELETE requests respectively.
	 
	 @Valid: Activates validation on annotated method arguments.
	 
	 @RequestParam: Binds a parameter in the request to a method parameter.
	 
	 @RequestBody: Binds the HTTP request body to a method parameter in a controller.
	 */
	
	// save
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Saved") })
	@RequestMapping(method = RequestMethod.POST,path = "/saveDriverDetails")
	public DriverDetails saveDriverDetails(@Valid @RequestBody DriverDetails driverDetails) {
		return driverDetailsService.saveDriverDetails(driverDetails);
	}

	// update

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not Found") })
	@RequestMapping(method = RequestMethod.PUT,path = "/updateDriverDetails")
	public DriverDetails updateDriverDetails(@Valid @RequestBody DriverDetails driverDetails, @RequestParam int id) {
		return driverDetailsService.updateDriverDetails(driverDetails, id);
	}

	// delete

	@ApiResponses(value = { @ApiResponse(code = 202, message = "sucessfully Deteted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteDriverDetails")
	public DriverDetails deleteDriverDetails(@Valid @RequestParam int id) {
		return driverDetailsService.deleteDriverDetails(id);
	}

	// get id

	@ApiResponses(value = { @ApiResponse(code = 203, message = "Sucessfully details geted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getDriverDetailsById")
	public DriverDetails getDriverDetailsById(@Valid @RequestParam int id) {
		return driverDetailsService.getDriverDetailsById(id);
	}

	// get phone
	@ApiResponses(value = { @ApiResponse(code = 205, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Name not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getDriverDetailsByPhoneNo")
	public DriverDetails getDriverDetailsByPhoneNo(@Valid @RequestBody String phoneNum) {
		return driverDetailsService.getDriverDetailsByPhno(phoneNum);
	}

	// get email
	@ApiResponses(value = { @ApiResponse(code = 206, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Name not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getDriverDetailsByEmail")
	public DriverDetails getDriverDetailsByEmail(@Valid @RequestBody String email) {
		return driverDetailsService.getDriverDetailsByEmail(email);
	}
}
