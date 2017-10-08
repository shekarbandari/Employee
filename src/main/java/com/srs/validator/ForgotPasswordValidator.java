package com.srs.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srs.bean.ForgotPasswordBean;
import com.srs.model.UserDO;
import com.srs.service.UserService;

@Component
public class ForgotPasswordValidator implements Validator {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger
			.getLogger(ForgotPasswordValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@ you in ForgotPassword Validator class");
		
		return ForgotPasswordBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@ you in Forgot Validator class");
		
		
		ForgotPasswordBean fpb=(ForgotPasswordBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "email.required");
		
		UserDO user=userService.retrieveUser(fpb.getUserName());
		
		
		if( user!= null){
			errors.rejectValue("userName","InvalidUserName");
		}
		if (user!=null && ! fpb.getEmail().equals(user.getUserEmail())) {
			errors.rejectValue("email","InvalidEmail");
		}
	}
	
}

