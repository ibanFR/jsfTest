package com.ibanfr.cdi;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * {@link ConversationScoped} Bean to present a {@link User} detail.
 * <p>
 * Contains getters and setters and processes events for components used in
 * <code>userDetailConversation.xhtml</code> page.
 *
 * @author ivan
 */
@Named
@ConversationScoped
public class UserDetailConversationBean implements Serializable {

	/**
	 * Auto generated serialVersionUIDß
	 */
	private static final long serialVersionUID = -3227091326241413961L;

	/**
	 * SFL4J Logger.
	 */
	private final static Logger logger = LoggerFactory.getLogger(UserDetailConversationBean.class);

	/**
	 * The current {@link Conversation} context.
	 */
	@Inject
	private Conversation conversation;

	/**
	 * The selected {@link User}.
	 */
	private User selectedUser;

	/**
	 * {@link UserManager} instance.
	 */
	private UserManager userManager = new UserManager();

	/*Getters and setters*/

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	/*Actions*/

	/**
	 * Save the <code>selectedUser</code>.
	 * <p>
	 * Persist the selected {@link User} entity to db.
	 */
	public void save(){

		logger.debug("save selectedUser={}", selectedUser);
		//Save user
		userManager.saveOrUpdateUser(selectedUser);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"User saved",
				"User successfully saved."));
	}

	/**
	 * Cancel edit operation and return to userList page.
	 * <p>
	 * End current conversation.<p>
	 *
	 * @return Navigation outcome. Redirect to <code>userListView</code>
	 */
	public String cancel(){
		logger.debug("userDetailConversationBean cancel");
		endConversation();
		return "userListView?faces-redirect=true";
	}


	/**
	 * Action method to create user.<p>
	 *
	 * Set selected user with new {@link User} instance.<p>
	 *
	 * Start conversation.
	 *
	 * @return Navigation outcome. Redirect to userDetailConversation.
	 */
	public String createUser(){

		logger.debug("createUser");

		startConversation();
		selectedUser = new User();

		return "userDetailConversation?faces-redirect=true";
	}

	/**
	 * Edit given {@link User} instance.
	 *
	 * Start long-running conversation.
	 *
	 * @param u <code>User</code> instance to edit.
	 * @return Navigation outcome. Redirect to userDetailConversation.
	 */
	public String editUser(User u) {

		logger.debug("Edit user={}", u);

		startConversation();
		selectedUser = u;

		return "userDetailConversation?faces-redirect=true";
	}

	/**
	 * Start long-running <code>Conversation</code>.
	 */
	private void startConversation(){
		if (conversation.isTransient()) {
			logger.debug("userDetailConversationBean initConversation");
			conversation.begin();
		}
	}

	/**
	 * End current long-running <code>Conversation</code>.
	 */
	private void endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}


}
