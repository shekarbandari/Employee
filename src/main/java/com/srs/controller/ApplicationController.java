package com.srs.controller;
/**
 * @author SHEKAR BANDARI
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srs.bean.CreateApplicationBean;
import com.srs.service.ApplicationService;


@Controller
public class ApplicationController {
	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value="/createApplicationDetailsView")
	public ModelAndView createApplicationView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		return new ModelAndView("createApplication",model);
	}
	
	@RequestMapping(value="/createApplicationDetails",method = RequestMethod.POST)
	public ModelAndView createApplicationDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		applicationService.createApplicationDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
	}
	
	@RequestMapping(value="/submitApplicationDetailsView")
	public ModelAndView submitApplicationDetailsView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
	     createApplicationBean= applicationService.getApplicationDetails();
	     model.addAttribute("createApplicationBean",createApplicationBean);
		return new ModelAndView("submitApplication",model);
	}
	@RequestMapping(value="/submitApplicationDetails",method = RequestMethod.POST)
	public ModelAndView submitApplicationDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		if(createApplicationBean.isSelectedInterview()==true){
		applicationService.submitApplicationDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
		}else{
			return new ModelAndView("rejected",model);
		}
	}
	
	
	
	@RequestMapping(value="/attendInterviewDetailsView")
	public ModelAndView attendInterviewDetailsView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
	     createApplicationBean= applicationService.getApplicationDetailsForAttendInterviewDetailsView();
	     model.addAttribute("createApplicationBean",createApplicationBean);
		return new ModelAndView("attendInterview",model);
	}
	@RequestMapping(value="/attendInterviewDetails",method = RequestMethod.POST)
	public ModelAndView attendInterviewDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		if(createApplicationBean.isSelectedInterview()==true){
		applicationService.attendInterviewDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
		}else{
			return new ModelAndView("rejected",model);
		}
	}
	
	
	
	@RequestMapping(value="/reviewOfferDetailsView")
	public ModelAndView reviewOfferDetailsView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
	     createApplicationBean= applicationService.getApplicationDetailsForreviewOfferDetailsView();
	     model.addAttribute("createApplicationBean",createApplicationBean);
		return new ModelAndView("reviewOffer",model);
	}
	@RequestMapping(value="/reviewOfferDetails",method = RequestMethod.POST)
	public ModelAndView reviewOfferDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		if(createApplicationBean.isSelectedInterview()==true){
		applicationService.reviewOfferDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
		}else{
			applicationService.rejectDetails(createApplicationBean);
			return new ModelAndView("rejectOffer",model);
		}
	}
	
	
	@RequestMapping(value="/submitAcceptanceFormDetailsView")
	public ModelAndView submitAcceptanceFormDetailsView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
	     createApplicationBean= applicationService.getApplicationDetailsForreviewOfferDetailsView();
	     model.addAttribute("createApplicationBean",createApplicationBean);
		return new ModelAndView("submitAcceptance",model);
	}
	@RequestMapping(value="/submitAcceptanceFormDetails",method = RequestMethod.POST)
	public ModelAndView submitAcceptanceFormDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		
		applicationService.reviewOfferDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
		
	}
	
	
	
	@RequestMapping(value="/rejectOfferDetailsView")
	public ModelAndView rejectOfferDetailsView(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
	     createApplicationBean= applicationService.getApplicationDetailsForAttendInterviewDetailsView();
	     model.addAttribute("createApplicationBean",createApplicationBean);
		return new ModelAndView("rejectOfferDetails",model);
	}
	@RequestMapping(value="/rejectOfferDetails",method = RequestMethod.POST)
	public ModelAndView rejectOfferDetails(@ModelAttribute(value = "createApp") CreateApplicationBean createApplicationBean,ModelMap model){
		
		applicationService.attendInterviewDetails(createApplicationBean);
		
		return new ModelAndView("success",model);
		
	}

}
