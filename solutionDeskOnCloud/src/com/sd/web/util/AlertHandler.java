package com.sd.web.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class AlertHandler {

	private static final Logger logger = Logger.getLogger(AlertHandler.class);

	public void sendEmail(String to, String cc, String bcc, String subject, String file, String msgBody) throws Exception {

		Properties configProp = ApplicationContext.getInstance().getConfigProp();
		String from = configProp.getProperty("email.from");
		String pwd = configProp.getProperty("email.password");

		String host = configProp.getProperty("email.host");

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		String user = from.substring(0, from.indexOf('@'));
		Authenticator auth = new SMTPAuthenticator(user, pwd);
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties, auth);

		try { // Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			/*
			 * message.addRecipient(Message.RecipientType.TO, new
			 * InternetAddress(to));
			 */

			// Set Subject: header field
			String[] toAddList = to.split(",");
			InternetAddress[] toAddress = new InternetAddress[toAddList.length];
			for (int i = 0; i < toAddList.length; i++) {
				toAddress[i] = new InternetAddress(toAddList[i]);
			}

			message.addRecipients(Message.RecipientType.TO, toAddress);

			InternetAddress[] ccAddress = null;

			if ((null != cc) && !("".equalsIgnoreCase(cc)) && !("null".equalsIgnoreCase(cc))) {
				String[] ccAddList = cc.split(",");
				ccAddress = new InternetAddress[ccAddList.length];

				for (int i = 0; i < toAddList.length; i++) {
					ccAddress[i] = new InternetAddress(ccAddList[i]);
				}
				message.addRecipients(Message.RecipientType.CC, ccAddress);
			}
			InternetAddress[] bccAddress = null;
			if ((null != bcc) && !("".equalsIgnoreCase(bcc)) && !("null".equalsIgnoreCase(bcc))) {
				String[] bccAddList = bcc.split(",");
				bccAddress = new InternetAddress[bccAddList.length];

				for (int i = 0; i < toAddList.length; i++) {
					bccAddress[i] = new InternetAddress(bccAddList[i]);
				}
				message.addRecipients(Message.RecipientType.BCC, bccAddress);
			}

			message.setSubject(subject);

			// Create the message part
			if ((null != file) && !("".equalsIgnoreCase(file)) && !("null".equalsIgnoreCase(file))) {
				BodyPart messageBodyPart = new MimeBodyPart();

				// Fill the message
				// messageBodyPart.setText("This is message body");
				messageBodyPart.setContent(msgBody, "text/html");
				// Create a multipar message
				Multipart multipart = new MimeMultipart();

				// Set text message part
				multipart.addBodyPart(messageBodyPart);

				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				// String filename = "C:/Notes.txt";
				DataSource source = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(file);
				multipart.addBodyPart(messageBodyPart);

				// Send the complete message parts
				message.setContent(multipart);
			} else {
				message.setContent(msgBody, "text/html");

			}
			// Send message
			Transport.send(message);
			System.out.println("Your message had been sent successfully...");
			logger.info("Your message had been sent successfully...");
		} catch (MessagingException mex) {
		//	mex.printStackTrace();
			logger.info(mex);
			throw mex;
			
		}

	}
}

class SMTPAuthenticator extends javax.mail.Authenticator {
	private static String SMTP_AUTH_USER;
	private static String SMTP_AUTH_PWD;

	SMTPAuthenticator(String user, String pwd) {
		SMTP_AUTH_USER = user;
		SMTP_AUTH_PWD = pwd;
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		String username = SMTP_AUTH_USER;
		String password = SMTP_AUTH_PWD;
		return new PasswordAuthentication(username, password);
	}

}
