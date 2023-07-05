package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorServiceConsummingExchangeMethodTestingRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	@Value("${provider.app.url.wish}")
	private String urlWish;
	@Value("${provider.app.url.register}")
	private String urlRegister;
	@Value("${provider.app.url.report}")
	private String urlReport;
	@Value("${provider.app.url.reportAll}")
	private String urlReportAll;
	@Value("${http.jsonBody}")
	private String json_body;
	@Override
	public void run(String... args) throws Exception {
	//exchange method in template class
	ResponseEntity<String> responseWish = template.exchange(urlWish, HttpMethod.GET, null, String.class);
	System.out.println("responseWish:: "+responseWish.getBody());
	System.out.println("responseWish:: "+responseWish.getStatusCodeValue());
	System.out.println("responseWish status code::"+responseWish.getStatusCode());
	
	//exchange method use like as postForEntity()
	//ready request obj with header
	HttpHeaders header=new HttpHeaders();
	header.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<String> requestRegister=new HttpEntity<String>(json_body,header);
	ResponseEntity<String> responseRegister = template.exchange(urlRegister, HttpMethod.POST,requestRegister,String.class);
	System.out.println("responseRegister:: "+responseRegister.getBody());
	System.out.println("responseRegister:: "+responseRegister.getStatusCodeValue());
	System.out.println("responseRegister status code::"+responseRegister.getStatusCode());
	
	
	ResponseEntity<String> responseReport = template.exchange(urlReport, HttpMethod.GET, null, String.class);
	System.out.println("=========================================================");
	//convert JSON to Java Object 
	String responseReportBody = responseReport.getBody();
	//create object mapper object
	ObjectMapper mapper=new ObjectMapper();
	Actor actor = mapper.readValue(responseReportBody,Actor.class);//call the readValue method()
	System.out.println("Actor id:"+actor.getAid()+"\nActor Name:"+actor.getAname()+"\nA5ctor Addrs:"+actor.getAddrs()+"\nActor Renumeration:"+actor.getRemuneration());
	
	
	System.out.println("responseWish:: "+responseWish.getBody());
	System.out.println("responseWish:: "+responseWish.getStatusCodeValue());
	System.out.println("responseWish status code::"+responseWish.getStatusCode());
	
	System.out.println("=========================================================");
	ResponseEntity<String> responseReportAll=template.exchange(urlReportAll,HttpMethod.GET, null,String.class);
	//convert JSON to Java Object
	String responseReportAllBody = responseReportAll.getBody();
	//create object mapper object
	//ObjectMapper mapper=new ObjectMapper();
	List<Actor> actorAll = mapper.readValue(responseReportAllBody,new TypeReference<List<Actor>>() {
	});
	//call the readValue method()
	actorAll.forEach((act)->System.out.println("Actor id:"+act.getAid()+"\nActor Name:"+act.getAname()+"\nActor Addrs:"+act.getAddrs()+"\nActor Renumeration:"+act.getRemuneration()+"\n\n"));

	System.out.println("============================================");
	
	System.out.println("responseWish:: "+responseWish.getBody());
	System.out.println("responseWish:: "+responseWish.getStatusCodeValue());
	System.out.println("responseWish status code::"+responseWish.getStatusCode());
	}
	
	
}
