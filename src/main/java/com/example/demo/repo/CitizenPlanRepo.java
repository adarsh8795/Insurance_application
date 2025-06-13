package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CitizenPlan;

@Repository
public interface CitizenPlanRepo  extends JpaRepository<CitizenPlan, Integer>{
	
	@Query("Select DISTINCT(planName) from CitizenPlan")	
	public List<String> getPlanNames();
	
	@Query("Select distinct(planStatus) from CitizenPlan")	
	public List<String> getPlanStatus();


	

}