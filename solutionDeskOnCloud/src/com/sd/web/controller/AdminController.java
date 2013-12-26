package com.sd.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/fileAction", method = RequestMethod.GET)
	public String fileAction(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String location = request.getParameter("location");
		String action = request.getParameter("action");
		System.out.println("location: "+location+"---- action: "+action);
		String osName = System.getProperty("os.name");
		if(osName.contains("Windows"))
			location = "c:"+location;
		
		System.out.println("osName: "+osName);
		// System.getProperties().list(System.out);
		if("download".equalsIgnoreCase(action)){
			fileDownload(location,response);
		}else if("update".equalsIgnoreCase(action)){
			fileUpdate(location);
		}else if("delete".equalsIgnoreCase(action)){
			fileDelete(location);
		}

		return "adminPage";
	}
	

	private String fileDownload(String location, HttpServletResponse response){ 
		 FileInputStream fileInputStream = null; 
		try {
	        // Get the directory and iterate them to get file by file...
	        File file = new File(location);

	            response.setContentType("APPLICATION/DOWNLOAD");
	            response.setHeader("Content-Disposition", "attachment"+ 
	                                     "filename=" + file.getName());
	            fileInputStream = new FileInputStream(file);
	            response.setContentLength(fileInputStream.available());
	            OutputStream os = response.getOutputStream();      
	            os.close();
	            response.flushBuffer();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (fileInputStream != null) {
	            try {
	            	fileInputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		return "adminPage";
	}

	private String fileUpdate(String location){ 
		File file = new File(location);
		return "File Updated";
	}
	private String fileDelete(String location){ 
		File file = new File(location);
		file.deleteOnExit();
		return "File is Deleted";
	}

}
