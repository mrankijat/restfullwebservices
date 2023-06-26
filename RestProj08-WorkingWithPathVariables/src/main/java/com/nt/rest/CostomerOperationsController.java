package com.nt.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CostomerOperationsController {
	
//@PathVariable
@GetMapping("/report/cno/name")
public String showReport2(@PathVariable(name = "name",required = false) String cname,@PathVariable(required = false) Integer cno) {

	return  "fetch data from/report/cno/name";
    }

@GetMapping("/report/cno/{name}")
public String showReport3(@PathVariable(name = "name") String cname,@PathVariable(required = false) Integer cno) {

	return"fetch data from /report/cno/{name}";
    }

@GetMapping("/report/{cno}/{name}")
public String showReport4(@PathVariable(name = "name") String cname,@PathVariable(required = false) Integer cno) {

	return"fetch data from /report/{cno}/{name}";
    }

@GetMapping("/report/{cno}/name")
public String showReport5(@PathVariable(name = "name",required = false) String cname,@PathVariable(required = false) Integer cno) {

	return"fetch data from /report/{cno}/name";
    }

}