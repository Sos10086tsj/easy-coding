package com.chinesedreamer.easycoding.exception.user;

import com.chinesedreamer.easycoding.exception.BaseException;
import com.chinesedreamer.easycoding.exception.ErrorMessage;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 15, 2016
**/
public class UserException extends BaseException{

	public UserException(ErrorMessage errorMessage) {
		super(errorMessage);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1747516676748494876L;

}
