package com;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		try{
			@SuppressWarnings("resource")
			AbstractApplicationContext cnt = new AnnotationConfigApplicationContext(
					DataConfig.class);
			StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) cnt
					.getBean(StudentJDBCTemplate.class);
			DataSource r = cnt.getBean(DataSource.class);
			studentJDBCTemplate.setDataSource(r);
		//	studentJDBCTemplate.create(5, "bk", 32);
	    	studentJDBCTemplate.delete(5);
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		List<Student> students = studentJDBCTemplate.listStudents();


	}

}
