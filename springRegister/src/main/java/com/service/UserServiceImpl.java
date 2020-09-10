package com.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.beans.*;
import com.mapper.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserMapper userMapper;
	@Override
	public void addUserInfo(UserBean userBean) {
		userMapper.addUserInfo(userBean);
	}
	@Override
	public String isAddedMail(UserBean userBean) {
		String result="success";
		
		if(userMapper.isAddedMail(userBean)!=null) {
			result="Already";
		}
		else {
			result="success";
		}
		
		return result;
	}
	

}
