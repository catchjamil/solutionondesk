package com.sd.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sd.web.security.Ticket;

@Controller
public class AdminController extends BaseController {


	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/adminService.do", method = RequestMethod.GET)
	public String userRegistrationList(HttpServletRequest request) throws ServletException {
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		System.out.println("Ticket---Admin: "+ticket);
		String realPath = request.getRealPath("/");
		request.setAttribute("dir", realPath);
		//String tempPath = getClass().getResource("/").getPath(); 
		return "adminPage";
	}
}
