package com.myproject.busmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.Booking;
import com.myproject.busmanagementsystem.repo.BookingDetailsRepo;

//responsible for interacting with the database.
@Repository
public class BookingDetailsDao {

	// Encapsulate the data access logic of Booking Details 
	//Implementing the CRUD operations
	//provide abstraction layer between business and database it make easy to maintain and test
	
	//@Autowired is an annotation in Spring that automatically injects the required dependency into a class field or constructor
	@Autowired
	private BookingDetailsRepo bookingDetailsRepo;
	
	//Save
	public Booking saveBookingDetails(Booking booking) {
		return bookingDetailsRepo.save(booking);
	}
	
	//Update
	public Booking updateBookingDetails(int id,Booking booking) {
		if (bookingDetailsRepo.findById(id).isPresent()) {
			booking.setBookingId(id);
			return bookingDetailsRepo.save(booking);
		}
		else {
			return null;
		}
	}
	
	//Delete
	public Booking deleteBookingDetails(int id) {
		Optional<Booking> optionalBooking=bookingDetailsRepo.findById(id);
		if (bookingDetailsRepo.findById(id).isPresent()) {
			Booking booking=optionalBooking.get();
			bookingDetailsRepo.delete(booking);
			return booking;
		}
		else {
			return null;
		}
	}
	
	//Get details by using id
	public  Optional<Booking> getBookingDetailsById(int id){
		return bookingDetailsRepo.findById(id);
	}
	
}
