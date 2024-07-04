package com.myproject.busmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.busmanagementsystem.dto.Booking;
import com.myproject.busmanagementsystem.service.BookingDetailsService;
import com.myproject.busmanagementsystem.util.ResponseStructure;

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
@RequestMapping("/booking")
@Validated
public class BookingDetailsController {

	@Autowired
	private BookingDetailsService bookingDetailsService;

	/*
	 @APIResponses: Defines the possible responses for a REST API operation.
	 
	 @Post, @Put, @Get, @Delete: HTTP methods for handling POST, PUT, GET, and DELETE requests respectively.
	 
	 @Valid: Activates validation on annotated method arguments.
	 
	 @RequestParam: Binds a parameter in the request to a method parameter.
	 
	 @RequestBody: Binds the HTTP request body to a method parameter in a controller.
	 */
	
	// save
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessfully Booked") })
	@RequestMapping(method = RequestMethod.POST,path = "/saveBookingDetails")
	public ResponseEntity<ResponseStructure<Booking>> saveBookingDetails(@Valid @RequestBody String email,
			@RequestBody Booking booking) {
		return bookingDetailsService.saveBookingDetails(email, booking);
	}

	// update
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully updated"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.PUT,path = "/updateBookingDetails")
	public ResponseEntity<ResponseStructure<Booking>> updateBookingDetails(@Valid @RequestParam int id,
			@RequestBody String email, @RequestBody Booking booking) {
		return bookingDetailsService.updateBookingDetails(id, email, booking);
	}

	// delete
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Sucessfully Deleted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteBookingDetails")
	public ResponseEntity<ResponseStructure<Booking>> deleteBookingDetails(@Valid @RequestParam int id) {
		return bookingDetailsService.deleteBookingDetails(id);
	}

	// get id
	@ApiResponses(value = { @ApiResponse(code = 203, message = "Sucessfully Details Geted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@RequestMapping(method = RequestMethod.GET,path = "/getBookingDetailsById")
	public ResponseEntity<ResponseStructure<Booking>> getBookingDetailsById(@Valid @RequestParam int id) {
		return bookingDetailsService.getBookingDetailsById(id);
	}

}
