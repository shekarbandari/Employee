package com.srs.dao.impl;
/**
 * @author SHEKAR BANDARI
 *
 */

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srs.dao.ApplicationDAO;
import com.srs.model.ApplicationDO;


@Repository("ApplicationDAO")
public class ApplicationDAOImpl implements ApplicationDAO{
	private static final Logger logger = Logger.getLogger(ApplicationDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void createApplicationDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
	
	}

	@Override
	public ApplicationDO getApplicationDetails() {
		ApplicationDO applicationDO=null;
		
		try{
		Query query=sessionFactory.getCurrentSession().createQuery("from ApplicationDO where userId=2");
	applicationDO=(ApplicationDO)query.list().get(0);
		
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
			
		}
		
		return applicationDO;
	}

	@Override
	public void submitApplicationDetails(ApplicationDO applicationDO) {
	sessionFactory.getCurrentSession().save(applicationDO);
		
	}

	@Override
	public ApplicationDO getApplicationDetailsForAttendInterviewDetailsView() {
      ApplicationDO applicationDO=null;
		
		try{
		Query query=sessionFactory.getCurrentSession().createQuery("from ApplicationDO where userId=3");
	applicationDO=(ApplicationDO)query.list().get(0);
		
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
			
		}
		
		return applicationDO;
	}

	@Override
	public void attendInterviewDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
		
	}

	@Override
	public ApplicationDO getApplicationDetailsForreviewOfferDetailsView() {
		 ApplicationDO applicationDO=null;
			
			try{
			Query query=sessionFactory.getCurrentSession().createQuery("from ApplicationDO where userId=4");
		applicationDO=(ApplicationDO)query.list().get(0);
			
			}catch(Exception e){
				logger.error("error in retrieving user details :::" + e);
				
			}
			
			return applicationDO;
	}

	@Override
	public void reviewOfferDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
		
	}

	@Override
	public ApplicationDO getApplicationDetailsForsubmitAcceptanceFormDetailsView() {
		ApplicationDO applicationDO=null;
		
		try{
		Query query=sessionFactory.getCurrentSession().createQuery("from ApplicationDO where userId=5");
	applicationDO=(ApplicationDO)query.list().get(0);
		
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
			
		}
		
		return applicationDO;
	}

	@Override
	public void submitAcceptanceFormDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
		
	}

	@Override
	public ApplicationDO getRejectOfferDetailsView() {
		ApplicationDO applicationDO=null;
		
		try{
		Query query=sessionFactory.getCurrentSession().createQuery("from ApplicationDO where userId=6");
	applicationDO=(ApplicationDO)query.list().get(0);
		
		}catch(Exception e){
			logger.error("error in retrieving user details :::" + e);
			
		}
		
		return applicationDO;
	}

	@Override
	public void rejectOfferDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
		
	}

	@Override
	public void rejectDetails(ApplicationDO applicationDO) {
		sessionFactory.getCurrentSession().save(applicationDO);
		
	}
	
	

}
