package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {

	/*
	  @GetMapping("/report") public ResponseEntity<Customer> showData(){ Customer
	  cust=new Customer(191, "raja", 55499.0); return new
	  ResponseEntity<Customer>(cust,HttpStatus.OK);
	  
	  }*/
	 @GetMapping("/report")
	public ResponseEntity<Customer> showData(){

		 Customer cust=new Customer(101,"Raja",44000.0,
				                                         new String[] {"blue","green","black"},
				                                         List.of("10th","12th","BCA","MCA"),
				                                         Set.of(7300150214L,8822719461L),
				                                         Map.of("AadharCard","415588220846","PanCard","KGTPK8072H"),
				                                         new Company("HCL","HYD","IT Company",4000));
		 return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
		
}
}