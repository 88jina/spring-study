package com.spring.exam.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.spring.exam.beans.*;
import com.spring.exam.dao.*;


@Controller
public class ExampleController {
	
	@Autowired
	ExampleDao exampleDao;
	

//	@GetMapping("/")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public String selectMembers() {
//		List<MemberBean> memberBeans = exampleDao.selectAllMember();
		
		exampleDao.selectAllMember().stream().forEach(a->System.out.println(a));
		return "home";
	}
	
}
