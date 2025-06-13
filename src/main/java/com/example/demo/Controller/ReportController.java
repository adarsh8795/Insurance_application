package com.example.demo.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.Entity.Request;
import com.example.demo.service.ReportService;
import com.example.demo.serviceImpl.ReportServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService; 
	
	@GetMapping("/")
	public String  searchRequest(Model model)
	{	
		model.addAttribute("names",reportService.planNameDropDown());
		model.addAttribute("Statuses",reportService.planStatusDropDown());
		
		model.addAttribute("search",new Request());
		return "index";
		
	}
	
	@PostMapping("/")
	public String formHandler(@ModelAttribute("search") Request search,Model model)
	{
		System.out.println("form data " + search);
		reportService.search(search);
		model.addAttribute("names",reportService.planNameDropDown());
		model.addAttribute("Statuses",reportService.planStatusDropDown());
		System.out.println("Query by exmaple data " +  reportService.search(search));
		model.addAttribute("filterData", reportService.search(search));
		return "index";
	}
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws IOException
	{
		response.setContentType("applicaton/octet-steam");
		response.addHeader("content-Disposition", "attachment;filename=plan.xlsx");
		
		reportService.exportExcel(response);
		
		
	}
	@PostMapping("/email")
	public String sendEmail(String email,Model model) throws FileNotFoundException, MessagingException
	{
//		reportService.sendemail(email);
		
		
		
		return "redirect:/";
	}
	 

}
