package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<String> showCustomerReport(){
	return new ResponseEntity<String>("FROM-GET Customer Report",HttpStatus.OK );
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
	return new ResponseEntity<String>("FROM-POST Register Customer",HttpStatus.OK );
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
	return new ResponseEntity<String>("FROM-PUT FullyCustomerUpdate",HttpStatus.OK );
	}
	
	@PatchMapping("/pupdate")
	public ResponseEntity<String> updateCustomerPartially(){
	return new ResponseEntity<String>("FROM-PATCH PartiallyCustomerUpdate",HttpStatus.OK );
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleterCustomer(){
	return new ResponseEntity<String>("FROM-DELETE DeleteCustomer",HttpStatus.OK );
	}
}
