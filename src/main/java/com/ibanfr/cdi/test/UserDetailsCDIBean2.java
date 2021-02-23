/**
 * 
 */
package com.ibanfr.cdi.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibanfr.hibernate.model.User;

/**
 * @author ivan
 *
 */
@Named
@ConversationScoped
public class UserDetailsCDIBean2 implements Serializable {
	
	

	/**
	 * Auto generated serialVersionUIDß
	 */
	private static final long serialVersionUID = -3227091326241413961L;

	private final static Logger logger = LoggerFactory.getLogger(UserDetailsCDIBean2.class);
	
	@Inject
	private Conversation conversation;
	
	/**
	 * The selected user
	 */
	private User selectedUser;
	
	/**
	 * 
	 */
	@PostConstruct
	public void postConstruct() {
		
		logger.debug("UserDetailsCDIBean postConstruct");
		
		selectedUser = (User) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("selectedUser");
		
		logger.debug("userId={}",FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("selectedUserId"));
		
		logger.debug("selectedUser={}", selectedUser);
		
		
	}
	
	public void init() {
		
		logger.debug("UserDetailsCDIBean init");
		if (conversation.isTransient()) {
			conversation.begin();
		}
		
	}
	

	/**
	 * @return the selectedUser
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * @param selectedUser the selectedUser to set
	 */
	public void setSelectedUser(User selectedUser) {
		logger.debug("setSelectedUser {}", selectedUser);
		this.selectedUser = selectedUser;
	}
	
	

}
