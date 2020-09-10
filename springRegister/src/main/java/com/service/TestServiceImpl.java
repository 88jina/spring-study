package com.service;


import org.springframework.stereotype.*;


@Service
public class TestServiceImpl implements TestService {

	@Override
	public int authKeyMaker() {
		int authKey = (int)(Math.random()*100000+1);
		
		return authKey;
	}


}
