package com.chinesedreamer.easycoding.domain.dao;

import com.chinesedreamer.easycoding.domain.model.User;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
public interface UserDao {
	public User findByUsername(String username);
}
