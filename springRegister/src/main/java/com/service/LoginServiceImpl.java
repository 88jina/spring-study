package com.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.beans.*;
import com.mapper.*;

@Service
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	LoginMapper loginMapper;
	@Override
	public boolean isUser(LoginBean loginBean) {
		boolean check= false;

		System.out.println(loginBean.getUserEmail());
		System.out.println(loginBean.getUserPassword());
		
		List<Integer> list = loginMapper.checkUser(loginBean);
		if(list.size()!=0) {
			check= true;
		}
		return check;
	}//가입된 사람인지 확인

	@Override
	public String isAuth(LoginBean loginBean) {
		String msg =" ";
		List<Integer> list = loginMapper.checkUser(loginBean);
		if(list.get(0)==0) {
			msg ="인증된 계정이 아닙니다";
		}
		else {
			msg="님 환영합니다";
		}
		System.out.println(msg);
		return msg;
	}
	
}
