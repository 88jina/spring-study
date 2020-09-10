package com.service;


import java.io.*;

import javax.mail.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void sendMail(String userEmail, int authKey) {
		try {
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("회원가입 인증 메일");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
			.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
            .append("<a href='http://localhost:8090/register/confirm?")
            .append("&authKey=")
            .append(authKey)
            .append("' target='_blank'>이메일 인증 확인 링크</a>")
            .append("<p>해당 사이트에 가입한 적이 없다면 이 메일을 무시하세요.</p>")
            .toString());
			sendMail.setTo(userEmail);
            sendMail.setFrom("projecttrust2020@gamil.com", "admin");
			sendMail.send();
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
