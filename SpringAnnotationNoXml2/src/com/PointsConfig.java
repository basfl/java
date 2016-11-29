package com;

import org.springframework.context.annotation.Bean;

public class PointsConfig {
	@Bean
	public Points points(){
		return new Points();
	}
	@Bean
	public Foo foo(){
		return new Foo();
	}

}
