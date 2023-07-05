package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsummingPathVariableRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	@Value("${provider.app.url.wish.aid.aname}")
	private String url;

	@Override
	public void run(String... args) throws Exception {
	
		ResponseEntity<String> response=template.getForEntity(url,String.class,1001,"Ankit" );
		System.out.println("response:: "+response.getBody());
		System.out.println("response:: "+response.getStatusCodeValue());
		System.out.println("response status code::"+response.getStatusCode());
	//	System.exit(0);
	}
	
	
	
}
