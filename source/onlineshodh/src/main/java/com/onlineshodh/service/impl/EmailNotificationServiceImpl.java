package com.onlineshodh.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.onlineshodh.entity.BusinessEnquiryEntity;
import com.onlineshodh.service.EmailNotificationService;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	@Override
	public void sendEnquiryNotification(
			final BusinessEnquiryEntity enquiry) {
		
		MimeMessagePreparator preparator = new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(enquiry.getEmail());
				message.setFrom("onlineshodh@gmail.com");
				message.setSubject("New Enquiry for: "+enquiry.getBusiness().getBusinessName());
				message.setSentDate(new Date());
				Map<String,Object> model = new HashMap<String, Object>();
				model.put("enquiry", enquiry);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/onlineshodh_new_enquiry.vm", "UTF-8",model);
				message.setText(text, true);
			}
		};
		mailSender.send(preparator);
	}

}
