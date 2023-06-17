package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
	private Integer cno;
	private String cname;
	private Double billAmt;
	private String[] fColours;
	private List<String> academics;
	private Set<Long> phNumbers;
	private Map<String, String> idDetails;
	private Company company;
}
