package com.sd.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sd.web.dto.BaseDTO;
import com.sd.web.dto.TechnologyDTO;
import com.sd.web.form.TechnologyForm;
import com.sd.web.security.Ticket;
import com.sd.web.services.SolutionDeskService;
import com.sd.web.services.TechnologyService;
import com.sd.web.util.FormDTOFiller;
import com.sd.web.util.JsonResponse;
import com.sd.web.util.Parameters;

@Controller
public class TechnologyController extends BaseController {
	private final TechnologyService technologyService = getTechnologyService();

	@RequestMapping(value = "/technology.do", method = RequestMethod.GET)
	public String formBackingObject(Model model) throws ServletException {
		TechnologyForm technologyForm = new TechnologyForm();
		System.out.println("-------formBackingObject");
		technologyForm.setChapterName("Chapter Name");
		System.out.println("-------formBackingObject 1 ");
		model.addAttribute("TechnologyForm", technologyForm);

		/*
		 * The backing object should be set up here, with data for the initial
		 * values of the form’s fields. This could either be hard-coded, or
		 * retrieved from a database.
		 */

		return "technologyForm";
	}

	protected String getDeleteLink(BaseDTO baseDTO) {
		return "<a href=/technologyList.do?id=" + baseDTO.getId() + "> Delete</a>";
	}

	protected String getEditLink(BaseDTO baseDTO) {
		return "<a href=/technologyList.do?id=" + baseDTO.getId() + "> Edit</a>";
	}

	@Override
	protected Object[] getListingData(BaseDTO baseDTO, HttpServletRequest request) {
		Object listingDetails[] = new Object[2];

		List<Object[]> dataListDetails = new ArrayList<Object[]>();
		String headers[] = { "Technology Name", "Chapter Name", "Topic Name" };
		Object dataList[] = new Object[headers.length + 1];
		listingDetails[0] = headers;

		List<TechnologyDTO> findAll = new ArrayList<TechnologyDTO>();
		try {

			findAll = technologyService.findAll(getTicket(request), new TechnologyDTO());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("List Size " + findAll.size());

		for (TechnologyDTO techDTO : findAll) {
			dataList[0] = techDTO.getId();
			dataList[1] = getViewLink(techDTO, techDTO.getTechName());
			dataList[2] = techDTO.getChapterName();
			dataList[3] = techDTO.getTopicName();

			dataListDetails.add(dataList);
		}
		listingDetails[1] = dataListDetails;
		return listingDetails;
	}

	// JsonResponse getTechnologyList(@RequestParam("name")String name,
	// @RequestParam("type")String type) {
	@RequestMapping(value = "/technologyList.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getTechDetailList(Parameters param, BindingResult result, HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		List<String> techList = new ArrayList<String>();
		System.out.println("TechName " + param.getTechName());
		System.out.println("ChapterName " + param.getChapterName());
		Ticket ticket = getTicket(request);
		List<TechnologyDTO> findAll = new ArrayList<TechnologyDTO>();
		try {
			String spec = null;
			if ((null != param.getTechName()) && (null != param.getChapterName())) {
				spec = "techName = '" + param.getTechName() + "' AND chapterName = '" + param.getChapterName() + "'";
				findAll = technologyService.findBySpec(ticket, new TechnologyDTO(), spec);
			} else if ((null != param.getTechName()) && (null == param.getChapterName())) {
				spec = "techName = '" + param.getTechName() + "'";
				findAll = technologyService.findBySpec(ticket, new TechnologyDTO(), spec);
			} else {

				findAll = technologyService.findAll(ticket, new TechnologyDTO());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("List Size " + findAll.size()); //

		for (TechnologyDTO techDTO : findAll) {
			if (null != techDTO.getTechName()) {
				System.out.println("techDTO.getTechName()...: " + techDTO.getTechName());
				if ((null != param.getTechName()) && (null != param.getChapterName())) {
					if (techDTO.getChapterName() != null) {
						techList.add(techDTO.getChapterName());
					}
				} else if ((null != param.getTechName()) && (null == param.getChapterName())) {
					if (techDTO.getTopicName() != null) {
						techList.add(techDTO.getTopicName());
					}

				} else {
					techList.add(techDTO.getTechName());
				}

			}
		}
		res.setStatus("SUCCESS");
		res.setResult(techList);

		return res;
	}

	/*
	 * @RequestMapping(value = "/technologyList.do", method =
	 * RequestMethod.POST) public @ResponseBody JsonResponse
	 * getTechnologyList(@RequestParam("name") String name) { JsonResponse res =
	 * new JsonResponse();
	 * 
	 * System.out.println("test..."); return res; }
	 */
	private TechnologyService getTechnologyService() {
		TechnologyService technologyService = (TechnologyService) SolutionDeskService.getService("com.sd.web.services.TechnologyServiceImpl");
		return technologyService;
	}

	protected String getViewLink(BaseDTO baseDTO, Object name) {
		return "<a href=/technologyList.do?id=" + baseDTO.getId() + "> " + name + "</a>";
	}

	@RequestMapping(value = "/technology.do", method = RequestMethod.POST)
	public ModelAndView save(TechnologyForm technologyForm, BindingResult result, HttpServletRequest request) throws ServletException {
		TechnologyDTO technologyDTO = new TechnologyDTO();
		try {
			System.out.println("technologyForm.getTechName() = " + technologyForm.getTechName());
			System.out.println("technologyForm.getTopicName() = " + technologyForm.getTopicName());
			System.out.println("technologyForm.getChapterName() = " + technologyForm.getChapterName());
			technologyDTO = (TechnologyDTO) FormDTOFiller.getDTO(technologyForm);
			technologyService.save(new Ticket(), technologyDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("ErrorPage");
		}
		Object[] listingData = getListingData(technologyDTO, request);
		request.setAttribute("headerList", listingData[0]);
		request.setAttribute("dataList", listingData[1]);
		request.setAttribute("entityName", "technology");
		return new ModelAndView("listingPage");
	}

	@RequestMapping(value = "/technologyList.do", method = RequestMethod.GET)
	public String technologyList(HttpServletRequest request) throws ServletException {
		Object[] listingData = getListingData(null, request);
		request.setAttribute("headerList", listingData[0]);
		request.setAttribute("dataList", listingData[1]);
		request.setAttribute("entityName", "technology");

		return "listingPage";
	}
}
