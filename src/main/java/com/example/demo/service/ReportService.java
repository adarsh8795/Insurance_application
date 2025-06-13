package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.Entity.Request;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;


public interface ReportService {
	
	public List<String> planNameDropDown();
	
	public List<String> planStatusDropDown();
	
	public List<CitizenPlan> search(Request search);
	
	public void exportExcel(HttpServletResponse response) throws IOException ;
	
	public Boolean exportPdf();
	
	public void sendemail(String mailId) throws FileNotFoundException, MessagingException;
	
	

}
