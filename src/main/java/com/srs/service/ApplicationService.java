package com.srs.service;
/**
 * @author SHEKAR BANDARI
 *
 */

import com.srs.bean.CreateApplicationBean;

public interface ApplicationService {
	void createApplicationDetails(CreateApplicationBean createApplicationBean);
	
	CreateApplicationBean getApplicationDetails();
	void submitApplicationDetails(CreateApplicationBean createApplicationBean);
	
	CreateApplicationBean getApplicationDetailsForAttendInterviewDetailsView();
	void attendInterviewDetails(CreateApplicationBean createApplicationBean);
	
	CreateApplicationBean getApplicationDetailsForreviewOfferDetailsView();
	void reviewOfferDetails(CreateApplicationBean createApplicationBean);
	
	CreateApplicationBean getApplicationDetailsForsubmitAcceptanceFormDetailsView();
	void submitAcceptanceFormDetails(CreateApplicationBean createApplicationBean);
	
	void rejectDetails(CreateApplicationBean createApplicationBean);
	CreateApplicationBean getRejectOfferDetailsView();
	void rejectOfferDetails(CreateApplicationBean createApplicationBean);


}
