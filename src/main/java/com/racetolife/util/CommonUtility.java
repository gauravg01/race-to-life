package com.racetolife.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class CommonUtility {

	@Value("${mailHeader}")
	private String mailHeader;

	@Value("${mailFooter}")
	private String mailFooter;

	@Autowired
	private JavaMailSender javaMailSender;

//	public void sendEmail(String rname,String email,String subject,String message) {
//		SimpleMailMessage msg = new SimpleMailMessage();
//		mailHeader="Hi "+rname+",\n\n";
//		String finalMessage = mailHeader+message+mailFooter;
//		msg.setTo(email);
//		msg.setSubject(subject);
//		msg.setText(finalMessage);
//		javaMailSender.send(msg);
//	}

	public void sendEmail(String rname,String email,String subject,String message) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, "utf-8");
		mailHeader="Hi "+rname+",<br><br>";
		String finalMessage = mailHeader+message+mailFooter;
		try {
			msg.setText(finalMessage, true);
			msg.setTo(email);
			msg.setSubject(subject);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}