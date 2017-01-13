package com.chinesedreamer.easycoding.sys.user.service;

import com.chinesedreamer.easycoding.exception.user.UserException;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
public interface UserService {
	public void userLogin(String username, String password) throws UserException;
	
	public boolean exist(String username);
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @param company
	 * @return 返回激活token
	 */
	public void saveRegister(String username,String password,String company);
}
