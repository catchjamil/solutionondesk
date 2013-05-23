package com.sd.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.TechnologyDTO;
import com.sd.web.dto.UserRegistrationDTO;
import com.sd.web.enums.Roles;
import com.sd.web.exception.DatabaseException;
import com.sd.web.form.LogonForm;
import com.sd.web.form.UserRegistrationForm;
import com.sd.web.security.Ticket;
import com.sd.web.services.SolutionDeskService;
import com.sd.web.services.UserRegistrationService;
import com.sd.web.util.AlertHandler;
import com.sd.web.util.FormDTOFiller;
import com.sd.web.util.JsonResponse;
import com.sd.web.util.Parameters;


@Controller
public class UserRegistrationController extends BaseController {
	

	private final UserRegistrationService userRegistrationService = getUserRegistrationService();
	UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();

	@RequestMapping(value = "/userRegistrationDelete.do", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) throws ServletException {
		try {
			String chklist = request.getParameter("chklist");
			String[] parameterValues = chklist.split("-");
			userRegistrationService.delete(getTicket(request), new UserRegistrationDTO(), parameterValues);
			setDataList(request);
			request.setAttribute("entityName", "userRegistration");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listingPage";
	}

	@RequestMapping(value = "/userRegistration.do", method = RequestMethod.GET)
	public String formBackingObject(Model model, HttpServletRequest request) throws ServletException {
		UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
		String id = request.getParameter("id");

		if (id != null) {

			try {
				userRegistrationDTO = userRegistrationService.findById(getTicket(request), userRegistrationDTO, id);
				userRegistrationForm = (UserRegistrationForm) FormDTOFiller.getForm(userRegistrationDTO);
				userRegistrationForm.setId(id);
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("userRegistration", userRegistrationForm);
		model.addAttribute("UserRegistrationForm", userRegistrationForm);

		return "userRegistrationForm";
	}

	@RequestMapping(value = "/getGeographyDetails.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getGeographyDetails(Parameters param, BindingResult result) {
		JsonResponse res = new JsonResponse();
		List<String> techList = new ArrayList<String>();
		System.out.println("getCountryName " + param.getCountryName());
		System.out.println("getStateName " + param.getStateName());

		List<TechnologyDTO> findAll = new ArrayList<TechnologyDTO>();
		try {
			if ((null != param.getCountryName()) && (null != param.getStateName())) {/*
			 * spec =
			 * "techName = '" +
			 * param.getTechName() + "'
			 * AND
			 * chapterName = '" +
			 * param.getChapterName() +
			 * "'";
			 * findAll =
			 * technologyService.findBySpec(ticket,
			 * new
			 * TechnologyDTO(),
			 * spec);
			 */
			} else if ((null != param.getTechName()) && (null == param.getChapterName())) {/*
			 * spec =
			 * "techName = '" +
			 * param.getTechName() +
			 * "'";
			 * findAll =
			 * technologyService.findBySpec(ticket,
			 * new
			 * TechnologyDTO(),
			 * spec);
			 */
			} else {

				// findAll = technologyService.findAll(ticket, new
				// TechnologyDTO());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("List Size " + findAll.size()); //

		/*
		 * for (TechnologyDTO techDTO : findAll) { if (null !=
		 * techDTO.getTechName()) {
		 * System.out.println("techDTO.getTechName()...: " +
		 * techDTO.getTechName()); if ((null != param.getTechName()) && (null !=
		 * param.getChapterName())) { if (techDTO.getChapterName() != null) {
		 * techList.add(techDTO.getChapterName()); } } else if ((null !=
		 * param.getTechName()) && (null == param.getChapterName())) { if
		 * (techDTO.getTopicName() != null) {
		 * techList.add(techDTO.getTopicName()); } } else {
		 * techList.add(techDTO.getTechName()); } } }
		 */
		// techList.add(getCountryList());
		//techList.add("Other");
		res.setStatus("SUCCESS");
		res.setResult(getCountryList());

		return res;
	}

	@Override
	protected Object[] getListingData(BaseDTO baseDTO, HttpServletRequest request) {
		Object listingDetails[] = new Object[2];

		List<Object[]> dataListDetails = new ArrayList<Object[]>();
		String headers[] = { "User Name", "First Name", "Last Name", "Role" };
		Object dataList[] = null;
		listingDetails[0] = headers;

		List<UserRegistrationDTO> findAll = new ArrayList<UserRegistrationDTO>();
		try {

			findAll = userRegistrationService.findAll(getTicket(request), new UserRegistrationDTO());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("List Size " + findAll.size());

		for (UserRegistrationDTO userRegistrationDTO : findAll) {
			dataList = new Object[headers.length + 1];
			dataList[0] = userRegistrationDTO.getId();
			dataList[1] = getViewLink(userRegistrationDTO, userRegistrationDTO.getUserName());
			dataList[2] = userRegistrationDTO.getFirstName();
			dataList[3] = userRegistrationDTO.getLastName();
			dataList[4] = userRegistrationDTO.getRole();

			dataListDetails.add(dataList);
		}
		listingDetails[1] = dataListDetails;
		return listingDetails;
	}

	private UserRegistrationService getUserRegistrationService() {
		UserRegistrationService userRegistrationService = (UserRegistrationService) SolutionDeskService.getService("com.sd.web.services.UserRegistrationServiceImpl");
		return userRegistrationService;
	}

	@RequestMapping(value = "/getUserRoleList.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getUserRoleList() {
		System.out.println("getUserRoleList...");
		JsonResponse res = new JsonResponse();
		List<String> techList = new ArrayList<String>();
		Roles[] values = Roles.values();
		for (Roles value : values) {
			techList.add(value.toString());
		}
		res.setStatus("SUCCESS");
		res.setResult(techList);

		return res;
	}

	protected String getViewLink(BaseDTO baseDTO, Object name) {
		return "<a href=userRegistration.do?id=" + baseDTO.getId() + "> " + name + "</a>";
	}

	@RequestMapping(value = "reSetPassword.do", method = RequestMethod.GET)
	public String reSetPassord(Model model, HttpServletRequest request) throws ServletException {
		UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
		model.addAttribute("UserRegistrationForm", userRegistrationForm);
		return "reSetPassword";
	}

	@RequestMapping(value = "/userRegistration.do", method = RequestMethod.POST)
	public ModelAndView save(UserRegistrationForm userRegistrationForm, BindingResult result, HttpServletRequest request) throws ServletException {
		try {
			UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) FormDTOFiller.getDTO(userRegistrationForm);
			Ticket ticket = getTicket(request);
			if (ticket != null) {
				userRegistrationService.save(ticket, userRegistrationDTO);
			} else {
				return new ModelAndView("logonForm");
			}
			setDataList(request);
			request.setAttribute("entityName", "userRegistration");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("listingPage");
	}

	@RequestMapping(value = "/userRegistrationUpdate.do", method = RequestMethod.POST)
	public ModelAndView update(Model model, UserRegistrationForm userRegistrationForm, BindingResult result, HttpServletRequest request) throws ServletException {
		try {
			System.out.println("userRegistrationForm.getFirstName() :  "+userRegistrationForm.getFirstName());
			System.out.println("userRegistrationForm.getLastName() :  "+userRegistrationForm.getLastName());
		
			
			UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) FormDTOFiller.getDTO(userRegistrationForm);
			System.out.println("userRegistrationDTO.getFirstName() :  "+userRegistrationDTO.getFirstName());
			System.out.println("userRegistrationDTO.getLastName() :  "+userRegistrationDTO.getLastName());
			System.out.println("userRegistrationForm.getId() :  "+userRegistrationForm.getId());
			System.out.println("userRegistrationForm.getPassword() :  "+userRegistrationForm.getPassword());
			
			Ticket ticket = getTicket(request);
			if ((ticket != null)) {
				if ((null != userRegistrationForm.getId()) && (userRegistrationForm.getPassword() == null || userRegistrationForm.getPassword().length()<8)) {
					userRegistrationDTO.setId(Long.parseLong(userRegistrationForm.getId()));
					userRegistrationService.update(ticket, userRegistrationDTO);
				} else {

					userRegistrationDTO.setId(ticket.getId());
					userRegistrationService.resetPwd(ticket, userRegistrationDTO);
				}
			} else {
				model.addAttribute("LogonForm", new LogonForm());
				return new ModelAndView("logonForm");
			}
			setDataList(request);
			request.setAttribute("entityName", "userRegistration");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("listingPage");
	}

	@RequestMapping(value = "/userRegistrationList.do", method = RequestMethod.GET)
	public String userRegistrationList(HttpServletRequest request) throws ServletException {
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		if (ticket != null) {
			setDataList(request);
		} else {
			return "logonForm";
		}

		request.setAttribute("entityName", "userRegistration");
		return "listingPage";
	}

	@RequestMapping(value = "/validateExistingUser.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse validateExistingUser(Parameters param, HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		List<String> techList = new ArrayList<String>();
		if (param.getUserName() != null) {
			String spec = " upper(userName)='" + param.getUserName().toUpperCase() + "'";
			try {
				List<UserRegistrationDTO> findBySpec = userRegistrationService.findBySpec(getTicket(request), new UserRegistrationDTO(), spec);
				System.out.println("findBySpec : " + findBySpec + " findBySpec.size() " + findBySpec.size());
				if ((findBySpec != null) && (findBySpec.size() > 0)) {
					techList.add("false");
					if ((null != param.getForgotPassword()) && "true".equals(param.getForgotPassword())) {

						AlertHandler alertHandler = new AlertHandler();
						String articleData = "Notification,<BR>Your password is: " + findBySpec.get(0).getPassword() + " <BR><BR> Regards,<BR> Solution Desk";
						try {
							alertHandler.sendEmail(findBySpec.get(0).getEmail(), "", "", "Password Recovered", null, articleData);
						} catch (Exception e) {
							res.setStatus("FAIL");
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				res.setStatus("FAIL");
				e.printStackTrace();
			}
		}

		res.setStatus("SUCCESS");
		res.setResult(techList);

		return res;
	}
	
	
	
	public Set getCountryList() {
	    Set<String> countries = new TreeSet<String>();

	    Locale[] locales = Locale.getAvailableLocales();
	    for (Locale locale : locales) {
	    	try{
	      String iso = locale.getISO3Country();
	      String code = locale.getCountry();
	      String name = locale.getDisplayCountry();

	      if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
	    	  countries.add(name);
	      }
	    	}catch(MissingResourceException e){
	    		e.printStackTrace();
	    	}
	    }

	   return countries;
	  }
}

	
	
