package com.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.service.AttendanceService;

@Controller
//@RequestMapping("/get")
public class MainController {
	
	@Autowired
	private AttendanceService service;
	
	/*@GetMapping("/name/{name}")
	public ModelAndView getEmpDetails(@PathVariable ("name") String name)
	{
		ModelAndView m=new ModelAndView();
		m.addObject("emplist", service.findAllEmp(name));
	//	m.addObject("months", service.allMonths());
		System.out.println("hello from controller");
		m.addObject("mode", "EMP_VIEW");
		m.setViewName("record");
		return m;
	}*/

}
