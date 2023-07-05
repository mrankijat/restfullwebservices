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

import com.nt.model.Actor;

//@Component
public class ActorServiceConsummingGetJsonDataRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	@Value("${provider.app.url.report}")
	private String url;
	@Value("${provider.app.url.reportAll}")
	private String urlAll;
	@Override
	public void run(String... args) throws Exception {
	ResponseEntity<String> response = template.getForEntity(urlAll,String.class);
	System.out.println("response:: "+response.getBody());
	System.out.println("response:: "+response.getStatusCodeValue());
	System.out.println("response status code::"+response.getStatusCode());
	}
}
