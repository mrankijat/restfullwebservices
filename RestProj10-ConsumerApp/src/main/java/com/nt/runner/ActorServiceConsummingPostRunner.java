package com.nt.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@Component
public class ActorServiceConsummingPostRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	@Value("${provider.app.url.register}")
	private String url;
	 @Value("${http.jsonBody}")
	private String json_body;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------------------------------------------------------------");
		System.out.println(json_body);
		System.out.println("--------------------------------------------------------------------");
		//String json_body="{\"aid\":1001,\"aname\":\"Ankit\",\"addrs\":\"A-262\",\"remuneration\":44000}";
	//prepare http header
	     HttpHeaders header=new HttpHeaders();
	     header.setContentType(MediaType.APPLICATION_JSON);
	     //set header and json body to request 
	     HttpEntity<String> request=new HttpEntity<String>(json_body, header);
		
		ResponseEntity<String> response=template.postForEntity(url,request,String.class);
		System.out.println("response:: "+response.getBody());
		System.out.println("response:: "+response.getStatusCodeValue());
		System.out.println("response status code::"+response.getStatusCode());
		//System.exit(0);
	}
	
	
	
}
