package com.chinesedreamer.easycoding.domain.model;

import java.util.Date;

import com.chinesedreamer.easycoding.domain.constant.UserRegisterStatus;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 13, 2017
**/
public class UserRegister extends BaseModel{
	private String username;//申请用户名
	private String salt;
	private String password;
	private String company;
	private Date effFrom;//有效开始时间
	private Date effTo;//有效开始时间
	private UserRegisterStatus status;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public Date getEffFrom() {
		return effFrom;
	}
	public UserRegisterStatus getStatus() {
		return status;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEffFrom(Date effFrom) {
		this.effFrom = effFrom;
	}
	public void setStatus(UserRegisterStatus status) {
		this.status = status;
	}
	public Date getEffTo() {
		return effTo;
	}
	public void setEffTo(Date effTo) {
		this.effTo = effTo;
	}
	public String getSalt() {
		return salt;
	}
	public String getPassword() {
		return password;
	}
	public String getCompany() {
		return company;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
