package com.srs.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srs.bean.ChangeUserPasswordBean;
import com.srs.bean.ForgotPasswordBean;
import com.srs.model.UserDO;
import com.srs.service.UserService;
import com.srs.validator.ChangePasswordValidator;
import com.srs.validator.ForgotPasswordValidator;


/**
 * @author SHEKAR BANDARI
 *
 */

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	@Autowired
	private ForgotPasswordValidator forgotPasswordValidator;
	
	
	private static final Logger logger=Logger.getLogger(UserController.class);
	
	
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(ModelMap model){
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/failure",method=RequestMethod.GET)
	public ModelAndView failure(ModelMap model){
		String failure="Invalid Username and Password";
		model.addAttribute("failure", failure);
		return new ModelAndView("login",model);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView displayHome(ModelMap model){
		
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String userLoginId = user.getUsername(); // get logged in username
		UserDO userdb = userService.retrieveUser(userLoginId);
		
		/*******************  Image Password  **************************************************/
		if(userdb.getImagePassword()==1){
			return new ModelAndView("redirect:changePassword.html");
		}
		
	
		if (userdb.getRoleId() == 1) {

			return new ModelAndView("redirect:createApplicationDetailsView.html");
		}
		if (userdb.getRoleId() == 2) {

			return new ModelAndView("redirect:submitApplicationDetailsView.html");
		}
		if (userdb.getRoleId() == 3) {

			return new ModelAndView("redirect:attendInterviewDetailsView.html");
		}
		if (userdb.getRoleId() == 4) {

			return new ModelAndView("redirect:reviewOfferDetailsView.html");
		}
		if (userdb.getRoleId() == 5) {

			return new ModelAndView("redirect:submitAcceptanceFormDetailsView.html");
		}
		if (userdb.getRoleId() == 6) {

			return new ModelAndView("redirect:rejectOfferDetailsView.html");
		}
		
		
		
		return new ModelAndView("employeeHome",model);
	}
	
	
	@RequestMapping(value="/changePassword")
	public ModelAndView imagePasswordView(@ModelAttribute(value = "changePassword") ChangeUserPasswordBean changePasswordBean,ModelMap model){
		return new ModelAndView("imagePassword",model);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ModelAndView saveChangedPassord(
			ModelMap model,
			@ModelAttribute(value = "changePassword") @Valid ChangeUserPasswordBean userbean,
			BindingResult result) throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidAlgorithmParameterException,
			UnsupportedEncodingException, IllegalBlockSizeException,
			BadPaddingException {

		//boolean isPasswordChanged = false;
		//String view = "redirect:/changePassword.html";

		// get current user's username
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String userLoginId = user.getUsername(); // get logged in username
		UserDO userdb = userService.retrieveUser(userLoginId);

		userbean.setUserName(user.getUsername());

		// validate form parameters
		changePasswordValidator.validate(userbean, result);

		if (result.hasErrors()) {
			logger.debug("Change password- has validation errors");
			if(userdb.getImagePassword()==1){
				logger.debug("Change password- has validation errors");
				return new ModelAndView("imagePassword");
			}else{
				return new ModelAndView("changePassword");
			}

		} else {

			// calling service method for password change
			if(userdb.getImagePassword()==1){
				userService.changePassword(userbean);
				//isPasswordChanged = true;
				String message="Your password has been changed successfully, please relogin ";
				model.put("message", message);
				return new ModelAndView("login");
				
			}else{
			userService.changePassword(userbean);

			// flag to check if password is changed successfully`
			//isPasswordChanged = true;
			String message="Your password has been changed successfully, please relogin ";
			model.put("message", message);
			return new ModelAndView("login",model);
		}
		}
	}
	
	
	@RequestMapping(value="/forgotPassword",method=RequestMethod.GET)
	public ModelAndView forgotPasswordView(@ModelAttribute("forgotPassword")ForgotPasswordBean forgotPassword,ModelMap model){
		return new ModelAndView("forgotPassword",model);
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword(
			@ModelAttribute("forgotPassword") @Valid ForgotPasswordBean forgotPasswordbean,
			ModelMap model, BindingResult result) {

		logger.debug("In side forgot password method");
		forgotPasswordValidator.validate(forgotPasswordbean, result);
		String message = null;
		//String view = "/views/forgot";

		if (result.hasErrors()) {
			logger.debug("Forgot password- has validation errors");

		} else {
			UserDO user = userService.retrieveUser(forgotPasswordbean.getUserName());
			String Password = userService.decryptPasword(user);
			String[] cc = null;
			userService.sendMail(user.getUserEmail(), "password",
					"Your password is:: " + Password, cc);
			message = "Your Password is sent to your Registred Mail-Id!";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forgotPassword", model);

	}
	

}
