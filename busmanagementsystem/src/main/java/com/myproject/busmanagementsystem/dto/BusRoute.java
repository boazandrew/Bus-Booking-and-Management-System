package com.myproject.busmanagementsystem.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "bus_Route")
public class BusRoute {
	// Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private int id;
	
	@NotBlank(message = "Starting Point cannot be null")
	@Column(name = "Starting_Point")
	private String startingPoint;
	
	@NotBlank(message = "Ending point cannot be null")
	@Column(name = "Ending_Point")
	private String endingPoint;
	
	@NotNull(message = "No of routes cannot be null")
	@Column(name = "No_of_Routes")
	private int noOfRoutes;
	
	//Getters and Setters for Bus Route
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getEndingPoint() {
		return endingPoint;
	}

	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}

	public int getNoOfRoutes() {
		return noOfRoutes;
	}

	public void setNoOfRoutes(int noOfRoutes) {
		this.noOfRoutes = noOfRoutes;
	}

}
