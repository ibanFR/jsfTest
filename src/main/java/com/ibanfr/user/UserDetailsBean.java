package com.ibanfr.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager;

@ManagedBean
@ViewScoped
public class UserDetailsBean {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsBean.class);
	
	private Integer userId;
	
	private User user;
	
	private UserManager userManager;

	
	/**
	 * Bean Constructor.
	 * <p>
	 * 
	 */
	public UserDetailsBean() {
		userManager = new UserManager();
	}
	
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	

	/**
	 * Action method to find User by user identifier.
	 * <p>
	 * 
	 */
	public void findUserById() {
		logger.debug("userId={}", userId);
		setUser(userManager.findUserbyId(userId));
		
	}
	
	public void updateUser() {
		
		logger.debug("update User called");
	}

}
