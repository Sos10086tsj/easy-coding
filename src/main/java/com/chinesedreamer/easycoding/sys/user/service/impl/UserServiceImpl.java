package com.chinesedreamer.easycoding.sys.user.service.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.easycoding.constant.ApplicationConstant;
import com.chinesedreamer.easycoding.domain.constant.UserRegisterStatus;
import com.chinesedreamer.easycoding.domain.dao.UserDao;
import com.chinesedreamer.easycoding.domain.dao.UserRegisterDao;
import com.chinesedreamer.easycoding.domain.model.User;
import com.chinesedreamer.easycoding.domain.model.UserRegister;
import com.chinesedreamer.easycoding.exception.ErrorMessage;
import com.chinesedreamer.easycoding.exception.ErrorMessageCode;
import com.chinesedreamer.easycoding.exception.user.UserException;
import com.chinesedreamer.easycoding.exception.user.UsernameNotExistException;
import com.chinesedreamer.easycoding.exception.user.UsernamePassNotMatchException;
import com.chinesedreamer.easycoding.sys.user.service.UserService;
import com.chinesedreamer.easycoding.util.EncryptionUtil;
import com.chinesedreamer.easycoding.util.ErrorMessageUtil;
import com.chinesedreamer.easycoding.util.IdUtil;
import com.chinesedreamer.easycoding.util.SessionUtil;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Resource
	private UserRegisterDao userRegisterDao;

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
		SessionUtil.addUserId(user.getId());
	}

	@Override
	public boolean exist(String username) {
		return null == this.userDao.findByUsername(username) ? false : true;
	}

	@Override
	public void saveRegister(String username, String password, String company) {
		UserRegister ur = this.userRegisterDao.findByUsername(username);
		boolean isUpdate = true;
		if (null == ur) {
			ur = new UserRegister();
			ur.setUsername(username);
			isUpdate = false;
		}
		String salt = IdUtil.generateSalt(ApplicationConstant.USER.SALT_LENGTH);
		ur.setSalt(salt);
		ur.setPassword(EncryptionUtil.md5L32(password + salt));
		ur.setStatus(UserRegisterStatus.VALID);
		ur.setCompany(company);
		
		Calendar calendar = Calendar.getInstance();
		ur.setEffFrom(calendar.getTime());
		calendar.add(Calendar.MINUTE, ApplicationConstant.USER.REGISTER_TOKEN_EXPIRE);
		ur.setEffTo(calendar.getTime());
		
		String token = EncryptionUtil.md5L32(username + password + company);
		ur.setToken(token);
		
		if (isUpdate) {
			this.userRegisterDao.update(ur);
		}else {
			this.userRegisterDao.save(ur);
		}
		//TODO 加入邮件通知列表
	}

}
