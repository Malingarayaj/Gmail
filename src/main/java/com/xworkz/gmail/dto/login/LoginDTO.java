package com.xworkz.gmail.dto.login;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "userlogin")
@NamedQuery(name="read",query="from LoginDTO ld where ld.userName=:uname and ld.Password=:password ")
public class LoginDTO implements Serializable {

	public LoginDTO() {
		System.out.println("created:" + this.getClass().getSimpleName());
	}
	@Id
	private String userName;
	private String Password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
