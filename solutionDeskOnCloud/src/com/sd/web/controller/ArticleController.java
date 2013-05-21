package com.sd.web.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sd.web.dto.TechnologyDTO;
import com.sd.web.form.ArticleForm;
import com.sd.web.security.Ticket;
import com.sd.web.services.ArticleService;
import com.sd.web.services.SolutionDeskService;
import com.sd.web.util.AlertHandler;
import com.sd.web.util.ApplicationContext;
import com.sd.web.util.FileName;
import com.sd.web.util.JsonResponse;
import com.sd.web.util.Parameters;

@Controller
public class ArticleController extends BaseController {
	private static ServletContext servletContext = ApplicationContext.getInstance().getServletContext();
	private static Properties configProp = ApplicationContext.getInstance().getConfigProp();
	private static final String DESTINATION_HTML_DIR_PATH = configProp.getProperty("destination.html.dir.path");

	public static void deleteFile(String filePath) {

		try {
			if ((null != filePath) && (filePath.length() > 0)) {
				File file = new File(filePath);
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> getFileHtmlList(String entityId) {
		String realPath = getRealPath(entityId);

		File file = new File(realPath);
		List<String> fileList = new ArrayList<String>();
		String[] list = file.list();

		String folderPath = DESTINATION_HTML_DIR_PATH + "/" + entityId + "/";
		if ((null != list) && (list.length > 0)) {
			for (String fileName : list) {
				if (!fileName.contains("Del")) {
					fileList.add(folderPath + fileName);
				}
			}

		}
		return fileList;
	}

	private static String getRealPath(String entityId) {
		File tmpDir = new File(servletContext.getRealPath(DESTINATION_HTML_DIR_PATH));
		if (!tmpDir.isDirectory()) {
			tmpDir.mkdir();

		}
		System.out.println(servletContext.getRealPath(DESTINATION_HTML_DIR_PATH + "/" + entityId));

		return servletContext.getRealPath(DESTINATION_HTML_DIR_PATH + "/" + entityId);
	}

	private final ArticleService articleService = getArticleService();

	@RequestMapping(value = "articleDisplay.do", method = RequestMethod.GET)
	public String articleDisplay(Model model, HttpServletRequest request) throws ServletException {
		ArticleForm articleForm = new ArticleForm();
		System.out.println("EntityName : " + request.getParameter("entityName"));
		System.out.println("EntityType : " + request.getParameter("entityType"));
		System.out.println("EntityId : " + request.getParameter("entityId"));
		String entityId = request.getParameter("entityId");
		request.setAttribute("entityId", entityId);
		String recentFileName = getRecentFileName(entityId);
		if (null != recentFileName) {
			request.setAttribute("totalFileNames", getFileHtmlList(entityId));
			request.setAttribute("fileURL", "html/" + entityId + "/" + recentFileName);
		}
		return "articleDisplay";
	}

	@RequestMapping(value = "articleEditor.do", method = RequestMethod.GET)
	public String articleEditor(Model model, HttpServletRequest request) throws ServletException {
		ArticleForm articleForm = new ArticleForm();
		System.out.println(" request.getParameter(entityId) : " + request.getParameter("entityId"));
		request.setAttribute("getId", request.getParameter("entityId"));
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		List<String> fileList = FileUploadController.getFileList(ticket.getUserName());
		request.setAttribute("fileList", fileList);

		List<String> fileHtmlList = getFileHtmlList(request.getParameter("entityId"));

		request.setAttribute("htmlFileList", fileHtmlList);

		articleForm.setId(request.getParameter("entityId"));
		model.addAttribute("ArticleForm", articleForm);
		return "articleEditor";
	}

	@RequestMapping(value = "article.do", method = RequestMethod.GET)
	public String formBackingObject(Model model) throws ServletException {
		ArticleForm articleForm = new ArticleForm();
		System.out.println("-------formBackingObject");
		articleForm.setDescription("Description");
		System.out.println("-------formBackingObject 1 ");
		/*
		 * The backing object should be set up here, with data for the initial
		 * values of the form’s fields. This could either be hard-coded, or
		 * retrieved from a database.
		 */
		model.addAttribute("ArticleForm", articleForm);
		return "articleForm";
	}

	private ArticleService getArticleService() {
		ArticleService articleService = (ArticleService) SolutionDeskService.getService("com.sd.web.services.ArticleServiceImpl");
		return articleService;
	}

	private String getRecentFileName(String entityId) {
		Integer fileSequence = null;
		String[] list = null;
		File file = new File(getRealPath(entityId));
		if (!file.isDirectory()) {
			file.mkdir();
		} else {
			list = file.list();
			if ((list != null) && (list.length > 0)) {
				Map<Integer, String> sqList = new HashMap<Integer, String>();
				for (String listTemp : list) {
					try {
						sqList.put(Integer.parseInt(listTemp.split("_")[0]), listTemp);
					} catch (NumberFormatException ignore) {
					}
				}
				if ((sqList != null) && (sqList.size() > 0)) {
					fileSequence = Collections.max(sqList.keySet());
					return sqList.get(fileSequence);
				}
			}
		}

		return null;
	}

	@RequestMapping(value = "/articleDisplayRequest.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getTechDetailList(Parameters param, BindingResult result) {
		JsonResponse res = new JsonResponse();
		List<String> techList = new ArrayList<String>();
		System.out.println("TechName " + param.getTechName());
		System.out.println("ChapterName " + param.getChapterName());

		List<TechnologyDTO> findAll = new ArrayList<TechnologyDTO>();
		try {/*
				 * String spec = null; if ((null != param.getTechName()) &&
				 * (null != param.getChapterName())) { spec = "techName = '" +
				 * param.getTechName() + "' AND chapterName = '" +
				 * param.getChapterName() + "'"; findAll =
				 * technologyService.findBySpec(ticket, new TechnologyDTO(),
				 * spec); } else if ((null != param.getTechName()) && (null ==
				 * param.getChapterName())) { spec = "techName = '" +
				 * param.getTechName() + "'"; findAll =
				 * technologyService.findBySpec(ticket, new TechnologyDTO(),
				 * spec); } else {
				 * 
				 * findAll = technologyService.findAll(ticket, new
				 * TechnologyDTO()); }
				 */
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	@RequestMapping(value = "/article.do", method = RequestMethod.POST)
	public ModelAndView save(Model model, ArticleForm articleForm, BindingResult result) throws ServletException {
		try {/*
				 * 
				 * String spec = " techName = '" + articleForm.getTechName() + "'
				 * and chapterName = '" + articleForm.getChapterName() + "' and
				 * topicName = '" + articleForm.getTopicName() + "'";
				 * articleForm.setTechnologyId(articleService.findTechnologyId(spec));
				 * BaseDTO baseDto = null; if
				 * (ArticleType.ARTICLE.toString().equalsIgnoreCase(articleForm.getArticleType())) {
				 * baseDto = FormDTOFiller.getDTO(articleForm, new
				 * ArticleDTO()); } else if
				 * (ArticleType.OBJECTIVEQA.toString().equalsIgnoreCase(articleForm.getArticleType())) {
				 * baseDto = FormDTOFiller.getDTO(articleForm, new
				 * ObjectiveQADTO()); } else if
				 * (ArticleType.OBJECTIVEQA.toString().equalsIgnoreCase(articleForm.getArticleType())) {
				 * baseDto = FormDTOFiller.getDTO(articleForm, new
				 * SubjectiveQADTO()); } articleService.save(new Ticket(),
				 * baseDto);
				 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("ArticleForm", articleForm);
		return new ModelAndView("articleDisplay");
	}


	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/saveArticleData.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse saveArticleData(Parameters param, BindingResult result, HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		
		List<String> techList = new ArrayList<String>();
		Ticket ticket = getTicket(request);
		Integer fileSequence = null;
		if (null != ticket) {
			try {
				String filePath = request.getParameter("filePath");
				if ((null != filePath) && (filePath.length() > 0)) {
					deleteFile(filePath);
				}
				String returnFileName = getRecentFileName(param.getId());
				if (null != returnFileName) {
					fileSequence = Integer.parseInt(returnFileName.split("_")[0]);
					FileName.setSequence(fileSequence + 1);
				} else {
					FileName.setSequence(1);
				}
				filePath = getRealPath(param.getId()) + "/" + FileName.getFileName(ticket.getUserName().toString());
				FileWriter fstream = new FileWriter(filePath);
				BufferedWriter out = new BufferedWriter(fstream);
				String articleData = "<HTML><BODY>" + param.getArticle() + "</BODY></HTML>";
				
				out.write(articleData);
				out.close();
				 AlertHandler alertHandler = new AlertHandler();
				 alertHandler.sendEmail(ticket.getEmail(), "", "", "New Article Created", null, articleData);
				 techList.add("Data Saved Successfully," + filePath + "," + param.getId());
				techList.add("test");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			techList.add("Please Logon,1," + param.getId());
		}
		
		res.setStatus("SUCCESS");
		res.setResult(techList);

		return res;
	}


	
	
	
	
	
}