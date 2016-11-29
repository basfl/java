package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext cnt = new AnnotationConfigApplicationContext(
				HelloWorldConfig.class);
		cnt.start();
		HelloWorld helloWorld = cnt.getBean(HelloWorld.class);
		helloWorld.setMsg(" HELLO MY FIREND");
		System.out.println("*** " + helloWorld.getMsg());
		cnt.stop();
	}
}
