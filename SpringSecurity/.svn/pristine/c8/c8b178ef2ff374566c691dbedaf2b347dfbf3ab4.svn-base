package com.security;

import java.util.ArrayList;
import java.util.List;

import model.UserReg;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.data.UserRegDAO;

public class SampleAuthenticationManager implements AuthenticationManager {
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	public UserRegDAO dao = new UserRegDAO();
	static {
		AUTHORITIES.add(new GrantedAuthorityImpl("ROLE_USER"));
	}

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		List<UserReg> entities = dao.read();
		for (UserReg e : entities) {
			System.out.println("\n username from database is "
					+ e.getUserName() + "and from user is " + auth.getName());
			if (auth.getName().equals(e.getUserName())) {
				System.out.println("\n ok");
				return new UsernamePasswordAuthenticationToken(auth.getName(),
						auth.getCredentials(), AUTHORITIES);
			}
		}
		return null;
	}

}
