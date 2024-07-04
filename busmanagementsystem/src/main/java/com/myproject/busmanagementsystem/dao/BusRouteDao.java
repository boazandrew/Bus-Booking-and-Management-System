package com.myproject.busmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.busmanagementsystem.dto.BusRoute;
import com.myproject.busmanagementsystem.repo.BusRouteRepo;

//responsible for interacting with the database.
@Repository
public class BusRouteDao {

	// Encapsulate the data access logic of Booking Details 
	//Implementing the CRUD operations
	//provide abstraction layer between business and database it make easy to maintain and test
	
	//@Autowired is an annotation in Spring that automatically injects the required dependency into a class field or constructor
	@Autowired
	private BusRouteRepo busRouteRepo;

	//Save
	public BusRoute saveBusRoute(BusRoute busRoute) {
		return busRouteRepo.save(busRoute);
	}
	
	//Update
	public BusRoute updateBusRoute(BusRoute busRoute,int id) {
		if (busRouteRepo.findById(id).isPresent()) {
			busRoute.setId(id);
			return busRouteRepo.save(busRoute);
		} else {
			return null;
		}
	}

	//Delete
	public BusRoute deleteBusRoute(int id) {
		Optional<BusRoute> optionalBusRoute = busRouteRepo.findById(id);
		if (busRouteRepo.findById(id).isPresent()) {
			BusRoute busRoute=optionalBusRoute.get();
			busRouteRepo.delete(busRoute);	
			return busRoute;
		} else {
			return null;
		}
	}

	//Get Bus route by using id
	public BusRoute getBusRouteById(int id) {
		
			return busRouteRepo.findById(id).orElse(null);
	}
}
