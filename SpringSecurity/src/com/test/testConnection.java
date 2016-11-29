package com.test;

import java.util.List;

import model.UserReg;

import com.data.UserRegDAO;

public class testConnection {

	public static void main(String[] args) {
		UserRegDAO dao = new UserRegDAO();
		UserReg etest = new UserReg();
		etest.setUserName("user2");
		etest.setUserPassword("pass2");
		dao.creat(etest);
	//	dao.delete(etest);
		List<UserReg> entities = dao.read();
		for (UserReg e : entities) {
			System.out.println("\n user name is " + e.getUserName());
		}

	}

}
