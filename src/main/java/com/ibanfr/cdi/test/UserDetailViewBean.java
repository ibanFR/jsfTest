package com.ibanfr.cdi.test;

import com.ibanfr.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 *
 *
 *
 * @author ivan
 *
 */
@Named
@ViewScoped
public class UserDetailViewBean implements Serializable {


	private final static Logger logger = LoggerFactory.getLogger(UserDetailViewBean.class);

	@Inject
	private UserListConversationBean userListBean;

	/**
	 * New instance of UserManager?
	 */
//	@Inject
	private UserManager userManager;

    /**
     * Bean constructor.
     */
    public UserDetailViewBean() {
        userManager = new UserManager();
    }

    /**
	 * PostConstruct method.
	 */
	@PostConstruct
	public void postConstruct() {
		
		logger.debug("UserDetailViewBean postConstruct");
		logger.debug("selectedUser={}", userListBean.getSelectedUser());

	}

	/**
	 * Possible naming alternative to postConstruct method above.<p>
	 *
	 */
	public void init() {
		logger.debug("UserDetailViewBean init");
	}

	/**
	 * Save selectedUser.
	 *
	 */
	public void save(){

		logger.debug("save selectedUser={}", userListBean.getSelectedUser());
		//Save user
		userManager.saveOrUpdateUser(userListBean.getSelectedUser());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"User saved",
				"User successfully saved."));
	}

	/**
	 * Cancel edit operation and return to userList page.
	 * <p>
	 *
	 * End current conversation.<p>
	 *
	 *
	 * @return Navigation case.
	 */
	public String cancel(){
		logger.debug("UserDetailViewBean cancel");
		userListBean.endConversation();
		return "userListConversation?faces-redirect=true";
	}

	

}
