package com;

public class PropertiesImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = PropertiesUtil.getConfig("FirstName");
		System.out.println("\n First name is " + name);
	}

}
