package com.chinesedreamer.easycoding.sys.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.easycoding.domain.dao.UserDao;
import com.chinesedreamer.easycoding.domain.model.User;
import com.chinesedreamer.easycoding.exception.ErrorMessage;
import com.chinesedreamer.easycoding.exception.ErrorMessageCode;
import com.chinesedreamer.easycoding.exception.user.UserException;
import com.chinesedreamer.easycoding.exception.user.UsernameNotExistException;
import com.chinesedreamer.easycoding.exception.user.UsernamePassNotMatchException;
import com.chinesedreamer.easycoding.sys.user.service.UserService;
import com.chinesedreamer.easycoding.util.EncryptionUtil;
import com.chinesedreamer.easycoding.util.ErrorMessageUtil;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	@Override
	public void userLogin(String username, String password) throws UserException {
		User user = this.userDao.findByUsername(username);
		if (null == user) {
			ErrorMessage errorMessage = ErrorMessageUtil.getErrorMessage(ErrorMessageCode.USER.CODE, ErrorMessageCode.USER.USER_NOT_EXIST,username);
			throw new UsernameNotExistException(errorMessage);
		}
		if (!user.getPassword().equals(EncryptionUtil.md5L32(password + user.getSalt()))) {
			ErrorMessage errorMessage = ErrorMessageUtil.getErrorMessage(ErrorMessageCode.USER.CODE, ErrorMessageCode.USER.USERNAME_PASS_NOT_MATCH);
			throw new UsernamePassNotMatchException(errorMessage);
		}
	}

}
