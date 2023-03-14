package com.kim.blog.dao;

import com.kim.blog.dto.UserDto;

public interface IUserDao {
	
	int saveUser(UserDto user);
	UserDto selectUserByUsernameAndPassword(String username,String password);
}
