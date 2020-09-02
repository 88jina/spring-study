package com.spring.exam.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.spring.exam.beans.*;
import com.spring.exam.mapper.*;

@Repository
public class ExampleDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	MemberMapper memberMapper;
	
	public List<MemberBean> selectAllMember(){
		String sql ="select * from membership";
		
		List<MemberBean> query =jdbcTemplate.query(sql, memberMapper);
		return query;
	}
	
}
