package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public Integer addUser(User u);
	public void upateUser(User user);
	public void deleteUser(Integer id);
	public User getUserById(Integer id);
	public List<User> getUser();
	public User getUserByName(String name);
}
