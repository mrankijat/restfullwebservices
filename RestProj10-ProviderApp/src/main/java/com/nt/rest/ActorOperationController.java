package com.nt.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actorapi")
public class ActorOperationController {
    
	@GetMapping("/wish")
	ResponseEntity<?> displayWishMessage(){
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if (hour<12) {
			return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
		}else if (hour<16) {
			return new ResponseEntity<String>("Good Afternoon",HttpStatus.OK);
		}else if (hour<20) {
			return new ResponseEntity<String>("Good Evening",HttpStatus.OK);
		  }else
			return new ResponseEntity<String>("Good Night",HttpStatus.OK);
	
	}
	
	@GetMapping("/wish/{aid}/{aname}")
	ResponseEntity<?> displayWishMessageWithPath(@PathVariable("aid") Integer id,@PathVariable("aname") String name){
		
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if (hour<12) {
			return new ResponseEntity<String>("Good Morning "+name+"  "+id,HttpStatus.OK);
		}else if (hour<16) {
			return new ResponseEntity<String>("Good Afternoon "+name+"  "+id,HttpStatus.OK);
		}else if (hour<20) {
			return new ResponseEntity<String>("Good Evening "+name+"  "+id,HttpStatus.OK);
		  }else
			return new ResponseEntity<String>("Good Night "+name+"  "+id,HttpStatus.OK);
	
	}
	
	@PostMapping("/register")
	ResponseEntity<?> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>(actor.toString(),HttpStatus.CREATED);
	}
	@GetMapping("/report")
	ResponseEntity<?> showActor(){
		Actor actor=new Actor(1002,"Ankit","HYD",43430.0);
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/reportAll")
	ResponseEntity<?> showAllActor(){
		return new ResponseEntity<List<Actor>>(List.of(new Actor(323,"AK","HYD",34343.0),new Actor(32,"AO","JPR",34354.0)),HttpStatus.OK);
		
	}
}
