/**
 * 
 */
package com.srs.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srs.bean.ChangeUserPasswordBean;
import com.srs.bean.GeneralBean;
import com.srs.dao.UserDAO;
import com.srs.model.UserDO;
import com.srs.model.UserPasswordHistoryDO;
import com.srs.service.UserService;
import com.srs.util.CommonUtil;
import com.srs.util.CryptoUtil;



/**
 * @author SHEKAR BANDARI
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserDAO userDAO;
	@Autowired
	private GeneralBean generalBean;
	
	// added below to implement Spring Security
	 @Override
     @Transactional
	public UserDetails loadUserByUsername(String userName)	throws UsernameNotFoundException {
		
		
		System.out.println("############  ###########################################################");
		System.out.println("############   finally inside loadUSER -->" + userName);
		System.out.println("############  ###########################################################");
		
		
		//UserDO user = retrieveUser(userName);
	UserDO user=	retrieveUser(userName);
		
		// Decrypt the User password and send it 
		String strPassword = decryptPasword(user);
		
		System.out.println("######################################### db password  #############################"+strPassword);

		
		// check Employee Designation
		// For all Employees use getAuthorities(1)
		ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority> ();
		
		// Grant ROLE_USER to the current loggedInEmployee by default
		grantedAuthorities = getAuthorities(4, grantedAuthorities);
		
		// scan thru all the user roles
		// If user has an ADMIN role, add ADMIN authority too to grantedAuthorities
		
		
		
		/*List<UserRoleDO> userRoles = user.getTbluserroles();
		for(UserRoleDO userRoleDO: userRoles){			
			if (userRoleDO.getTblrole().getRoleId() == 1)
				grantedAuthorities = getAuthorities(1, grantedAuthorities);
		} // scan thru all the user roles 
		*/
		// INDU needs to be deleted
		//strPassword = "test123";  
		
		UserDetails userDetails = new User(userName, strPassword, true, true, true,	true, grantedAuthorities);
		return userDetails;
	}//loadUserByUserName

	
	// Granted Authorities
	public ArrayList<GrantedAuthority> getAuthorities(Integer role, ArrayList<GrantedAuthority> authList) {
		if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if (role.intValue() == 2) {
			authList.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
		} else if (role.intValue() == 3) {
			authList.add(new SimpleGrantedAuthority("ROLE_PRINCIPAL"));
		} else if (role.intValue() == 4) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}

		return authList;
	} //getAuthorities


	 // This performs Decrypt service takes SALT + GUID (Encryption) key and applies it on Password and 
	 // returns the original decrypted password
	@Override
	@Transactional
    public  String decryptPasword(UserDO user){
            String password = "";
           

            try{
                String dbpassword = 
                		CryptoUtil.decrypt(
               			user.getPasswordSALT() + user.getPasswordGUID(), user.getUserPassword());
                logger.debug("In retrieve user method service ..dbpassword.."  + dbpassword);
                password = dbpassword;
            } catch(Exception e){
                    e.printStackTrace();
            } // try-catch

            return password;
    } // decryptPassword


	@Override
	@Transactional
	public UserDO retrieveUser(String username) {
		
		logger.debug("In retrieve user method service ...UserName.." + username);
		
        return userDAO.retrieveUser(username);
	}


	 @Override
	    @Transactional
	    public void changePassword(ChangeUserPasswordBean user)
	            throws InvalidKeyException, NoSuchAlgorithmException,
	            InvalidKeySpecException, NoSuchPaddingException,
	            InvalidAlgorithmParameterException, UnsupportedEncodingException,
	            IllegalBlockSizeException, BadPaddingException {

	        logger.debug("Inside UserServiceImpl#changePassword()");
	        

	     
	        UserDO userdo = userDAO.retrieveUser(user.getUserName());
	       UserPasswordHistoryDO userPasswordHistoryDO=userDAO.retrieveUserPasswordHistory(userdo.getUserId());
	        if (userdo == null)
	            throw new UsernameNotFoundException("No user found with the username - " + user.getUserName());

	        /* User Password History Data Object */
	        UserPasswordHistoryDO userHistoryDO = new UserPasswordHistoryDO();
	        userHistoryDO.setTbluser(userdo);
	        userHistoryDO.setComments(null);// no comment while keeping history of
	                                        // password
	        userHistoryDO.setCreatedUserId(userdo.getCreatedUserId());
	        userHistoryDO.setPasswordGUID(userdo.getPasswordGUID());
	        userHistoryDO.setIPAddress(CommonUtil.getIpAddress());
	       userHistoryDO.setLastUpdated(CommonUtil.getCurrentDate());
	        userHistoryDO.setPasswordSALT(userdo.getPasswordSALT());
	        userHistoryDO.setUserPassword(userdo.getUserPassword());
	        userHistoryDO.setUpdatedUserId(userdo.getUpdatedUserId());
	        if(userdo.getImagePassword()==1){
	        	userHistoryDO.setDateCreated(CommonUtil.getCurrentDate());
	        	
	        }
	        if(userdo.getImagePassword()==0){
	        	Date dateCreated=userPasswordHistoryDO.getDateCreated();
	        	logger.debug("@@@@@@@@@@@@@@@@@@   date created     :"+dateCreated);
	        	userHistoryDO.setDateCreated(dateCreated);
	        	
	        }
	        
	        
	        /* end */

	        /* new password details */
	      
	        String SALT = CryptoUtil.generateRandomPassword(40);
	        String GUID = CryptoUtil.generateRandomPassword(40);
	        String PASSWORD =CryptoUtil.encrypt(SALT + GUID, user.getPassword());

	        userdo.setImagePassword((byte) 1);
	        userdo.setUserPassword(PASSWORD);
	        userdo.setPasswordGUID(GUID); // encryption key
	        userdo.setPasswordSALT(SALT); // salt
	        userdo.setLastUpdated(CommonUtil.getCurrentDate());// current date
	 userdo.setTotalPasswordChangeWarnings(userdo.getTotalPasswordChangeWarnings()+ 1);
	        /* end */
	 //start imagePassword  IsChangePasswordAfterLogin()==1 
	 
	 userdo.setImagePassword((byte)0);
	 userdo.setLastPasswordChanged(CommonUtil.getCurrentDate());
	 
	 //end imagePassword
	 

	 logger.debug("*******************************************************************");
	        logger.debug(" ABOUT TO CHANGE PASSWORD ");
	 logger.debug("*******************************************************************");

	        userDAO.changePassword(userdo); // update existing password
	        userDAO.auditChangePassword(userHistoryDO); // insert new row in
	                                                    // password history table

	 logger.debug("*******************************************************************");
	        logger.debug(" PASSWORD CHANGED SUCCESSFULLY ");
	 logger.debug("*******************************************************************");
	    }



	@Override
    @Transactional
    public boolean isPasswordPrevoiuslySet(ChangeUserPasswordBean user) {

        // get all previous passwords
        List<UserPasswordHistoryDO> passwordHistoryList = userDAO
                .findAllPreviousPasswordsOfUser(user.getUserName());

        for (UserPasswordHistoryDO pwdhistory : passwordHistoryList) {
            // set user password details for decryption
            UserDO udo = new UserDO();
            udo.setPasswordSALT(pwdhistory.getPasswordSALT());
            udo.setPasswordGUID(pwdhistory.getPasswordGUID());
            udo.setUserPassword(pwdhistory.getUserPassword());
            String decyPwd = this.decryptPasword(udo);
            udo = null;
            if (user.getPassword().equals(decyPwd)) {
                return true;
            }
        }
        return false;

    }


	 @Override
	    @Transactional
	    public boolean isCurrentPasswordInvalid(ChangeUserPasswordBean user) {

	        // get user data object by username
	        UserDO userdo = userDAO.retrieveUser(user.getUserName());

	        // decrypt password
	        String decyPwd = this.decryptPasword(userdo);


	        if (!decyPwd.equals(user.getOldPassword())) {
	            logger.debug("****** PASSWORD INVALID: ");
	            return true;
	        }

	        return false;
	    }


	@Override
	public boolean sendMail(String strToEmail, String strSubject,
			String strEmailBody, String[] strToCC) {
		 
		 try{
		        Properties mailServerProperties;
		        Session getMailSession;
		        MimeMessage generateMailMessage;
		        
		     
		        //Step1     
		        logger.debug("\n 1st ===> setup Mail Server Properties..");
		        mailServerProperties = System.getProperties();
		        mailServerProperties.put("mail.smtp.port", generalBean.getPort()); // TLS Port
		        mailServerProperties.put("mail.smtp.auth", "true"); // Enable Authentication
		        mailServerProperties.put("mail.smtp.starttls.enable", "true"); // Enable StartTLS
		        logger.debug("Mail Server Properties have been setup successfully..");
		 
		        //Step2     
		        logger.debug("\n\n 2nd ===> get Mail Session..");
		        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		        generateMailMessage = new MimeMessage(getMailSession);
		        try{
		        	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(strToEmail));
		        }catch(Exception e){
       			logger.error("unable to send mail to " + strToEmail + " exception is" + e);
       		}
		        InternetAddress ccAddresses[] = null;
		        if (strToCC != null){
		        	ccAddresses = new InternetAddress[strToCC.length];
		        	for(int i=0; i< strToCC.length; i++){
		        		try{
		        		ccAddresses[i] = new InternetAddress(strToCC[i]);
		        		generateMailMessage.addRecipient(Message.RecipientType.CC, ccAddresses[i]);
		        		}catch(Exception e){
		        			logger.error("unable to send mail to " + ccAddresses[i] + " exception is" + e);
		        		}
		        	} // for
			        //generateMailMessage.addRecipients(Message.RecipientType.CC, ccAddresses);
		        } // if

		        generateMailMessage.setSubject(strSubject);
		        generateMailMessage.setContent(strEmailBody, "text/html");
		 
		        //Step3     
		        logger.debug("\n\n 3rd ===> Get Session and Send mail");
		        Transport transport = getMailSession.getTransport("smtp");
		        // Enter your correct gmail UserID and Password
		        transport.connect(generalBean.getHost(), generalBean.getUsername(), generalBean.getPassword());
		        logger.debug("################  JUST BEFORE sending email ############");
		        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		        transport.close();

		        logger.debug("################  JUST AFTER sending email ############");
		 } catch(Exception e) {
				System.out.println("################  INSIDE EXCEPTION############");
			 e.printStackTrace();
			 return false;
		 } // try-catch
		 
		 return true;
	 } // sendMail
	 	 
	 
	
	



	

}
