package com.sd.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.web.dto.LogonDTO;
import com.sd.web.form.LogonForm;
import com.sd.web.security.Ticket;
import com.sd.web.services.LogonService;
import com.sd.web.services.SolutionDeskService;
import com.sd.web.util.FormDTOFiller;

@Controller
public class LogonController {
	private static final Logger logger = Logger.getLogger(LogonController.class);

	@RequestMapping(value = "/forgotPassword.do", method = RequestMethod.POST)
	public ModelAndView forgotPassword(LogonForm logonForm, BindingResult result, HttpServletRequest request) throws ServletException {
		// LogonForm logonForm = (LogonForm) command;
		System.out.println("username :" + logonForm.getUserName());
		System.out.println("password :" + logonForm.getPassword());
		System.out.println("session id :" + request.getSession().getId());
		// Now you can validate to database
		LogonService logonService = getLogonService();
		LogonDTO logonDTO = (LogonDTO) FormDTOFiller.getDTO(logonForm);
		try {
			Ticket ticket = logonService.authenticateUser(logonDTO);

			if (ticket != null) {
				// if (true) {
				request.getSession().setAttribute("ticket", ticket);
				// request.setAttribute("ticket", ticket);
				return new ModelAndView("menuPage", "ticket", ticket);
			} else {
				return new ModelAndView("index", "invalidUser", "Invalid User");
			}
			// if()
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
	}

	@RequestMapping(value = "logonPage.do", method = RequestMethod.GET)
	public String formBackingObject(Model model,HttpServletRequest request) throws ServletException {
		// LogonForm logonForm = new LogonForm();
		logger.info("login Form is started...");
		if (logger.isDebugEnabled()) {
			System.out.println("is dubug enabled... ");
			logger.debug(model);
		}
		
		if(null != request.getSession().getAttribute("ticket")){
			request.getSession().invalidate();
		}
		LogonForm logonForm = new LogonForm();
		logonForm.setUserName("admin");
		logonForm.setPassword("12345678");
		System.out.println("-------formBackingObject 1 ");
		model.addAttribute("LogonForm", logonForm);
		// request.getSession();
		/*
		 * The backing object should be set up here, with data for the initial
		 * values of the form’s fields. This could either be hard-coded, or
		 * retrieved from a database.
		 */

		return "logonForm";
	}

	private LogonService getLogonService() {
		LogonService logonService = (LogonService) SolutionDeskService.getService("com.sd.web.services.LogonServiceImpl");
		return logonService;
	}

	@RequestMapping(value = "logOut.do", method = RequestMethod.GET)
	public String logOut(Model model, HttpServletRequest request) throws ServletException {
		// LogonForm logonForm = new LogonForm();

		LogonForm logonForm = new LogonForm();
		logonForm.setUserName("admin");
		logonForm.setPassword("admin");
		System.out.println("-------formBackingObject 1 ");
		request.getSession().invalidate();
		model.addAttribute("LogonForm", logonForm);
		// request.getSession();
		/*
		 * The backing object should be set up here, with data for the initial
		 * values of the form’s fields. This could either be hard-coded, or
		 * retrieved from a database.
		 */

		return "logonForm";
	}

	@RequestMapping(value = "/logonPage.do", method = RequestMethod.POST)
	public ModelAndView onSubmit(LogonForm logonForm, BindingResult result, HttpServletRequest request) throws ServletException {
		// LogonForm logonForm = (LogonForm) command;
		System.out.println("username :" + logonForm.getUserName());
		System.out.println("password :" + logonForm.getPassword());
		System.out.println("session id :" + request.getSession().getId());
		// Now you can validate to database
		LogonService logonService = getLogonService();
		LogonDTO logonDTO = (LogonDTO) FormDTOFiller.getDTO(logonForm);
		try {
			Ticket ticket = logonService.authenticateUser(logonDTO);

			if (ticket != null) {
				// if (true) {
				request.getSession().setAttribute("ticket", ticket);
				// request.setAttribute("ticket", ticket);
				return new ModelAndView("menuPage", "ticket", ticket);
			} else {
				return new ModelAndView("index", "invalidUser", "Invalid User");
			}
			// if()
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
	}

}
