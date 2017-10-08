package com.srs.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srs.bean.ChangeUserPasswordBean;
import com.srs.service.UserService;

/**
 * @author Shekar Bandari
 * 
 */
@Component
public class ChangePasswordValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangeUserPasswordBean.class.isAssignableFrom(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {

		ChangeUserPasswordBean cpb = (ChangeUserPasswordBean) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword","password.old.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","password.confirm.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.new.required");


		if (!errors.hasFieldErrors("oldPassword")
				&& userService.isCurrentPasswordInvalid(cpb)) {
			errors.rejectValue("oldPassword", "password.old.invalid");
		}
		
		
		if ((!cpb.getPassword().equals("")&&!cpb.getOldPassword().equals(""))&& cpb.getPassword().equals(cpb.getOldPassword())) {
			errors.rejectValue("password", "password.old.same");
		}
		
		
		
		 if (!(cpb.getPassword() != null && cpb.getPassword().isEmpty()))
		 {
			
			 
			 if(!(cpb.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!_@#$%^&+=])(?=[\\S]+$).{6,12}$")))
			 {
							
				 errors.rejectValue("password","password.new.size");
			 }
		 
		 }
		 
		
		
		

		if (!errors.hasFieldErrors("password")
				&& userService.isPasswordPrevoiuslySet(cpb)) {
			errors.rejectValue("password", "password.new.previously_set");
		}

		
		if (!errors.hasFieldErrors("confirmPassword")
				&& !cpb.getPassword().equals(cpb.getConfirmPassword())) {
			errors.rejectValue("confirmPassword",
					"password.new_confirm.mismatch");
		}

	}

}
