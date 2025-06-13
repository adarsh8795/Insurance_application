package com.example.demo.Entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
@Table(name = "citizen_plan")
public class CitizenPlan {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String name;
		
		private String gender;
		
		
		private String planName;
		
		private String planStatus;
		
		private String denialReason;
		
		private LocalDate planStartDate;
		
		private LocalDate planEndDate;
		
		private LocalDate teminatedDate;
		
		private String terminationReason;
		
		private Integer benefitAmount;

}
