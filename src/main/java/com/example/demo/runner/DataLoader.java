package com.example.demo.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
    private  CitizenPlanRepo citizenPlanRepo;

   
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		CitizenPlan c1 =  new CitizenPlan();
		c1.setName("guduu");
		c1.setBenefitAmount(1000);
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanStatus("Approved");
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setPlanName("car");
		c1.setGender("Male");
		
		CitizenPlan c2 =  new CitizenPlan();
		c2.setName("keshav");
		c2.setDenialReason("Fraud");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanStatus("Denied");
		c2.setTeminatedDate(LocalDate.now());
		c2.setPlanName("bike");
		c2.setGender("Male");
		
		CitizenPlan c3 =  new CitizenPlan();
		c3.setName("Kanha");
		c3.setTerminationReason("Job");
		c3.setPlanStartDate(LocalDate.now().minusMonths(2));
		c3.setPlanStatus("Terminated");
		c3.setTeminatedDate(LocalDate.now());
		c3.setPlanName("car");
		c3.setGender("Male");
		
		
		
		CitizenPlan c4 =  new CitizenPlan();
		c4.setName("himanshu");
		c4.setBenefitAmount(1000);
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanStatus("Approved");
		c4.setPlanName("hotel");
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setGender("Male");
		
		
		CitizenPlan c5 =  new CitizenPlan();
		c5.setName("didi");
		c5.setBenefitAmount(1000);
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanStatus("Approved");
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setPlanName("car");
		c5.setGender("Female");
		
		CitizenPlan c6 =  new CitizenPlan();
		c6.setName("chirag");
		c6.setDenialReason("Fraud");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanStatus("Denied");
		c6.setPlanName("bike");
		c6.setTeminatedDate(LocalDate.now());
		c6.setGender("Male");
		
		
		CitizenPlan c7 =  new CitizenPlan();
		c7.setName("Girl");
		c7.setBenefitAmount(1000);
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanStatus("Approved");
		c7.setPlanName("car");
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setGender("Female");
		
		CitizenPlan c8 =  new CitizenPlan();
		c8.setName("Akshat");
		c8.setTerminationReason("Job");
		c8.setPlanStartDate(LocalDate.now().minusMonths(2));
		c8.setPlanStatus("Terminated");
		c8.setPlanName("Home");
		c8.setTeminatedDate(LocalDate.now());
		c8.setGender("Male");
		
		
		CitizenPlan c9 =  new CitizenPlan();
		c9.setName("Koyal");
		c9.setBenefitAmount(1000);
		c9.setPlanStartDate(LocalDate.now());
		c9.setPlanStatus("Approved");
		c9.setPlanName("car");
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setGender("Female");
		
		
		List<CitizenPlan> ls= Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9);
		citizenPlanRepo.saveAll(ls);
		
		
	}

}
