package com.spring.exam.mapper;

import java.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.spring.exam.beans.*;

@Component
public class MemberMapper implements RowMapper<MemberBean>{
	@Override
	public MemberBean mapRow(ResultSet rs, int i) throws SQLException {
		MemberBean memberBean = new MemberBean();
		memberBean.setMem_car(rs.getString("mem_car"));
		memberBean.setName(rs.getString("name"));
		memberBean.setPhone(rs.getString("phone"));
		return memberBean;
	}
}
