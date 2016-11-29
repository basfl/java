package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_reg database table.
 * 
 */
@Entity
@Table(name="user_reg")
@NamedQuery(name="UserReg.findAll", query="SELECT u FROM UserReg u")
public class UserReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	public UserReg() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}