package com.srs.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srs.dao.EmployeeDAO;
import com.srs.model.EmployeeDO;


@Repository("EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addEmployeeInfo(EmployeeDO empDO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(empDO);
		logger.info("data has been successfully entered" +empDO);
		// TODO Auto-generated method stub
		
		
	}

	

}
