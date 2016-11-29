package com.data;

import model.UserReg;

public class UserRegDAO extends AbstractDataAccessObject<UserReg> {

	@Override
	protected Class<UserReg> getEntityType() {
		// TODO Auto-generated method stub
		return UserReg.class;
	}

}
