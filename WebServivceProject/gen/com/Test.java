package com;

import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		List<UserEntity> e = dao.read();
		for (UserEntity u : e) {
			System.out.println(u.getAddress());
		}

	}

}
