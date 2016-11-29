package com;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MockIn {
	 List<UserEntity> userInfo(@WebParam(name="id")int id);

}
