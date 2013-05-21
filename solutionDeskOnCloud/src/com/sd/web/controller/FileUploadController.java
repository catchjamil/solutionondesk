package com.sd.web.controller;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sd.web.security.Ticket;
import com.sd.web.util.ApplicationContext;
import com.sd.web.util.FileName;
import com.sd.web.util.JsonResponse;
import com.sd.web.util.Parameters;

@Controller
public class FileUploadController {
	private static ServletContext servletContext = ApplicationContext.getInstance().getServletContext();
	private static Properties configProp = ApplicationContext.getInstance().getConfigProp();
	private static String DESTINATION_DIR_PATH = configProp.getProperty("destination.dir.path");
	private static final String DESTINATION_HTML_DIR_PATH = configProp.getProperty("destination.html.dir.path");

	public static List<String> getFileList(String userName) {
		String realPath = getRealPath(userName);

		File file = new File(realPath);
		List<String> fileList = new ArrayList<String>();
		String[] list = file.list();

		String folderPath = DESTINATION_DIR_PATH + "/" + userName + "/";
		if ((null != list) && (list.length > 0)) {
			for (String fileName : list) {
				if (!fileName.contains("Del")) {
					fileList.add(folderPath + fileName);
				}
			}

		}
		return fileList;
	}

	private static String getRealPath(String userName) {

		File tmpDir = new File(servletContext.getRealPath(DESTINATION_DIR_PATH));
		if (!tmpDir.isDirectory()) {
			tmpDir.mkdir();

		}
		return servletContext.getRealPath(DESTINATION_DIR_PATH + "/" + userName);
	}

	@RequestMapping(value = "/deleteFile.do", method = RequestMethod.GET)
	public String deleteFile(HttpServletRequest request) throws ServletException {
		String filePath = request.getParameter("filePath");
		try {
			System.out.println("filePath ---- : " + filePath);
			if ((null != filePath) && (filePath.length() > 0)) {
				int firstIndex = filePath.indexOf("/", 1);
				String fileName = filePath.substring(firstIndex);
				String realPath = null;
				if (filePath.contains("html")) {
					realPath = servletContext.getRealPath(DESTINATION_HTML_DIR_PATH) + fileName;
				} else {
					realPath = servletContext.getRealPath(DESTINATION_DIR_PATH) + fileName;
				}

				File oldFile = new File(realPath);
				String newFileName = realPath.substring(0, realPath.lastIndexOf("/"));
				File newFile = new File(newFileName + "/Del_" + oldFile.getName());
				oldFile.renameTo(newFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		request.setAttribute("fileList", getFileList(ticket.getUserName()));
		System.out.println("path value  --- " + filePath.substring(filePath.indexOf("/", 1) + 1, filePath.indexOf("/", filePath.indexOf("/", 1) + 1)));
		List<String> fileHtmlList = ArticleController.getFileHtmlList(filePath.substring(filePath.indexOf("/", 1) + 1, filePath.indexOf("/", filePath.indexOf("/", 1) + 1)));
		request.setAttribute("htmlFileList", fileHtmlList);

		return "articleEditor";
	}

	@RequestMapping(value = "/showUploadForm.do", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/downloadForm.do", method = RequestMethod.POST)
	public String download(HttpServletRequest request, HttpServletResponse response) {
		String fileURL = request.getParameter("fileUrl");

		response.setContentType("application/zip");

		InputStream inputStream = servletContext.getResourceAsStream("abc.zip");
		int read = 0;
		byte[] bytes = new byte[1024];
		try {
			OutputStream outputStream = response.getOutputStream();
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "articleEditor";
	}

	@RequestMapping(value = "/saveUploadForm.do", method = RequestMethod.POST)
	public String saveUpload(HttpServletRequest request, HttpServletResponse response) {
		String message = null;
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		if (null != ticket) {

			try {

				final String TMP_DIR_PATH = configProp.getProperty("tmp.dir.path");
				File tmpDir;

				File destinationDir = null;

				tmpDir = new File(TMP_DIR_PATH);
				if (!tmpDir.isDirectory()) {
					tmpDir.mkdir();

				}
				String realPath = getRealPath(ticket.getUserName());
				destinationDir = new File(realPath);
				if (!destinationDir.isDirectory()) {
					destinationDir.mkdir();

				}

				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
				fileItemFactory.setRepository(tmpDir);

				ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
				List items = uploadHandler.parseRequest(request);
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();

					File file = new File(destinationDir, FileName.getCreatedOn() + "_" + FileName.getRandomNumber() + "_" + item.getName());
					item.write(file);

				}

				request.setAttribute("fileList", getFileList(ticket.getUserName()));
				message = "<font color='green'>File uploaded successfully.</font>";
			} catch (FileUploadException ex) {
				ex.printStackTrace();
				message = "<font color='red'>Error encountered while parsing the request.</font>";
			} catch (Exception ex) {
				ex.printStackTrace();
				message = "<font color='red'>Issue while uploading file.</font>";
			}

		} else {
			message = "<font color='red'>Please Logon.</font>";
		}

		request.setAttribute("message", message);
		return "articleEditor";
	}

	@RequestMapping(value = "/uploadImage.do", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse uploadImage(Parameters param, BindingResult result, HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
       System.out.println("uploadImage----- ");
		Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
		if (null != ticket) {

			try {

				final String TMP_DIR_PATH = configProp.getProperty("tmp.dir.path");
				File tmpDir;

				File destinationDir = null;

				tmpDir = new File(TMP_DIR_PATH);
				if (!tmpDir.isDirectory()) {
					tmpDir.mkdir();

				}
				String realPath = getRealPath(ticket.getUserName());
				destinationDir = new File(realPath);
				if (!destinationDir.isDirectory()) {
					destinationDir.mkdir();

				}

				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
				fileItemFactory.setRepository(tmpDir);

				ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
				List items = uploadHandler.parseRequest(request);
				Iterator itr = items.iterator();
				FileItem item = (FileItem) itr.next();
				String[] imgDetail = new String[2];
				String fileName = FileName.getCreatedOn() + "_" + FileName.getRandomNumber() + "_" + item.getName();
				File file = new File(destinationDir, fileName);
				item.write(file);

				request.setAttribute("fileList", getFileList(ticket.getUserName()));
				imgDetail[0] = DESTINATION_DIR_PATH + "/" + ticket.getUserName() + "/" + fileName;
				imgDetail[1] = "";
				res.setStatus("SUCESS");
				res.setResult(imgDetail);

			} catch (FileUploadException ex) {
				ex.printStackTrace();
				res.setStatus("FAIL");
			} catch (Exception ex) {
				ex.printStackTrace();
				res.setStatus("FAIL");
				;
			}

		} else {
			res.setStatus("FAIL");
		}

		return res;
	}
}