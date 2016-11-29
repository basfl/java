package com;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainImpl {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"Bean.xml");
		context.start();
		HelloWorld obj = context.getBean(HelloWorld.class);
		System.out.println("\n ******msg is " + obj.getMsg());
		context.stop();

	}

}
