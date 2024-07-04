package com.myproject.busmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.busmanagementsystem.dto.BusRoute;

public interface BusRouteRepo extends JpaRepository<BusRoute, Integer> {

	//JPA Repository is a interface and the interface is used to define custom query methods and provide basic CRUD operation 
}
