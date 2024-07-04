package com.myproject.busmanagementsystem.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.myproject.busmanagementsystem.dto.SignIn;

public interface SignInDetailsRepo extends JpaRepository<SignIn, Integer> {

	// JPA Repository is a interface and the interface is used to define custom query methods and provide basic CRUD operation

	// Query for find the SignIn Details using User Name
	@Query("select n from SignIn n where n.name= :name")
	public SignIn findSignInDetailsByName(@Param("name") String name);

	// Query for find the SignIn Details using Email id
	@Query("select e from SignIn e where e.email= :email")
	public SignIn findSignInDetailsByEmail(@Param("email") String email);

	// Query for find the SignIn Details using Phone Number
	@Query("select p from SignIN p where p.phoneNumber= :phno")
	public SignIn findSignIndetailsByPhoneNumber(@Param("phno") String phno);
	
	//this find by email is used for OTP purpose
	SignIn  findByEmail(String email);
}
