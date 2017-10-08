package com.srs.service.impl;

/**
 * @author SHEKAR BANDARI
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srs.bean.CreateApplicationBean;
import com.srs.dao.ApplicationDAO;
import com.srs.model.ApplicationDO;
import com.srs.service.ApplicationService;


@Service("ApplicationService")
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	ApplicationDAO applicationDAO;

	@Override
	@Transactional
	public void createApplicationDetails(CreateApplicationBean createApplicationBean) {
		ApplicationDO applicationDO=new ApplicationDO();
		
		applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
		applicationDO.setApplicationName(createApplicationBean.getApplicationName());
		applicationDO.setSkillSet(createApplicationBean.getSkillSet());
		applicationDO.setDesignation(createApplicationBean.getDesignation());
		applicationDO.setLocation(createApplicationBean.getLocation());
		applicationDO.setUserId(2);
		applicationDO.setRoleId(2);
		
		applicationDAO.createApplicationDetails(applicationDO);
		
		
		
	}

	@Override
	@Transactional
	public CreateApplicationBean getApplicationDetails() {
		CreateApplicationBean createApplicationBean=new CreateApplicationBean();
	ApplicationDO applicationDO=	applicationDAO.getApplicationDetails();
	createApplicationBean.setApplicationName(applicationDO.getApplicationName());
	createApplicationBean.setApplicationDetails(applicationDO.getApplicationDetails());
	createApplicationBean.setSkillSet(applicationDO.getSkillSet());
	createApplicationBean.setDesignation(applicationDO.getDesignation());
	createApplicationBean.setLocation(applicationDO.getLocation());
	
		
		return createApplicationBean;
	}

	@Override
	@Transactional
	public void submitApplicationDetails(CreateApplicationBean createApplicationBean) {
		
ApplicationDO applicationDO=new ApplicationDO();
		
		applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
		applicationDO.setApplicationName(createApplicationBean.getApplicationName());
		applicationDO.setSkillSet(createApplicationBean.getSkillSet());
		applicationDO.setDesignation(createApplicationBean.getDesignation());
		applicationDO.setLocation(createApplicationBean.getLocation());
		applicationDO.setUserId(3);
		applicationDO.setRoleId(3);
		
		applicationDAO.submitApplicationDetails(applicationDO);
		
		
		
	}

	@Override
	@Transactional
	public CreateApplicationBean getApplicationDetailsForAttendInterviewDetailsView() {
		CreateApplicationBean createApplicationBean=new CreateApplicationBean();
		ApplicationDO applicationDO=applicationDAO.getApplicationDetailsForAttendInterviewDetailsView();
		
		createApplicationBean.setApplicationName(applicationDO.getApplicationName());
		createApplicationBean.setApplicationDetails(applicationDO.getApplicationDetails());
		createApplicationBean.setSkillSet(applicationDO.getSkillSet());
		createApplicationBean.setDesignation(applicationDO.getDesignation());
		createApplicationBean.setLocation(applicationDO.getLocation());
		
			
			return createApplicationBean;
	}

	@Override
	@Transactional
	public void attendInterviewDetails(CreateApplicationBean createApplicationBean) {
ApplicationDO applicationDO=new ApplicationDO();
		
		applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
		applicationDO.setApplicationName(createApplicationBean.getApplicationName());
		applicationDO.setSkillSet(createApplicationBean.getSkillSet());
		applicationDO.setDesignation(createApplicationBean.getDesignation());
		applicationDO.setLocation(createApplicationBean.getLocation());
		applicationDO.setUserId(4);
		applicationDO.setRoleId(4);
		
		applicationDAO.attendInterviewDetails(applicationDO);
		
		
		
	}

	@Override
	@Transactional
	public CreateApplicationBean getApplicationDetailsForreviewOfferDetailsView() {
		CreateApplicationBean createApplicationBean=new CreateApplicationBean();
		ApplicationDO applicationDO=applicationDAO.getApplicationDetailsForAttendInterviewDetailsView();
		
		createApplicationBean.setApplicationName(applicationDO.getApplicationName());
		createApplicationBean.setApplicationDetails(applicationDO.getApplicationDetails());
		createApplicationBean.setSkillSet(applicationDO.getSkillSet());
		createApplicationBean.setDesignation(applicationDO.getDesignation());
		createApplicationBean.setLocation(applicationDO.getLocation());
		
			
			return createApplicationBean;
		
	}

	@Override
	@Transactional
	public void reviewOfferDetails(CreateApplicationBean createApplicationBean) {
        ApplicationDO applicationDO=new ApplicationDO();
		
		applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
		applicationDO.setApplicationName(createApplicationBean.getApplicationName());
		applicationDO.setSkillSet(createApplicationBean.getSkillSet());
		applicationDO.setDesignation(createApplicationBean.getDesignation());
		applicationDO.setLocation(createApplicationBean.getLocation());
		applicationDO.setUserId(7);
		applicationDO.setRoleId(7);
		
		applicationDAO.reviewOfferDetails(applicationDO);
		
		
		
	}

	@Override
	@Transactional
	public CreateApplicationBean getApplicationDetailsForsubmitAcceptanceFormDetailsView() {
		CreateApplicationBean createApplicationBean=new CreateApplicationBean();
		ApplicationDO applicationDO=applicationDAO.getApplicationDetailsForsubmitAcceptanceFormDetailsView();
		
		createApplicationBean.setApplicationName(applicationDO.getApplicationName());
		createApplicationBean.setApplicationDetails(applicationDO.getApplicationDetails());
		createApplicationBean.setSkillSet(applicationDO.getSkillSet());
		createApplicationBean.setDesignation(applicationDO.getDesignation());
		createApplicationBean.setLocation(applicationDO.getLocation());
		
			
			return createApplicationBean;
	}

	@Override
	@Transactional
	public void submitAcceptanceFormDetails(CreateApplicationBean createApplicationBean) {
		  ApplicationDO applicationDO=new ApplicationDO();
			
			applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
			applicationDO.setApplicationName(createApplicationBean.getApplicationName());
			applicationDO.setSkillSet(createApplicationBean.getSkillSet());
			applicationDO.setDesignation(createApplicationBean.getDesignation());
			applicationDO.setLocation(createApplicationBean.getLocation());
			applicationDO.setUserId(5);
			applicationDO.setRoleId(5);
			
			applicationDAO.submitAcceptanceFormDetails(applicationDO);
		
	}

	@Override
	@Transactional
	public CreateApplicationBean getRejectOfferDetailsView() {
		CreateApplicationBean createApplicationBean=new CreateApplicationBean();
		ApplicationDO applicationDO=applicationDAO.getRejectOfferDetailsView();
		
		createApplicationBean.setApplicationName(applicationDO.getApplicationName());
		createApplicationBean.setApplicationDetails(applicationDO.getApplicationDetails());
		createApplicationBean.setSkillSet(applicationDO.getSkillSet());
		createApplicationBean.setDesignation(applicationDO.getDesignation());
		createApplicationBean.setLocation(applicationDO.getLocation());
		
			
			return createApplicationBean;
		
	}

	@Override
	@Transactional
	public void rejectOfferDetails(CreateApplicationBean createApplicationBean) {
		  ApplicationDO applicationDO=new ApplicationDO();
			
			applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
			applicationDO.setApplicationName(createApplicationBean.getApplicationName());
			applicationDO.setSkillSet(createApplicationBean.getSkillSet());
			applicationDO.setDesignation(createApplicationBean.getDesignation());
			applicationDO.setLocation(createApplicationBean.getLocation());
			applicationDO.setUserId(5);
			applicationDO.setRoleId(5);
			
			applicationDAO.rejectOfferDetails(applicationDO);
		
		
	}

	@Override
	@Transactional
	public void rejectDetails(CreateApplicationBean createApplicationBean) {
		 ApplicationDO applicationDO=new ApplicationDO();
			
			applicationDO.setApplicationDetails(createApplicationBean.getApplicationDetails());
			applicationDO.setApplicationName(createApplicationBean.getApplicationName());
			applicationDO.setSkillSet(createApplicationBean.getSkillSet());
			applicationDO.setDesignation(createApplicationBean.getDesignation());
			applicationDO.setLocation(createApplicationBean.getLocation());
			applicationDO.setUserId(6);
			applicationDO.setRoleId(6);
			
			applicationDAO.rejectOfferDetails(applicationDO);
		
		
		
	}

	
	
	
}
