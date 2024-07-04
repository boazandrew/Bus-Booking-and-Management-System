package com.myproject.busmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.busmanagementsystem.dao.DriverDetailsDao;
import com.myproject.busmanagementsystem.dto.DriverDetails;

//indicate that a class holds business logic and is a service provider in the application's service layer.
@Service
public class DriverDetailsService {
	@Autowired
    private DriverDetailsDao driverDetailsdao;

	public DriverDetails saveDriverDetails(DriverDetails driverDetails) {
		return driverDetailsdao.saveDriverDetails(driverDetails);
	}

	public DriverDetails updateDriverDetails(DriverDetails driverDetails,int id) {
		DriverDetails drDriverDetails=driverDetailsdao.updateDriverDetails(driverDetails, id);
		if (drDriverDetails!=null) {
			return drDriverDetails;
		}
		else {
			return null;
		}
	}
  

    public  DriverDetails deleteDriverDetails(int id) {
    	DriverDetails driverDetails=driverDetailsdao.deleteDriverDetails(id);
    	if (driverDetails!=null) {
			return driverDetails;
		}
    	else {
			return null;
		}
    }
    
    public DriverDetails getDriverDetailsById(int id) {
    	DriverDetails driverDetails=driverDetailsdao.getDriverDetailsById(id);
    	if (driverDetails!=null) {
			return driverDetails;
		}
    	else {
			return null;
		}
    }
    
    public DriverDetails getDriverDetailsByPhno(String phoneNum) {
    	DriverDetails driverDetails=driverDetailsdao.getDriverDetailsByPhno(phoneNum);
    	if (driverDetails !=null) {
			return driverDetails;
		}
    	else {
			return null;
		}
    }


    public DriverDetails getDriverDetailsByEmail(String email) {
    	DriverDetails driverDetails=driverDetailsdao.getDriverDetailsByEmail(email);
    	if (driverDetails!=null) {
			return driverDetails;
		}
    	else {
			return null;
		}
    }
}