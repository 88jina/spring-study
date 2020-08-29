package com.spring.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
public class ServletController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "/views/home.jsp";
	}

}
