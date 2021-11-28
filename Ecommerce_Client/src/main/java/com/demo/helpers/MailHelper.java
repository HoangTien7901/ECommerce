package com.demo.helpers;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailHelper {
	
	public void sendmail(String sender, String password, String subject, String content, String recipient, boolean isHTML) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "465");
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.starttls.required", "true");
		   props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(sender, password);
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(sender, false));

		   String contentType = isHTML ? "text/html" : "text/plain";
		   
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		   msg.setSubject(subject);
		   msg.setContent(content, contentType);
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(content, contentType);

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		  
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
}
