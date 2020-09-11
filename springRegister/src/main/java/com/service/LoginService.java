package com.service;

import com.beans.*;

public interface LoginService {
	public boolean isUser(LoginBean loginBean);
	public String isAuth(LoginBean loginBean);
}
