package com.myproject.busmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.busmanagementsystem.dto.BusDetails;
import com.myproject.busmanagementsystem.service.BusDetailsService;

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
@RequestMapping("/busDetails")
@Validated
public class BusDetailsController {
	@Autowired
	private BusDetailsService busDetailsService;

	/*
	 @APIResponses: Defines the possible responses for a REST API operation.
	 
	 @Post, @Put, @Get, @Delete: HTTP methods for handling POST, PUT, GET, and DELETE requests respectively.
	 
	 @Valid: Activates validation on annotated method arguments.
	 
	 @RequestParam: Binds a parameter in the request to a method parameter.
	 
	 @RequestBody: Binds the HTTP request body to a method parameter in a controller.
	 */
	//Save Bus Details 
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessfully Saved") })
	@RequestMapping(method = RequestMethod.POST,path = "/saveBusdetails")
	public BusDetails saveBusDetails(@Valid @RequestBody BusDetails busDetails) {
		return busDetailsService.saveBusDetails(busDetails);
	}

	
	
	//update Bus details

	@ApiResponses(value = { @ApiResponse(code = 201, message = "sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.PUT,path = "/updateBusdetails")
	public BusDetails updateBusDetails(@Valid @RequestBody BusDetails busDetails, @RequestParam int id) {
		return busDetailsService.updateBusDetails(busDetails, id);
	}

	
	//delete Bus details

	@ApiResponses(value = { @ApiResponse(code = 202, message = "Sucessfully deleted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteBusDetails")
	public BusDetails deleteBusDetails(@Valid @RequestParam int id) {
		return busDetailsService.deleteBusDetails(id);
	}

	
	//get bus Details by id

	@ApiResponses(value = { @ApiResponse(code = 203, message = "Sucessfully details geted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getBusDetailsById")
	public BusDetails getBusDetailsById(@Valid @RequestParam int id) {
		return busDetailsService.getBusDetailsById(id);
	}
}
