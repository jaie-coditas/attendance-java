package com.attendance.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.dao.AttendanceDao;
import com.attendance.service.AttendanceService;

@Controller
public class ExcelRestController {
	
	@Autowired
	private AttendanceService service;
	
	@GetMapping("/")
	public String init()  {

		return "index";   
	}
	@GetMapping("/readExcel")
	public String mapReapExcelDatatoDB()  {
	    service.readExcel();
	    return "index";
	    
	}
	@GetMapping("/name/{name}/{month}")
	public ModelAndView getEmpDetails(@PathVariable ("name") String name,@PathVariable ("month") String month)
	{
		ModelAndView m=new ModelAndView();
		m.addObject("emplist", service.findAllEmp(name));
		m.addObject("selmonth", month);
	//	m.addObject("months", service.allMonths());
		System.out.println("hello from controller");
		m.addObject("mode", "EMP_VIEW");
		m.setViewName("details");
		return m;
	}
	@GetMapping("/details")
	public ModelAndView getDetails()
	{
		ModelAndView m=new ModelAndView();
		m.addObject("managerList", service.findAllManagers());
		m.addObject("months", service.allMonths());
		m.setViewName("details");
		m.addObject("mode", "MANAGER");
		return m;
	}
	@GetMapping("/month/{month}")
	public ModelAndView getMonth(@PathVariable ("month") String month)
	{
		ModelAndView m=new ModelAndView();
		m.addObject("managerList", service.findAllManagers());
		m.addObject("mode", "MANAGER");
		//model.addAttribute("selectedMonth", month);
		m.addObject("currentMonth", month);
		//req.setAttribute("selectedMonth", month);
		System.out.println(month);
		m.setViewName("details");
		
		return m;
	}
	
	@GetMapping("/process")
	public ModelAndView getAttendetails(@RequestParam("currname") String name,@RequestParam("currmonth") String month)
	{
		ModelAndView m=new ModelAndView();
		m.addObject("attlist", service.getAttendanceRecord(name,month));
		System.out.println("hello from month controller"+month);
		m.addObject("mode", "ATT_VIEW");
		m.addObject("managerList", service.findAllManagers());
		m.setViewName("record");
		return m;
	}
	
	@GetMapping("/save/{id}")
	public ModelAndView saveComment(@RequestParam("cn") String comm,@PathVariable("id") int id)
	{
		ModelAndView m=new ModelAndView();
		System.out.println(comm);
		service.addComment(comm,id);
		m.addObject("attlist",service.getAttendancedetails());
		m.addObject("mode", "ATT_VIEW");
		m.setViewName("record");
		return m;
	}
	
	
}
