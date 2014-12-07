package com.sd.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.app.service.EmployeeService;


@Controller
public class GenerateQuotationController {
	
	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping(value="/generateQuotation", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("generateQuotation", model);
	}
}
