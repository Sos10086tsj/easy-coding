package com.chinesedreamer.easycoding.domain.dao;

import com.chinesedreamer.easycoding.domain.model.UserRegister;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 13, 2017
**/
public interface UserRegisterDao {
	public int save(UserRegister register);
	public int update(UserRegister register);
	public UserRegister findByUsername(String username);
}
