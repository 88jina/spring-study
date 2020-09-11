package com.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.beans.*;


public interface LoginMapper {
	@Select("SELECT authStatus FROM user WHERE userEmail=#{userEmail} AND userPassword=#{userPassword}")
	public List<Integer> checkUser(LoginBean loginbean);
}
