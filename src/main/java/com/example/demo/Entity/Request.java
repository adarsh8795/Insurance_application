package com.example.demo.Entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
public class Request {
	
	private String planName;
	
	private String planStatus;
	
	private String gender;
	
	private String startDate;
	
	private String  endDate;
	
}
