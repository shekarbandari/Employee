package com.srs.dao;
/**
 * @author SHEKAR BANDARI
 *
 */

import com.srs.model.ApplicationDO;

public interface ApplicationDAO {
	void createApplicationDetails(ApplicationDO applicationDO);
	
	ApplicationDO getApplicationDetails();
	void submitApplicationDetails(ApplicationDO applicationDO);
	
	ApplicationDO getApplicationDetailsForAttendInterviewDetailsView();
	void attendInterviewDetails(ApplicationDO applicationDO);
	
	ApplicationDO getApplicationDetailsForreviewOfferDetailsView();
	void reviewOfferDetails(ApplicationDO applicationDO);
	
	ApplicationDO getApplicationDetailsForsubmitAcceptanceFormDetailsView();
	void submitAcceptanceFormDetails(ApplicationDO applicationDO);
	
	void rejectDetails(ApplicationDO applicationDO);
	ApplicationDO getRejectOfferDetailsView();
	void rejectOfferDetails(ApplicationDO applicationDO);

}
