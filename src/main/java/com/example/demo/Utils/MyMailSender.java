package com.example.demo.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletOutputStream;

@Component
public class MyMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	 public void sendEmail(String toEmail,File file) throws MessagingException { 
		
					MimeMessage message = javaMailSender.createMimeMessage();
					
					// Set multipart = true for attachment
					MimeMessageHelper helper = new MimeMessageHelper(message, true);
					
					helper.setTo(toEmail);
					helper.setSubject("test email");
					helper.setText("Hi, Kindly find your attached file below");
					
					
					// Attach the file
					
					
					
					helper.addAttachment("plan.xlsx", file);
					
					javaMailSender.send(message);
				}
					
		}
		
			
		
		
