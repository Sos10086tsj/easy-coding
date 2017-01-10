package com.chinesedreamer.easycoding.sys.user.service;

import com.chinesedreamer.easycoding.exception.user.UserException;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
public interface UserService {
	public void userLogin(String username, String password) throws UserException;
}
