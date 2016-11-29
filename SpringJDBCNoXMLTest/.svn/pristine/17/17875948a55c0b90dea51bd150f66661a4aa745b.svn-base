package com;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataConfig {
	@Bean
	@Autowired
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setPassword("");
		dataSource.setUsername("root");
		return dataSource;
		
	}
	@Bean
	@Autowired
	public StudentJDBCTemplate studentJDBCTemplate(){
		StudentJDBCTemplate st=new StudentJDBCTemplate();
		return st;
	}

}
