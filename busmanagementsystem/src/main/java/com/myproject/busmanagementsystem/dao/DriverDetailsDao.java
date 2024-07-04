package com.myproject.busmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.DriverDetails;
import com.myproject.busmanagementsystem.repo.DriverDetailsRepo;

//responsible for interacting with the database.
@Repository
public class DriverDetailsDao {

	// Encapsulate the data access logic of Booking Details 
	//Implementing the CRUD operations
	//provide abstraction layer between business and database it make easy to maintain and test
	
	//@Autowired is an annotation in Spring that automatically injects the required dependency into a class field or constructor
	@Autowired
	private DriverDetailsRepo driverDetailsRepo;

	//Save
	public DriverDetails saveDriverDetails(DriverDetails driverDetails) {
		return driverDetailsRepo.save(driverDetails);
	}
	
	//Update
	public DriverDetails  updateDriverDetails(DriverDetails driverDetails,int id) {
		if (driverDetailsRepo.findById(id).isPresent()) {
			driverDetails.setId(id);
			return driverDetailsRepo.save(driverDetails);
		}
		else {
			return null;
		}
	}
	
	//Delete
	public DriverDetails deleteDriverDetails(int id) {
		Optional<DriverDetails> optionalDriverDetails=driverDetailsRepo.findById(id);
		if (driverDetailsRepo.findById(id).isPresent()) {
			DriverDetails driverDetails=optionalDriverDetails.get();
			driverDetailsRepo.deleteById(id);
			return driverDetails;
		}
		else {
			return null;
		}
	}
	
	//Get Driver Details by using id
	public DriverDetails getDriverDetailsById(int id) {
		return driverDetailsRepo.findById(id).orElse(null);
	}
	
	//Get Driver Details by using Phone number
	public DriverDetails getDriverDetailsByPhno(String phoneNum) {
		return driverDetailsRepo.findDriverDetailsByPhno(phoneNum);
	}
	
	//Get Deiver Details By using EMail
	public DriverDetails getDriverDetailsByEmail(String email) {
		return driverDetailsRepo.findDriverDetailsByEmail(email);
	}
}
