package com.chinesedreamer.easycoding.exception.user;

import com.chinesedreamer.easycoding.exception.ErrorMessage;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 16, 2016
**/
public class UsernamePassNotMatchException extends UserException{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2648211344340683313L;
	
	public UsernamePassNotMatchException(ErrorMessage errorMessage) {
		super(errorMessage);
	}
}
