package com.myproject.busmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.BookingDetailsDao;
import com.myproject.busmanagementsystem.dao.LoginDetailsDao;
import com.myproject.busmanagementsystem.dto.Booking;
import com.myproject.busmanagementsystem.dto.Login;
import com.myproject.busmanagementsystem.util.ResponseStructure;

//indicate that a class holds business logic and is a service provider in the application's service layer.
@Service
public class BookingDetailsService {

	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	@Autowired
	private LoginDetailsDao loginDetailsDao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBookingDetails(String email,Booking booking){
		Optional<Login> login=loginDetailsDao.getLoginDetailsByEmail(email);
		
		if (login !=null) {
			booking.setLogin(login.get());;
			Booking savedbooking=bookingDetailsDao.saveBookingDetails(booking);
			
			ResponseStructure<Booking> responseStructure= new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully booked");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(savedbooking);
			
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
		}
		else {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Login Id is not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBookingDetails(int id,String email,Booking booking){
		Optional<Booking> optionalBooking=bookingDetailsDao.getBookingDetailsById(id);
		Optional<Login> login=loginDetailsDao.getLoginDetailsByEmail(email);
		
		if (optionalBooking.isPresent() && login !=null) {
			Booking existingBooking=optionalBooking.get();
			Login loginBooking=existingBooking.getLogin();
			
			booking.setBookingId(id);
			booking.setLogin(login.get());
			
			Booking updatedBooking=bookingDetailsDao.updateBookingDetails(id, existingBooking);
			
			ResponseStructure<Booking> responseStructure= new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully Updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(updatedBooking);
			
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
		}
		else {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Login or Booking Id is not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBookingDetails(int id){
		Optional<Booking> optionalBooking=bookingDetailsDao.getBookingDetailsById(id);
		
		if (optionalBooking.isPresent()) {
			Booking booking=optionalBooking.get();
			bookingDetailsDao.deleteBookingDetails(id);
			
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(booking);

			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
		}
		else {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Login Id is not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>>getBookingDetailsById(int id){
		Optional<Booking>optionalBooking=bookingDetailsDao.getBookingDetailsById(id);
		if (optionalBooking.isPresent()) {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully found by Id");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(optionalBooking.get());

			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Passenger ID not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
//	public ResponseEntity<ResponseStructure<Booking>> getBookingDetailsByName(String passengernames){
//		Booking booking=bookingDetailsDao.getBookingDetailsByName(passengernames);
//		
//		if (booking!=null) {
//			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
//			responseStructure.setMessage("Successfully found by Name");
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setData(booking);
//
//			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.OK);
//		}
//		else {
//			ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
//			responseStructure.setMessage("Passenger with this Name not found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return new ResponseEntity<ResponseStructure<Booking>>(responseStructure, HttpStatus.NOT_FOUND);
//		}
//	}
}
