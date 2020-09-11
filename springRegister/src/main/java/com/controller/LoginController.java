package com.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.beans.*;
import com.service.*;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute LoginBean loginBean, Model model) {

		System.out.println(service.isUser(loginBean));
		service.isUser(loginBean);
		
	
		String msg = "";
		
		

		if (service.isUser(loginBean) == false) {
			System.out.println("가입이 되지 않은 계정");
			msg = "가입되지 않은 계정입니다";
		} else {
			System.out.println("가입됨");
			msg = service.isAuth(loginBean);
		}
		
		model.addAttribute("msg", msg);

		return "result";
	}

}
