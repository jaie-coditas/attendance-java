package com.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.DTO.AttendanceRecordDTO;
import com.attendance.DTO.EmployeeDTO;
import com.attendance.DTO.ManagarDTO;
import com.attendance.dao.AttendanceDao;
import com.attendance.dao.EmployeeDao;
import com.attendance.dao.ManagerDao;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class AttendanceService {
	
	@Autowired
	private EmployeeDao empdao;
	
	//private final Logger log = LoggerFactory.getLogger(AttendanceService.class);
	
	@Autowired
	private AttendanceDao attendancedao;
	
	@Autowired
	private ManagerDao managerdao;
	 private static final String FILE_NAME = "C:\\Users\\coditas\\Downloads\\test.xlsx";
	 DataFormatter formatter = new DataFormatter();
	 public void readExcel()
	 {
	 try {

         FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
         Workbook workbook = new XSSFWorkbook(excelFile);
         for(int j=0;j<workbook.getNumberOfSheets();j++)
         {
         Sheet worksheet = workbook.getSheetAt(j);
         EmployeeDTO empdto=new EmployeeDTO();
         for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
             Row row = worksheet.getRow(i); 
             AttendanceRecordDTO attendancedto=new  AttendanceRecordDTO();
             empdto.setEmpcode((int) row.getCell(0).getNumericCellValue());
             empdto.setEmpname(row.getCell(1).getStringCellValue());
             empdto.setDept(row.getCell(2).getStringCellValue());
             empdto.setShift(row.getCell(3).getStringCellValue());
             attendancedto.setDate(row.getCell(4).getDateCellValue());
             attendancedto.setIn_time(formatter.formatCellValue( worksheet .getRow(i).getCell(5)));
             attendancedto.setOut_time(formatter.formatCellValue( worksheet .getRow(i).getCell(6)));
              attendancedto.setDuration(row.getCell(7).getNumericCellValue());
             // log.debug(row.getCell(7).getStringCellValue());
              attendancedto.setStatus(formatter.formatCellValue( worksheet .getRow(i).getCell(8)));
              attendancedto.setEmp(empdto);
                 empdao.save(empdto);  
                 attendancedao.save(attendancedto);  
         }
         
         }
         
        
   
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e1) {
         e1.printStackTrace();
     }


	}
	public List<ManagarDTO> findAllManagers()
	{
		List<ManagarDTO> managerList=new ArrayList<ManagarDTO>();
		
		for(ManagarDTO m:managerdao.findAll())
		{
			managerList.add(m);
		}
		return managerList;
	}
	public List<EmployeeDTO> findAllEmp(String name) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> emplist=new ArrayList<>();
		
		ManagarDTO m=managerdao.findByName(name);
		int id=m.getMid();
		for(EmployeeDTO e:empdao.findByManager(m))
		{
			if(m.getMid()==id)
			{
				emplist.add(e);
				System.out.println(e.getEmpname());
			}
		}
		return emplist;
	}
	public static String getMonth(Date date) {

	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
	    return dateFormat.format(date);

	} 
	public void addComment(String com,int id)
	{
		AttendanceRecordDTO a=attendancedao.findOne(id);
		a.setComment(com);
		attendancedao.save(a);
	}
	public List<AttendanceRecordDTO> getAttendanceRecord(String name,String month)
	{
		List<AttendanceRecordDTO> attList=new ArrayList<>();
			EmployeeDTO e=empdao.findByEmpname(name);
				for(AttendanceRecordDTO a2:attendancedao.findByEmp(e))
				{
					Date d=a2.getDate();
					if(name.equalsIgnoreCase(e.getEmpname())&& month.equals(getMonth(d)))
					{
						attList.add(a2);
					}
				}
			
		return attList;
	}
	public List<String> allMonths()
	{
		String a[]= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		List<String> months=Arrays.asList(a);
		return months;
	}
	public Iterable<AttendanceRecordDTO> getAttendancedetails() {
	
		Iterable<AttendanceRecordDTO> al= attendancedao.findAll();
		return al;
		
	}
}


