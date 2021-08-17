package com.dao;

import com.entity.User;

public interface UserDao {
	public Integer addUser(User u);
	public void upateUser(User user);
	public Integer deleteUser(User u);
}
