package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/touristapi")
public class TouristOperationController {

	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerTourist(@RequestBody Tourist tourist){
		//use service 
		try {
			String msg = service.registerTourist(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAllTourist(){
		try {
			//use service
		List<Tourist> allTourist = service.findAllTourist();
		return new ResponseEntity<List<Tourist>>(allTourist,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int tid){
		try {
			//use service
			Tourist tourist = service.findTouristByid(tid);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		} catch (Exception e) {
		 return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateTourist(@RequestBody Tourist tourist){
		try {
			//use service
			String msg = service.updateTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	} 
	@DeleteMapping("/delete/{tid}")
	public ResponseEntity<?> deleteTourist(@PathVariable("tid") Integer tid){
		try {
			//use service
			String msg = service.deleteTouristBytid(tid);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findByName/{name}")
	public ResponseEntity<?> findTouristByName(@PathVariable("name") String tname){
		try {
			//use Service
			List<Tourist> list = service.findTouristByName(tname);
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PatchMapping("/update/{id}/{hike}")
	public ResponseEntity<?> updateBudgetById(@PathVariable("id") int tid,@PathVariable("hike") double hikePercentage){
		try {
			//use service 
			String msg = service.updateTouristBudgetById(tid, hikePercentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteByRange/{startRange}/{endRange}")
	public ResponseEntity<?> deleteByBudgetRange(@PathVariable("startRange") double start,
			                                                  @PathVariable("endRange") double end) {
		try {
			//use service
			String msg = service.deleteDeleteByBudgetRange(start,end);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
