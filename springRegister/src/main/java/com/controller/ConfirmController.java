package com.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.beans.*;
import com.service.*;

@Controller
public class ConfirmController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register/confirm", method = RequestMethod.GET)
	public ModelAndView authorize(UserBean userBean, ModelAndView mv) {
		userService.authorize(userBean);
		System.out.println("db updated");
		mv.setViewName("authorize");
		return mv;

	}

}
