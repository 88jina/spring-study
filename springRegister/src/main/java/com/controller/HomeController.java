package com.controller;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;

import com.beans.*;
import com.service.*;

@Controller
public class HomeController {

	@Autowired
	TestService testService;
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;

	@GetMapping("/")
	public String home() {
		System.out.println("home");
		return "login";
	}

	@PostMapping("/register")
	public String register(@Valid UserBean userBean, BindingResult result, Model model, WebRequest request) {

		if (result.hasErrors()) {
			String message = result.getAllErrors().get(0).getDefaultMessage();
			model.addAttribute("message", message);
			return "Fail";
		}

		String authKey = testService.authKeyMaker();
		String userEmail =request.getParameter("userEmail");
		String userPassword =request.getParameter("userPassword"); //뷰에서 데이터 받아서 인스턴스화
		
		userBean.setAuthKey(authKey);
		userBean.setUserEmail(userEmail);
		userBean.setUserPassword(userPassword); //뷰에서 받아온 데이터를 유저빈에 넣어줌
		
		Map<String,String> map = new HashMap<>();
		map.put("userEmail", userEmail);
		map.put("authKey",authKey);
		System.out.println(map); //인증을 위해 맵에 저장
		
		userService.addUserInfo(userBean); // db에 저장
		System.out.println("Saved User Information Successfully");

		mailService.sendMail(userEmail, authKey); // 이메일 발송
		System.out.println("Sended Mail Successfully");

		return "success";
	}

}
