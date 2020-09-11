package com.configurations;

import org.apache.commons.dbcp2.*;
import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.mybatis.spring.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;

import com.mapper.*;

@Configuration
@PropertySource("/WEB-INF/properties/db.properties")
public class RootConfiguration {

	@Value("${db.classname}")
	private String db_classname;
	@Value("${db.url}")
	private String db_url;
	@Value("${db.username}")
	private String db_username;
	@Value("${db.password}")
	private String db_password;

	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		System.out.println(db_username);
		basicDataSource.setPassword(db_password);
		basicDataSource.setUsername(db_username);
		basicDataSource.setUrl(db_url);
		basicDataSource.setDriverClassName(db_classname);
		return basicDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(BasicDataSource basicDataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(basicDataSource);
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		return sqlSessionFactory;
	}

	@Bean
	public MapperFactoryBean<UserMapper> userMapper(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<LoginMapper> loginMapper(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<LoginMapper> factoryBean = new MapperFactoryBean<LoginMapper>(LoginMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}
}
