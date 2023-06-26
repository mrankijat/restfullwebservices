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
	@GetMapping("/report")
	public String showReport(@RequestParam("cno") int cno, @RequestParam("cname") String name) {

		return cno + "_____" + name;
	}

	@GetMapping("/report1")
	public String showReport1(@RequestParam("no") int cno, @RequestParam String name) {

		return cno + "_____" + name;
	}

	@GetMapping("/report2")
	public String showReport2(@RequestParam(required = false) Integer cno,
			@RequestParam(defaultValue = "Ankit") String name) {

		return cno + "_____" + name;
	}
	@PostMapping("/report3")
	public String showReport3(@RequestParam(required = false) Integer cno,
			@RequestParam(defaultValue = "Ankit") String name) {

		return cno + "_____" + name;
	}
	
//@PathVariable
@GetMapping("/report4/{cno}/{cname}")
public String showReport4(@PathVariable String cname,@PathVariable Integer cno) {

	return cno + "_____" + cname;
    }

@GetMapping("/report5/{cno}/{name}")
public String showReport5(@PathVariable(name = "name") String cname,@PathVariable(required = false) Integer cno) {

	return cno + "_____" + cname;
    }
}