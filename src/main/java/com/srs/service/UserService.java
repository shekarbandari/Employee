package com.srs.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.srs.bean.ChangeUserPasswordBean;
import com.srs.model.UserDO;

/**
 * @author SHEKAR BANDARI
 *
 */

public interface UserService {

	String decryptPasword(UserDO user);

	UserDO retrieveUser(String username);

	void changePassword(ChangeUserPasswordBean changePasswordBean)
			throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException;

	boolean isPasswordPrevoiuslySet(ChangeUserPasswordBean user);

	boolean isCurrentPasswordInvalid(ChangeUserPasswordBean user);

	boolean sendMail(String strToEmail, String strSubject, String strEmailBody,
			String[] strToCC);

}
