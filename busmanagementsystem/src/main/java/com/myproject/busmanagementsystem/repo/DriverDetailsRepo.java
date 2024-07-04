package com.myproject.busmanagementsystem.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.myproject.busmanagementsystem.dto.DriverDetails;

public interface DriverDetailsRepo extends JpaRepository<DriverDetails, Integer>{

	//JPA Repository is a interface and the interface is used to define custom query methods and provide basic CRUD operation 
	
	//Query for find the Driver details using Driver Phone number
	@Query("select d from DriverDetails d where d.phno= :phoneNum")
	public DriverDetails findDriverDetailsByPhno(@Param("phoneNum") String phoneNum);
	
	
	//Query for find the Driver details using Driver email id
	@Query("select e from DriverDetails e where e.email= :email")
	public DriverDetails findDriverDetailsByEmail(@Param("email") String email);
}
