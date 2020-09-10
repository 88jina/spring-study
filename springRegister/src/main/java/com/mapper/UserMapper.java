package com.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.beans.*;

public interface UserMapper {
	@Insert("INSERT INTO user (userEmail, userPassword, authKey) VALUES (#{userEmail},#{userPassword},#{authKey})")
	public void addUserInfo(UserBean userBean);
	
	@Select("SELECT * FROM user WHERE userEmail=#{userEmail}")
	List<UserBean> isAddedMail(UserBean userBean);
	
}
