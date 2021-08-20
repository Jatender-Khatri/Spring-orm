package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public Integer addUser(User u) {
		return (Integer) this.hibernateTemplate.save(u);
	}
	@Transactional
	public void upateUser(User user) {
		this.hibernateTemplate.update(user);
		
	}
	@Transactional
	public void deleteUser(Integer id) {
		User user = this.hibernateTemplate.get(User.class, id);
		this.hibernateTemplate.delete(user);	
	}
	
	public User getUserById(Integer id) {
		return this.hibernateTemplate.get(User.class, id);
	}

	public List<User> getUser() {
		return this.hibernateTemplate.loadAll(User.class);
	}
	public User getUserByName(String name) {
		return this.hibernateTemplate.get(User.class, name);
	}
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
