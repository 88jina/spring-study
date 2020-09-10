package com.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.beans.*;
import com.service.*;

@Controller
public class HomeController {

	@Autowired
	TestService testServiceImpl;
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;

	@GetMapping("/")
	public String home() {
		System.out.println("home");
		return "register";
	}

	@PostMapping("/register")
	public String register(@Valid UserBean userBean, BindingResult result, Model model) {
		

		if (result.hasErrors()) {
			String message = result.getAllErrors().get(0).getDefaultMessage();
			model.addAttribute("message", message);
			return "Fail";
		}

		int authKey = testServiceImpl.authKeyMaker();
		userBean.setAuthKey(authKey);
		System.out.println("authKey : " + authKey);
		String userEmail = userBean.getUserEmail();
		System.out.println("Email : " + userEmail);
		System.out.println("Password : " + userBean.getUserPassword());
		
		
		userService.addUserInfo(userBean); // db에 저장
		System.out.println("Saved User Information Successfully");

		mailService.sendMail(userEmail, authKey); // 이메일 발송
		System.out.println("Sended Mail Successfully");

		return "success";
	}

}
