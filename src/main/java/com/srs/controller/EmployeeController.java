package com.srs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srs.bean.EmployeeBean;
import com.srs.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService empService;
	

	/*@RequestMapping(value = "/index", method = RequestMethod.GET)

	public ModelAndView getLoginPage(){
		return new ModelAndView("/login");
	}*/

	@RequestMapping(value = "/home", method = RequestMethod.POST)

	public ModelAndView loginCheck(@RequestParam("UserName") String str1, @RequestParam("Password") String str2){

		if(str1.equals("srs") && str2.equals("java"))
		{
			return new ModelAndView("/home");
		}
		else
		{
			return new ModelAndView("/login");

		}
	}

	
	@RequestMapping(value="/empDetails")
	public ModelAndView addEmployee(@ModelAttribute EmployeeBean empBean,ModelMap model){
		model.addAttribute("empBean",empBean);
		
		return new ModelAndView("/empDetails");
	}
	
	@RequestMapping(value="/addEmpDetails",method = RequestMethod.POST)
	public ModelAndView empDetailsInfo(@ModelAttribute EmployeeBean empBean,ModelMap model){
		System.out.println("entered");
		empService.addEmployeeInfo(empBean);
		
		return new ModelAndView("empDetailsInfo",model);
	}
	
}
