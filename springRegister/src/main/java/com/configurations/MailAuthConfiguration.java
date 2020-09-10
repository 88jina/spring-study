package com.configurations;

import java.util.*;

import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.*;

@Configuration
public class MailAuthConfiguration {
	@Bean
	public JavaMailSender mailSender() {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.starttls.required", true);
		properties.put("mail.debug", true);
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding("utf-8");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("projecttrust2020@gmail.com");
		mailSender.setPassword("trust2020");
		mailSender.setJavaMailProperties(properties);
		
		return mailSender;
		
	}
}
