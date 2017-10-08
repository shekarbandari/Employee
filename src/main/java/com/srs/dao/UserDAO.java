package com.srs.dao;

import java.util.List;

import com.srs.model.UserDO;
import com.srs.model.UserPasswordHistoryDO;

/**
 * @author SHEKAR BANDARI
 *
 */

public interface UserDAO {

	UserDO retrieveUser(String username);
	void auditChangePassword(UserPasswordHistoryDO userPasswordHistory);
	void changePassword(UserDO userDO);
    List<UserPasswordHistoryDO> findAllPreviousPasswordsOfUser(String userName);
	UserPasswordHistoryDO retrieveUserPasswordHistory(long userId);

}
