package com.lsw.shop.dto;

public class Member {
	private String email, pwd;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", pwd=" + pwd + "]";
	}
}
