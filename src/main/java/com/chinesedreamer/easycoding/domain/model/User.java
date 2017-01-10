package com.chinesedreamer.easycoding.domain.model;
/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
public class User extends BaseModel{
	private String username;
	private String salt;
	private String name;
	private String password;
	public String getUsername() {
		return username;
	}
	public String getSalt() {
		return salt;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
