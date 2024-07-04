package com.myproject.busmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.BusDetailsDao;
import com.myproject.busmanagementsystem.dto.BusDetails;

//indicate that a class holds business logic and is a service provider in the application's service layer.
@Service
public class BusDetailsService {
	 @Autowired
	    private BusDetailsDao busDetailsdao;

	    public BusDetails saveBusDetails(BusDetails busDetails) {
	        return busDetailsdao.saveBusDetails(busDetails);
	    }


	    public BusDetails updateBusDetails(BusDetails busDetails,int id) {
	        BusDetails bdBusDetails = busDetailsdao.updateBusDetails(busDetails, id);
	        if (bdBusDetails != null) {
	            return bdBusDetails;
	        } else {
	            return null;
	        }
	    }

	    public BusDetails deleteBusDetails(int id) {
	        BusDetails busDetails = busDetailsdao.deleteBusDetails(id);
	        if (busDetails != null) {
	            return busDetails;
	        } else {
	            return null; 
	        }
	    }

	    public BusDetails getBusDetailsById(int id) {
	        BusDetails busDetails = busDetailsdao.getBusDetailsById(id);
	        if (busDetails != null) {
	            return busDetails;
	        } else {
	            return null;
	        }
	    }
}
