package com.daoImpl;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public Integer addUser(User u) {
		Integer roll = null;
		try {
			roll = (Integer) this.hibernateTemplate.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roll;
	}
	@Transactional
	public void upateUser(User user) {
		this.hibernateTemplate.update(user);
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
	public void deleteUser(Integer id) {
		User u = this.hibernateTemplate.get(User.class,id);
		this.hibernateTemplate.delete(u);
		
	}

	
}
