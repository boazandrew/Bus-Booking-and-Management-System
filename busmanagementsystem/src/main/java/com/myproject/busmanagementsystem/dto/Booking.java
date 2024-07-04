package com.myproject.busmanagementsystem.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "booking_Details")
public class Booking {

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;

	@NotBlank(message = "name is mandatory")
	@Column(name = "passenger_name")
	private String passengername;

	@NotNull(message = "Age cannot be blank")
	@Column(name = "age")
	private int age;

	@NotBlank(message = "gender is not blank")
	@Column(name = "gender")
	private String gender;

	// Switch Case for gender
	public void handleGender(String options) {
		switch (gender) {
		case "male":
			System.out.println("Male");
			break;

		case "female":
			System.out.println("Female");
			break;

		case "other":
			System.out.println("Others");
			break;

		default:
			System.out.println("invalid actions");
			break;
		}
	}

	@FutureOrPresent(message = "booking date is only persent or future only")
	@Column(name = "journey_date")
	private LocalDate journeyDate;

	@NotBlank(message = "Boarding point cannot be blank")
	@Column(name = "boarding_Point")
	private String boardingPoint;

	@NotBlank(message = "Droping point caannot be blank")
	@Column(name = "droping_point")
	private String dropingPoint;

	@NotBlank(message = "Cost is mandatory")
	@Column(name = "cost")
	private String cost;

	@NotBlank(message = "no of seats is mandatory")
	@Column(name = "no_of_Seats")
	private int noOfSeats;

	// Connections
	@OneToOne
	@JoinColumn(name = "login_email",referencedColumnName = "email")
	private Login login; 

	@ManyToOne
	@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
	private BusDetails busDetails;

	@OneToOne
	@JoinColumn(name = "BusRoute_id", referencedColumnName = "route_id")
	private BusRoute busRoute;

	@ManyToOne
	@JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
	private DriverDetails driverDetails;

	// Getters and Setters for Booking Details

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDropingPoint() {
		return dropingPoint;
	}

	public void setDropingPoint(String dropingPoint) {
		this.dropingPoint = dropingPoint;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}

	public DriverDetails getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(DriverDetails driverDetails) {
		this.driverDetails = driverDetails;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
