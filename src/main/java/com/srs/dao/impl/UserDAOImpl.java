package com.srs.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srs.dao.UserDAO;
import com.srs.model.UserDO;
import com.srs.model.UserPasswordHistoryDO;

/**
 * @author SHEKAR BANDARI
 *
 */
@Repository
public class UserDAOImpl implements UserDAO{
private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;


	

	@Override
	@Transactional
	public UserDO retrieveUser(String username) {
		// TODO Auto-generated method stub
		logger.debug("in DAO Impl retrieve user...." + username);	
		UserDO userDO = null;
		try{
			logger.debug("############# in DAO Impl  SESSION1 ...." + sessionFactory);	
			 logger.debug("############# in DAO Impl  SESSION2 ...." + sessionFactory.getCurrentSession());	
	
		 Query query = sessionFactory.getCurrentSession().createQuery("from UserDO where userName='" + username + "'");
		 logger.debug("in DAO Impl retrieve user after executing query...." + query);
		 userDO = (UserDO)query.list().get(0); 
		//sessionFactory.getCurrentSession().flush();
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
		}
		
		logger.debug("in DAO Impl retrieve user...." + userDO);
		return userDO;
	}




	@Override
	public void auditChangePassword(UserPasswordHistoryDO userPasswordHistory) {
		sessionFactory.getCurrentSession().save(userPasswordHistory);
		
		
	}




	@Override
	public void changePassword(UserDO userDO) {
	
		sessionFactory.getCurrentSession().save(userDO);
		
	}




	@Override
	public List<UserPasswordHistoryDO> findAllPreviousPasswordsOfUser(String userName) {
		 logger.debug("Finding all previous passwords of user... ");

	        Query query = this.sessionFactory
	                .getCurrentSession()
	                .createQuery(
	                        "from UserPasswordHistoryDO uh where uh.tbluser.userName =:username");
	        query.setString("username", userName);

	        // get previous password list
	        List<UserPasswordHistoryDO> prevHistory= query.list();

	        return prevHistory;
	}




	@Override
	public UserPasswordHistoryDO retrieveUserPasswordHistory(long userId) {
		// TODO Auto-generated method stub
		logger.debug("in DAO Impl retrieve user...." + userId);	
		UserPasswordHistoryDO userPasswordHistoryDO = null;
		try{
			logger.debug("############# in DAO Impl ...." + sessionFactory);	
			 logger.debug("############# in DAO Impl  ...." + sessionFactory.getCurrentSession());	
	
		 Query query = sessionFactory.getCurrentSession().createQuery("from UserPasswordHistoryDO where UserId=" + userId);
		 logger.debug("in DAO Impl retrieve user after executing query...." + query);
		 userPasswordHistoryDO = (UserPasswordHistoryDO)query.list().get(0); 
		//sessionFactory.getCurrentSession().flush();
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
		}
		
		logger.debug("in DAO Impl retrieve user...." + userPasswordHistoryDO);
		return userPasswordHistoryDO;
	}


}
