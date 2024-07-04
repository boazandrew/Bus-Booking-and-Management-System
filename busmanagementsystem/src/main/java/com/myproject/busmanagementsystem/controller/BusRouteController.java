package com.myproject.busmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.busmanagementsystem.dto.BusRoute;
import com.myproject.busmanagementsystem.service.BusRouteService;


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
@RequestMapping("/busRoute")
@Validated
public class BusRouteController {
	@Autowired
	private BusRouteService busRouteService;

	/*
	 @APIResponses: Defines the possible responses for a REST API operation.
	 
	 @Post, @Put, @Get, @Delete: HTTP methods for handling POST, PUT, GET, and DELETE requests respectively.
	 
	 @Valid: Activates validation on annotated method arguments.
	 
	 @RequestParam: Binds a parameter in the request to a method parameter.
	 
	 @RequestBody: Binds the HTTP request body to a method parameter in a controller.
	 */
	
	//save bus route
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessfully Saved") })
	@RequestMapping(method = RequestMethod.POST,path = "/saveBusRoute")
	public BusRoute saveBusRoute(@Valid @RequestBody BusRoute busRoute) {
		return busRouteService.saveBusRoute(busRoute);
	}

	
	//update 

	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.PUT,path = "/updateBusRoute")
	public BusRoute updateBusRoute(@Valid @RequestBody BusRoute busRoute,@RequestParam int id) {
		return busRouteService.updateBusRoute(busRoute, id);
	}

	
	//delete

	@ApiResponses(value = { @ApiResponse(code = 202, message = "Sucessfully deleted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteBusRoute")
	public BusRoute deleteBusRoute(@Valid @RequestParam int id) {
		return busRouteService.deleteBusRoute(id);
	}

	
	//get id

	@ApiResponses(value = { @ApiResponse(code = 203, message = "Sucessfully details geted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getBusRouteById")
	public BusRoute getBusRouteById(@Valid @RequestParam int id) {
		return busRouteService.getBusRouteById(id);
	}
}
