package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainImpl {

	public static void main(String[] args) {
		System.out.println("\n ****************************");
		@SuppressWarnings("resource")
		AbstractApplicationContext cnt = new AnnotationConfigApplicationContext(
				PointsConfig.class);
		Foo foo = cnt.getBean(Foo.class);
		foo.setMsg("hello again");
		System.out.println("\n *** " + foo.getMsg());
		Points points = cnt.getBean(Points.class);
		List<Point> result = setList();
		points.setPoints(result);
		for (Point p : points.getPoints()) {
			System.out.println("******** cordinations are :");
			System.out.println(p.getX());
			System.out.println(p.getY());
		}
	}

	private static List<Point> setList() {
		List<Point> plist = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Point p = new Point();
			p.setX(i);
			p.setY(i);
			plist.add(p);
		}
		return plist;
	}

}
