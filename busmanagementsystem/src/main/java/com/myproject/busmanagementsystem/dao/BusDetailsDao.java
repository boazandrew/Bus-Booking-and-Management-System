package com.myproject.busmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.BusDetails;
import com.myproject.busmanagementsystem.repo.BusDetailsRepo;

//responsible for interacting with the database.
@Repository
public class BusDetailsDao {

	// Encapsulate the data access logic of Booking Details 
	//Implementing the CRUD operations
	//provide abstraction layer between business and database it make easy to maintain and test
		
	//@Autowired is an annotation in Spring that automatically injects the required dependency into a class field or constructor	
	@Autowired
	private BusDetailsRepo busDetailsRepo;

	//Save
	public BusDetails saveBusDetails(BusDetails busDetails) {
		return busDetailsRepo.save(busDetails);
	}
	
	//Update
	public BusDetails updateBusDetails(BusDetails busDetails,int id) {
		if (busDetailsRepo.findById(id).isPresent()) {
			busDetails.setId(id);
			return busDetailsRepo.save(busDetails);
		}
		else {
			return null;
		}
	}
	
	//Delete
	public BusDetails deleteBusDetails(int id) {
		if(busDetailsRepo.findById(id).isPresent()) {
			BusDetails busDetails=busDetailsRepo.findById(id).get();
			busDetailsRepo.deleteById(id);
			return busDetails;
		}
		else {
			return null;
		}
	}
	
	//get Bus Details By using id
	public BusDetails getBusDetailsById(int id) {
			return busDetailsRepo.findById(id).orElse(null);
		
	}
}
