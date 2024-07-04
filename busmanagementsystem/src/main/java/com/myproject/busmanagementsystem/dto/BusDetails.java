package com.myproject.busmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "bus_Details")
public class BusDetails {

	// Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bus_id")
	private int id;

	@NotBlank(message = "Bus name cannot be null")
	private String busName;

	@NotBlank(message = "Number Plate Cannot be null")
	private String busNumberPlate;

	@NotBlank(message = "Seating Details cannot be null")
	private String seatingDetails;

	@NotBlank(message = "Capacity cannot be null")
	private String seatingCapacity;

	@NotBlank(message = "Bus type cannot be null")
	private String busType;

	@NotBlank(message = "Bus type cannot be null")
	private String departureTime;

	// switch case for departureTime
	public void handleDepartureTime() {
		switch (departureTime) {
		case "ForeNoon":
			System.out.println("Before 10 AM");
			break;

		case "AfterNoon":
			System.out.println("Morning 10 AM to Evening 5 PM");
			break;

		case "Evening":
			System.out.println("Evening 5 PM - 11 PM");
			break;

		case "Night":
			System.out.println("After 11 PM");
			break;

		default:
			System.out.println("Show all");
		}
	}

	// switch case for Bus type
	public void handleBusType() {
		switch (busType) {
		case "AC":
			System.out.println("AC");
			break;
		case "Non-AC":
			System.out.println("Non - Ac");
			break;
		default:
			System.out.println("Show both");
		}
	}

	// switch case for seatingDetails
	public void handleSeatingDetails() {
		switch (seatingDetails) {
		case "Seater":
			System.out.println("Seater");
			break;

		case "Semi-Sleeper":
			System.out.println("Semi-Sleeper");
			break;

		case "Sleeper":
			System.out.println("Sleeper");
			break;

		default:
			break;
		}
	}

	// Getters and Setters for Bus Details
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusNumberPlate() {
		return busNumberPlate;
	}

	public void setBusNumberPlate(String busNumberPlate) {
		this.busNumberPlate = busNumberPlate;
	}

	public String getSeatingDetails() {
		return seatingDetails;
	}

	public void setSeatingDetails(String seatingDetails) {
		this.seatingDetails = seatingDetails;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
}
