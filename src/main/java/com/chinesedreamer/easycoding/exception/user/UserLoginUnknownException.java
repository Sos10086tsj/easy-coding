package com.chinesedreamer.easycoding.exception.user;

import com.chinesedreamer.easycoding.exception.ErrorMessage;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 16, 2016
**/
public class UserLoginUnknownException extends UserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 88797274972296468L;

	public UserLoginUnknownException(ErrorMessage errorMessage) {
		super(errorMessage);
	}

}
