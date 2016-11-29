package com;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.UserDao;
import com.UserEntity;

@WebService
public class Backend {
	@WebMethod
	public List<UserEntity> userInfo(int id) {
		UserDao userdao = new UserDao();
		List<UserEntity> ue = userdao.read();
		return ue;
	}

}
