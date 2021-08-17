package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.entity.User;

public class Test {
	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		UserDao userDao = new UserDaoImpl();
		userDao = (UserDao) context.getBean("userDaoImpl");
		
		User u = new User();
		u.setAddress("New Chore");
		u.setEmail("kumarnaresh@gmail.com");
		u.setPassword("naresh123");
		u.setUsername("naresh123");
		Integer add = userDao.addUser(u);
		System.out.println("Added : " + add);
	}
}
