package com.sd.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sd.web.form.LogonForm;
import com.sd.web.security.Ticket;
import com.sd.web.util.ApplicationContext;
import com.sd.web.util.EmailAttachment;
import com.sd.web.util.FileName;
import com.sd.web.util.MessageDetails;

@Controller
public class EmailController extends BaseController{
	private static final Logger logger = Logger.getLogger(EmailController.class);
	private static ServletContext servletContext = ApplicationContext.getInstance().getServletContext();
	private static Properties configProp = ApplicationContext.getInstance().getConfigProp();
	private static String DESTINATION_DIR_PATH = configProp.getProperty("destination.email.dir.path");

	@RequestMapping(value = "/emailService.do", method = RequestMethod.GET)
	public ModelAndView emailService(Model model,HttpServletRequest request) throws ServletException {
		Ticket ticket	= getTicket(request);
			if (ticket != null) {	
				return new ModelAndView("inboxPage", "ticket", ticket);
			} else {
				logger.info("User is not Logged in");
				model.addAttribute("LogonForm", new LogonForm());
				return new ModelAndView("logonForm", "invalidUser", "Invalid User");
				
			}
			
	}
	
	
		@RequestMapping(value = "/logoutFromEmail.do", method = RequestMethod.GET)
	public ModelAndView logoutFromEmail(Model model,HttpServletRequest request) throws ServletException {
		Ticket ticket	= getTicket(request);
			if (ticket != null) {
				request.getSession().removeAttribute("messageInformation");
				request.getSession().removeAttribute("inbox");
				request.getSession().removeAttribute("userName");
				
				return new ModelAndView("inboxPage", "ticket", ticket);
			} else {
				logger.info("User is not Logged out form Email");
				model.addAttribute("LogonForm", new LogonForm());
				return new ModelAndView("logonForm", "invalidUser", "Invalid User");
				
			}
			
	}
	
	@RequestMapping(value = "/composePage.do", method = RequestMethod.GET)
	public ModelAndView composePage(Model model,HttpServletRequest request) throws ServletException {
		Ticket ticket	= getTicket(request);
			if (ticket != null) {
				request.getSession().setAttribute("ticket", ticket);
				request.setAttribute("messageId", request.getParameter("messageId"));
				return new ModelAndView("composeEmail", "ticket", ticket);
			} else {
				logger.info("User is not Logged in");
				model.addAttribute("LogonForm", new LogonForm());
				return new ModelAndView("logonForm", "invalidUser", "Invalid User");
				
			}
			
	}
	
	
	@RequestMapping(value = "/sendEmail.do", method = RequestMethod.POST)
	public ModelAndView sendEmail(Model model,CmzHttpServetRequest request) throws ServletException {
		String msg ;
		Ticket ticket	= getTicket(request);
			if (ticket != null) {

				 String from = request.getParameter("from");
				 String pwd = request.getParameter("pwd");
				 String to = request.getParameter("to");
				 String cc = request.getParameter("cc");
				 String bcc = request.getParameter("bcc");
				 String subject = request.getParameter("subject");
				 String file = request.getParameter("fileUrl");
				 String msgBody = request.getParameter("msgBody");
				 System.out.println("from : "+from);
				 System.out.println("to : "+to);
				 System.out.println("cc : "+cc);
				 System.out.println("bcc : "+bcc);
				 System.out.println("subject : "+subject);
				 System.out.println("file : "+file);
				 System.out.println("msgBody : "+msgBody);
				 
			     String host = "smtp.gmail.com";
			     Enumeration<String> headerNames = request.getHeaderNames();
			     while(headerNames.hasMoreElements()){
			    	System.out.println(" Header Element : "+headerNames.nextElement()); 
			    	System.out.println(" next heaer naem : "+request.getHeader(headerNames.nextElement()));
			     }
			     
			     file = getRealPath(ticket.getUserName()).getAbsolutePath();
			      // Get system properties
			      Properties properties = System.getProperties();
			     
			      // Setup mail server
			      properties.setProperty("mail.smtp.host", host);
			      properties.put("mail.smtp.starttls.enable","true");
			      properties.put("mail.smtp.auth", "true");
			      String user = from.substring(0,from.indexOf('@'));
			      Authenticator auth = new SMTPAuthenticator(user,pwd);
			      // Get the default Session object.
			      Session session = Session.getDefaultInstance(properties,auth);
			     
			      try{         // Create a default MimeMessage object.
			          MimeMessage message = new MimeMessage(session);

			          // Set From: header field of the header.
			          message.setFrom(new InternetAddress(from));

			          // Set To: header field of the header.
			         /* message.addRecipient(Message.RecipientType.TO,
			                                   new InternetAddress(to));*/

			          // Set Subject: header field
			          
			          String []toAddList = to.split(",");
				         InternetAddress[] toAddress = new InternetAddress[toAddList.length];
				         for (int i = 0; i<toAddList.length; i++)
				         {
				        	 toAddress[i] = new InternetAddress(toAddList[i]);
				         }
				         
				          message.addRecipients(Message.RecipientType.TO, toAddress);
				          
				         InternetAddress[] ccAddress = null;
				         
				         if(null != cc && !("".equalsIgnoreCase(cc)) && !("null".equalsIgnoreCase(cc))){
				        	  String []ccAddList = cc.split(",");
				        	  ccAddress =  new InternetAddress[ccAddList.length];
				        	  
				        	  for (int i = 0; i<toAddList.length; i++)
				        	  {
				        		  ccAddress[i] = new InternetAddress(ccAddList[i]);
				        	  }
				        	  message.addRecipients(Message.RecipientType.CC, ccAddress);
				          }
				          InternetAddress[] bccAddress = null;
				          if(null != bcc && !("".equalsIgnoreCase(bcc)) && !("null".equalsIgnoreCase(bcc))){
				        	  String []bccAddList = bcc.split(",");
				        	  bccAddress =  new InternetAddress[bccAddList.length];
				        	  
				        	  for (int i = 0; i<toAddList.length; i++)
				        	  {
				        		  bccAddress[i] = new InternetAddress(bccAddList[i]);
				        	  }
				        	  message.addRecipients(Message.RecipientType.BCC, bccAddress);
				          }
				          
			          message.setSubject(subject);

			          // Create the message part 
			          if(null != file && !("".equalsIgnoreCase(file)) && !("null".equalsIgnoreCase(file))){
			          BodyPart messageBodyPart = new MimeBodyPart();

			          // Fill the message
			        //  messageBodyPart.setText("This is message body");
			          messageBodyPart.setContent(msgBody,"text/html" );
			          // Create a multipar message
			          Multipart multipart = new MimeMultipart();

			          // Set text message part
			          multipart.addBodyPart(messageBodyPart);

			          // Part two is attachment
			          messageBodyPart = new MimeBodyPart();
			          //String filename = "C:/Notes.txt";
			          DataSource source = new FileDataSource(file);
			          messageBodyPart.setDataHandler(new DataHandler(source));
			          messageBodyPart.setFileName(file);
			          multipart.addBodyPart(messageBodyPart);
			          
			          // Send the complete message parts
			          message.setContent(multipart );
			          }else{
			        	  message.setContent(msgBody,
		                  "text/html" );

			          }
			          // Send message
			          Transport.send(message);
			          System.out.println("Your message had been sent successfully...");
			          msg = "Your message had been sent successfully...";
			          logger.info("Your message had been sent successfully...");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			         msg = "Oops...,Delivery to the recipient failed...";
			         logger.info(mex);
			      }
			 	request.setAttribute("msg", msg);
		    	
				return new ModelAndView("inboxPage", "ticket", ticket);	
				
			} else {
				logger.info("User is not Logged in");
				model.addAttribute("LogonForm", new LogonForm());
				return new ModelAndView("logonForm", "invalidUser", "Invalid User");
				
			}
	}

	@RequestMapping(value = "emailInbox.do", method = RequestMethod.GET)
	public ModelAndView  inboxListPage(Model model,HttpServletRequest request) throws ServletException {
		
		
		Ticket ticket = getTicket(request);
           if(ticket != null)
			try {
				
				Folder inbox = (Folder)request.getSession().getAttribute("inbox");
				// inbox.open(Folder.READ_WRITE);
				int startMsg = 1;
				int endMsg = 5;
				int totalMsg = inbox.getMessageCount();
				startMsg = totalMsg > endMsg ? (totalMsg - endMsg) : startMsg;
				endMsg = totalMsg;
				String numberOfRecord = request.getParameter("numberOfRecord");
				String pageNo = request.getParameter("pageNo");
				System.out.println(null != numberOfRecord && pageNo != null && pageNo.trim().length() > 0);
				if(null != numberOfRecord && pageNo != null && pageNo.trim().length() > 0){
					int numberOfRecordInt = Integer.parseInt(numberOfRecord);
					int pageNoInt = Integer.parseInt(pageNo);
				int tempNo =	numberOfRecordInt * pageNoInt;
				if(totalMsg > tempNo){
					startMsg =  (totalMsg - tempNo);
					endMsg = startMsg + numberOfRecordInt;
					request.setAttribute("pageNo", pageNoInt);
				}
			}
				request.setAttribute("totalMsg", totalMsg);
				
				LinkedHashMap<Integer, MessageDetails> messageInformation = new LinkedHashMap<Integer, MessageDetails>();
				Message messages[] = inbox.getMessages(startMsg,endMsg);
				MessageDetails messageDetails = null;
				for(int i= (messages.length-1) ; i>=0; i-- ){
					try{
					messageDetails = new MessageDetails(); 
					String from = messages[i].getFrom()[0].toString();
					// from = from.replace("<", "&lt;").replace(">", "&gt;");
					messageDetails.setFrom(from);
					messageDetails.setSubject(messages[i].getSubject());
					
					Object content = messages[i].getContent();
					
					String bodyMessage = "";
					if(content instanceof  Multipart){
					
					  Multipart multipart = (Multipart) messages[i].getContent();
					  ArrayList<EmailAttachment> emailAttachments = new ArrayList<EmailAttachment>();
					  for (int x = 0; x < multipart.getCount(); x++) {
					  Part part = multipart.getBodyPart(x);

					  String disposition = part.getDisposition();
					  if (Part.ATTACHMENT.equalsIgnoreCase(disposition	) || Part.INLINE.equalsIgnoreCase(disposition)){
						  
					  MimeBodyPart mbp = (MimeBodyPart) part;
					  /*
				       if (mbp.isMimeType("text/plain")) {
				    	   bodyMessage += (String) mbp.getContent();
				       } else {
				    	*/   try{   
				        EmailAttachment attachment = new EmailAttachment();
				        attachment.setName(decodeName(part.getFileName()));
				        Object userName = request.getSession().getAttribute("userName");
				        String filePath = DESTINATION_DIR_PATH+"/"+userName+"/received/"+i;
						  File savedir = new File(servletContext.getRealPath(filePath));
						  if(!savedir.exists()){
							  savedir.mkdirs();
						  }
				        
				        // File savefile = File.createTempFile( "emailattach", ".atch", savedir);
				        File savefile = new File(savedir,attachment.getName());
				        if(savefile.exists()){
				        	savefile.delete();
				        }
				        attachment.setPath(filePath+"/"+attachment.getName());
				        attachment.setSize(saveFile(savefile, part));
				        emailAttachments.add(attachment);
				       }catch(Exception e){
				    	   e.printStackTrace();
				       }
					  // } 
					  }else {
						  MimeBodyPart mbp = (MimeBodyPart) part;
						     bodyMessage = "<B>Message Body Part "+x+ "<\\B>"+  mbp.getContent();
					  
					  }
					  
					}
					  
					  messageDetails.setAttachments(emailAttachments); 
					  
					}else{
						bodyMessage = messages[i].getContent().toString();
					}

					
					messageDetails.setBody(bodyMessage);
					
					messageDetails.setReceived(messages[i].getSentDate());
					Address[] toRecipients = messages[i].getRecipients(Message.RecipientType.TO);
					Address[] ccRecipients = messages[i].getRecipients(Message.RecipientType.CC);
					Address[] bccRecipients = messages[i].getRecipients(Message.RecipientType.BCC);
					
					StringBuilder recipients = new StringBuilder();
					if(null != toRecipients && toRecipients.length > 0){
						for(Address toRecipient : toRecipients){
							
						recipients.append(toRecipient.toString());
						recipients.append(",");
						}
					}
					messageDetails.setToRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					
					if(null != ccRecipients && ccRecipients.length > 0){
						recipients  = new StringBuilder();
						for(Address ccRecipient : ccRecipients){
						recipients.append(ccRecipient.toString());
						recipients.append(",");
						}
						messageDetails.setCcRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					}
					
					if(null != bccRecipients && bccRecipients.length > 0){
						recipients  = new StringBuilder();
						for(Address bccRecipient : bccRecipients){
						recipients.append(bccRecipient.toString());
						recipients.append(",");
						}
						messageDetails.setBccRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					}
					
					messageInformation.put(i, messageDetails);
					}catch(Exception e){
				    	   e.printStackTrace();
				       }
				}
				request.getSession().setAttribute("messageInformation", messageInformation);
			
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
			request.setAttribute("invalidUser", "Invalid User");
			return new ModelAndView("inboxPage", "ticket", ticket);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("invalidUser", "Issue While getting connecting to server");
			return new ModelAndView("inboxPage", "ticket", ticket);
		}
		 return new ModelAndView("inboxPage", "ticket", ticket);
	}
	
	
	@RequestMapping(value = "emailAttachment.do", method = RequestMethod.POST)
	public ModelAndView  emailAttachment(Model model,HttpServletRequest request) throws ServletException {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start method : "+currentTimeMillis);
		String fileName = request.getParameter("fileUrl");
		System.out.println("fileName --- "+fileName);
	//	if(fileName != null){
			uploadAttachment(request);
		// }
		return new ModelAndView("attachment", "ticket", "");
	}
	
	private String uploadAttachment(HttpServletRequest request) {
		String res = "";
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
				destinationDir = getRealPath(ticket.getUserName());;
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setSizeThreshold(1 * 1024 * 1024); // 1 MB
				fileItemFactory.setRepository(tmpDir);
				ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
				List items = uploadHandler.parseRequest(request);
				Iterator itr = items.iterator();
				FileItem item = (FileItem) itr.next();
				File file = new File(destinationDir, item.getName());
				item.write(file);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	@RequestMapping(value = "emailInbox.do", method = RequestMethod.POST)
	public ModelAndView  inbox(Model model,HttpServletRequest request) throws ServletException {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start method : "+currentTimeMillis);
		Ticket ticket = getTicket(request);
				
		request.getSession().setAttribute("ticket",ticket );
		String userName = request.getParameter("userName");
		request.getSession().setAttribute("userName", userName);
		String userPwd = request.getParameter("password");

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
			try {
				Session session = Session.getDefaultInstance(props, null);
				Store store = session.getStore("imaps");
				store.connect("imap.gmail.com", userName, userPwd);
				System.out.println(store);
				Folder inbox = store.getFolder("Inbox");
				request.getSession().setAttribute("inbox", inbox);
				currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
				System.out.println("before open inbox method : "+ currentTimeMillis);
				inbox.open(Folder.READ_WRITE);
				currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
				System.out.println("after open inbox method : "+ currentTimeMillis);
				int startMsg = 1;
				int endMsg = 5;
				int totalMsg = inbox.getMessageCount();
				startMsg = totalMsg > endMsg ? (totalMsg - endMsg) : startMsg;
				endMsg = totalMsg;
				String numberOfRecord = request.getParameter("numberOfRecord");
				String pageNo = request.getParameter("pageNo");
				
				if(null != numberOfRecord && pageNo != null && pageNo.trim().length() > 0){
					int numberOfRecordInt = Integer.parseInt(numberOfRecord);
					int pageNoInt = Integer.parseInt(pageNo);
				int tempNo =	numberOfRecordInt * pageNoInt;
				if(totalMsg > tempNo){
					startMsg =  (totalMsg - (tempNo - numberOfRecordInt) ) ;
					endMsg = startMsg + numberOfRecordInt;
					request.setAttribute("pageNo", pageNoInt);
				}
			}
				request.setAttribute("totalMsg", totalMsg);
				
				LinkedHashMap<Integer, MessageDetails> messageInformation = new LinkedHashMap<Integer, MessageDetails>();
				Message messages[] = inbox.getMessages(startMsg,endMsg);
				MessageDetails messageDetails = null;
				
				for(int i= (messages.length-1) ; i>=0; i-- ){
					try{
						currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
						System.out.println("Start loop inbox method : "+  currentTimeMillis);	
					messageDetails = new MessageDetails(); 
					String from = messages[i].getFrom()[0].toString();
					from = from.replace("<", "&lt;").replace(">", "&gt;");
					messageDetails.setFrom(from);
					messageDetails.setSubject(messages[i].getSubject());
					
					Object content = messages[i].getContent();
					
					String bodyMessage = "";
					if(content instanceof  Multipart){
					
					  Multipart multipart = (Multipart) messages[i].getContent();
					  ArrayList<EmailAttachment> emailAttachments = new ArrayList<EmailAttachment>();
					  for (int x = 0; x < multipart.getCount(); x++) {
					  Part part = multipart.getBodyPart(x);

					  String disposition = part.getDisposition();
					  if (Part.ATTACHMENT.equalsIgnoreCase(disposition	) || Part.INLINE.equalsIgnoreCase(disposition)){
					  
					  MimeBodyPart mbp = (MimeBodyPart) part;
					  /*
				       if (mbp.isMimeType("text/plain")) {
				    	   bodyMessage += (String) mbp.getContent();
				       } else {
				    	*/   try{   
				        EmailAttachment attachment = new EmailAttachment();
				        attachment.setName(decodeName(part.getFileName()));
				        
				        String filePath = DESTINATION_DIR_PATH+"/"+userName+"/received/"+i;
						  File savedir = new File(servletContext.getRealPath(filePath));
						  if(!savedir.exists()){
							  savedir.mkdirs();
						  }
				        
				        // File savefile = File.createTempFile( "emailattach", ".atch", savedir);
				        File savefile = new File(savedir,attachment.getName());
				        if(savefile.exists()){
				        	savefile.delete();
				        }
				        attachment.setPath(filePath+"/"+attachment.getName());
				        attachment.setSize(saveFile(savefile, part));
				        emailAttachments.add(attachment);
				       }catch(Exception e){
				    	   e.printStackTrace();
				       }
					  // } 
					  }else {
						  MimeBodyPart mbp = (MimeBodyPart) part;
						  
						  System.out.println("gt"+ mbp.getContent());
						  System.out.println("getObject:  "+mbp.getContent());
						  System.out.println("sgt"+ mbp.getContent());
						  System.out.println("content type : "+ mbp.getContentType());
						  System.out.println("getContentMD5 type : "+ mbp.getContentMD5());
						  Object content2 = mbp.getContent();
						  if(content2 instanceof MimeMultipart){
							  MimeMultipart mimeMultipart = (MimeMultipart)content2;
						     bodyMessage = "<B>Message Body Part "+x+ "<\\B>"+  mimeMultipart.getCount();
						  }
					  }
					  
					}
					  
					  messageDetails.setAttachments(emailAttachments); 
					  
					}else{
						bodyMessage = messages[i].getContent().toString();
					}

					
					messageDetails.setBody(bodyMessage);
					
					messageDetails.setReceived(messages[i].getSentDate());
					Address[] toRecipients = messages[i].getRecipients(Message.RecipientType.TO);
					Address[] ccRecipients = messages[i].getRecipients(Message.RecipientType.CC);
					Address[] bccRecipients = messages[i].getRecipients(Message.RecipientType.BCC);
					
					StringBuilder recipients = new StringBuilder();
					if(null != toRecipients && toRecipients.length > 0){
						for(Address toRecipient : toRecipients){
							
						recipients.append(toRecipient.toString());
						recipients.append(",");
						}
					}
					messageDetails.setToRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					
					if(null != ccRecipients && ccRecipients.length > 0){
						recipients  = new StringBuilder();
						for(Address ccRecipient : ccRecipients){
						recipients.append(ccRecipient.toString());
						recipients.append(",");
						}
						messageDetails.setCcRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					}
					
					if(null != bccRecipients && bccRecipients.length > 0){
						recipients  = new StringBuilder();
						for(Address bccRecipient : bccRecipients){
						recipients.append(bccRecipient.toString());
						recipients.append(",");
						}
						messageDetails.setBccRecp(recipients.toString().replace("<", "&lt;").replace(">", "&gt;"));
					}
					
					messageInformation.put(i, messageDetails);
					currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
					System.out.println("End loop inbox method : "+ currentTimeMillis);
					}catch(Exception e){
				    	   e.printStackTrace();
				       }
				}
				request.getSession().setAttribute("messageInformation", messageInformation);
			
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
			request.setAttribute("invalidUser", "Invalid User");
			return new ModelAndView("inboxPage", "ticket", ticket);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("invalidUser", "Issue While getting connecting to server");
			return new ModelAndView("inboxPage", "ticket", ticket);
		}
		 return new ModelAndView("inboxPage", "ticket", ticket);
	}

	
	
	
	
			 private static String decodeName(String name) throws Exception {
				  if (name == null || name.length() == 0) {
				   return "unknown";
				  }
				  String ret = java.net.URLDecoder.decode(name, "UTF-8");

				  // also check for a few other things in the string:
				  ret = ret.replaceAll("=\\?utf-8\\?q\\?", "");
				  ret = ret.replaceAll("\\?=", "");
				  ret = ret.replaceAll("=20", " ");

				  return ret;
				 }

				 private static int saveFile(File saveFile, Part part) throws Exception {

				  BufferedOutputStream bos = new BufferedOutputStream(
				    new FileOutputStream(saveFile));

				  byte[] buff = new byte[2048];
				  InputStream is = part.getInputStream();
				  int ret = 0, count = 0;
				  while ((ret = is.read(buff)) > 0) {
				   bos.write(buff, 0, ret);
				   count += ret;
				  }
				  bos.close();
				  is.close();
				  return count;
				 }

			
			
	 
	 
		private static File getRealPath(String userName) {
			String filePath = DESTINATION_DIR_PATH+"/Attachment/" + userName;
			File tmpDir = new File(servletContext.getRealPath(filePath));
			if (!tmpDir.isDirectory()) {
				tmpDir.mkdirs();

			}
			return tmpDir;
		}
	 

}

class SMTPAuthenticator extends javax.mail.Authenticator {
	 private static String SMTP_AUTH_USER ; 
	    private static String SMTP_AUTH_PWD ;

	SMTPAuthenticator(String user, String pwd)
	{
		SMTP_AUTH_USER = user;
		SMTP_AUTH_PWD  = pwd;
	}
 public PasswordAuthentication getPasswordAuthentication() {
    String username = SMTP_AUTH_USER;
    String password = SMTP_AUTH_PWD;
    return new PasswordAuthentication(username, password);
 }

 
}


/*


 class IncomingMail {

 public static List<Email> downloadPop3(String host, String user, String pass, String downloadDir) throws Exception {

  List<Email> emails = new ArrayList<Email>();

  // Create empty properties
  Properties props = new Properties();

  // Get the session
  Session session = Session.getInstance(props, null);

  // Get the store
  Store store = session.getStore("pop3");
  store.connect(host, user, pass);

  // Get folder
  Folder folder = store.getFolder("INBOX");
  folder.open(Folder.READ_WRITE);

  try {
   // Get directory listing
   Message messages[] = folder.getMessages();
   for (int i = 0; i < messages.length; i++) {

    Email email = new Email();

    // from 
    email.from = messages[i].getFrom()[0].toString();

    // to list
    Address[] toArray = messages[i] .getRecipients(Message.RecipientType.TO);
    for (Address to : toArray) { email.to.add(to.toString()); }

    // cc list
    Address[] ccArray = null;
    try {
     ccArray = messages[i] .getRecipients(Message.RecipientType.CC);
    } catch (Exception e) { ccArray = null; }
    if (ccArray != null) {
     for (Address c : ccArray) {
      email.cc.add(c.toString());
     }
    }

    // subject
    email.subject = messages[i].getSubject();

    // received date
    if (messages[i].getReceivedDate() != null) {
     email.received = messages[i].getReceivedDate();
    } else {
     email.received = new Date();
    }

    // body and attachments
    email.body = "";
    Object content = messages[i].getContent();
    if (content instanceof java.lang.String) {

     email.body = (String) content;

    } else if (content instanceof Multipart) {

     Multipart mp = (Multipart) content;

     for (int j = 0; j < mp.getCount(); j++) {

      Part part = mp.getBodyPart(j);
      String disposition = part.getDisposition();

      if (disposition == null) {

       MimeBodyPart mbp = (MimeBodyPart) part;
       if (mbp.isMimeType("text/plain")) {
        // Plain
        email.body += (String) mbp.getContent();
       } 

      } else if ((disposition != null) && (disposition.equals(Part.ATTACHMENT) || disposition .equals(Part.INLINE))) {

       // Check if plain
       MimeBodyPart mbp = (MimeBodyPart) part;
       if (mbp.isMimeType("text/plain")) {
        email.body += (String) mbp.getContent();
       } else {
        EmailAttachment attachment = new EmailAttachment();
        attachment.name = decodeName(part.getFileName());
        File savedir = new File(downloadDir);
        savedir.mkdirs();
        // File savefile = File.createTempFile( "emailattach", ".atch", savedir);
        File savefile = new File(downloadDir,attachment.name);
        attachment.path = savefile.getAbsolutePath();
        attachment.size = saveFile(savefile, part);
        email.attachments.add(attachment);
       }
      }
     } // end of multipart for loop 
    } // end messages for loop

    emails.add(email);

    // Finally delete the message from the server.
    messages[i].setFlag(Flags.Flag.DELETED, true);
   }

   // Close connection
   folder.close(true); // true tells the mail server to expunge deleted messages
   store.close();

  } catch (Exception e) {
   folder.close(true); // true tells the mail server to expunge deleted
   store.close();
   throw e;
  }

  return emails;
 }

 private static String decodeName(String name) throws Exception {
  if (name == null || name.length() == 0) {
   return "unknown";
  }
  String ret = java.net.URLDecoder.decode(name, "UTF-8");

  // also check for a few other things in the string:
  ret = ret.replaceAll("=\\?utf-8\\?q\\?", "");
  ret = ret.replaceAll("\\?=", "");
  ret = ret.replaceAll("=20", " ");

  return ret;
 }

 private static int saveFile(File saveFile, Part part) throws Exception {

  BufferedOutputStream bos = new BufferedOutputStream(
    new FileOutputStream(saveFile));

  byte[] buff = new byte[2048];
  InputStream is = part.getInputStream();
  int ret = 0, count = 0;
  while ((ret = is.read(buff)) > 0) {
   bos.write(buff, 0, ret);
   count += ret;
  }
  bos.close();
  is.close();
  return count;
 }

}

class Email {

	 public Date received;
	 public String from;
	 public List<String> to = new ArrayList<String>();
	 public List<String> cc = new ArrayList<String>();
	 public String subject;
	 public String body;
	 public List<EmailAttachment> attachments = new ArrayList<EmailAttachment>();
	}

class EmailAttachment {

public String name;
public String path;
public int size;
}

 class Test {

	 public static void main(String[] args) {

	  String host = "some host";
	  String user = "some user";
	  String pass = "some pass";
	  String downloadDir = "/Temp";
	  try {
	   List<Email> emails = IncomingMail.downloadPop3(host, user, pass, downloadDir);
	   for ( Email email : emails ) {
	    System.out.println(email.from);
	    System.out.println(email.subject);
	    System.out.println(email.body);
	    List<EmailAttachment> attachments = email.attachments;
	    for ( EmailAttachment attachment : attachments ) {
	     System.out.println(attachment.path+" "+attachment.name);
	    }
	   }
	  } catch (Exception e) { e.printStackTrace(); }

	 }

	}
 */
 // More info can be found at http://java.sun.com/developer/onlineTraining/JavaMail/contents.html