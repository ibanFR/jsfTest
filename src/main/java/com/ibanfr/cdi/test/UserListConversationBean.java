/**
 * 
 */
package com.ibanfr.cdi.test;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Test class number 3.
 *
 * Testing ConversationScoped on the master page.
 *
 * @author ivan
 *
 */
@Named
@ConversationScoped
public class UserListConversationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1934487392821003991L;

	private static final Logger logger = LoggerFactory.getLogger(UserListConversationBean.class);


	@Inject
	private Conversation conversation;

	/**
	 *
	 */
	private List<User> users;

	/**
	 * Selected User instance.
	 */
	private User selectedUser;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
		this.selectedUser = selectedUser;
	}

	@PostConstruct
	public void init() {
		
		logger.debug("UserListConversationBean init");
		
		findUsers();
	}
	
	/**
	 * Look-up method to find users.	
	 */
	private void findUsers() {
		try {

			UserManager manager = new UserManager();
			setUsers(manager.listAllUsers());
				
		}catch(Exception e) {
			logger.error("There was an error retrieving the users", e);
		}
	}

	/**
	 * Action method to create user.<p>
	 *
	 * Set selected user with new {@link User} instance.<p>
	 *
	 * Start conversation.
	 *
	 * @return Navigation outcome.
	 */
	public String createUser(){

		logger.debug("createUser");

		startConversation();
		setSelectedUser(new User());

		return "userDetailView?faces-redirect=true";
	}

	/**
	 * Edit selected User instance.
	 *
	 * @param u {@link User} instance to edit.
	 * @return Navigation to redirect to.
	 */
	public String editUser(User u) {
		
		logger.debug("edit user={}", u);

		startConversation();
		setSelectedUser(u);

		return "userDetailView?faces-redirect=true";
	}

	/**
	 * Initialize conversation.
	 */
	public void startConversation(){
		if (conversation.isTransient()) {
			logger.debug("UserListConversationBean initConversation");
			conversation.begin();
		}
	}

	/**
	 * End conversation.
	 *
	 * @return
	 */
	public void endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}
}
