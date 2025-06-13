package com.example.demo.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.Entity.Request;
import com.example.demo.Utils.ExcelGenerator;

import com.example.demo.Utils.MyMailSender;
import com.example.demo.repo.CitizenPlanRepo;
import com.example.demo.service.ReportService;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

//import jdk.jfr.snippets.Snippets.Example;


@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private CitizenPlanRepo citizenPlanRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private MyMailSender emailSender;
	

	@Override
	public List<String> planNameDropDown() {
		// TODO Auto-generated method stub
		List<String> pnames= new ArrayList<>();
		
		for(String s:citizenPlanRepo.getPlanNames())
			{
				if(s != "" && s != null)
				{	
					System.out.println("value "+s);
					pnames.add(s);
				}
			}
		System.out.println("HII pnames "  + pnames);
		return pnames;
	}

	@Override
	public List<String> planStatusDropDown() {
		// TODO Auto-generated method stub
		System.out.println("status" + citizenPlanRepo.getPlanStatus());
		return  citizenPlanRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(Request request) {
		CitizenPlan cp = new CitizenPlan();
		if(request.getPlanName() != "" && request.getPlanName() != null)
		{
			cp.setPlanName(request.getPlanName());
		}
		if(request.getPlanStatus() != "" && request.getPlanStatus() != null)
		{
			cp.setPlanStatus(request.getPlanStatus());
		}
		if(request.getGender() != "" && request.getGender() != null)
		{
			cp.setGender(request.getGender());
		}
		System.out.println(cp);
		Example<CitizenPlan>  example = Example.of(cp);
		System.out.println("DB data "+citizenPlanRepo.findAll(example));
		return citizenPlanRepo.findAll(example);
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException {
		
		List<CitizenPlan> plans =  citizenPlanRepo.findAll();
		XSSFWorkbook workbook = excelGenerator.generateExcel(plans);
		
		ServletOutputStream stream = response.getOutputStream();
        workbook.write(stream);
        
		workbook.close();
		
	}
	
	

	@Override
	public Boolean exportPdf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendemail(String mailId) throws MessagingException {
		// TODO Auto-generated method stub
		File file = new File("plan.xlsx");
		List<CitizenPlan> plans =  citizenPlanRepo.findAll();
		XSSFWorkbook workbook;
		try {
			FileOutputStream fo = new FileOutputStream(file);
			workbook = excelGenerator.generateExcel(plans);
			workbook.write(fo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		emailSender.sendEmail(mailId,file);
		
	}

}
