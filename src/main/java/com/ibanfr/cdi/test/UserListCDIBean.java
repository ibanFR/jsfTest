/**
 * 
 */
package com.ibanfr.cdi.test;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager;
import com.ibanfr.user.UserListBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author ivan
 *
 */
@Named
@ViewScoped
public class UserListCDIBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1934487392821003991L;

	private static final Logger logger = LoggerFactory.getLogger(UserListBean.class);
	
	private List<User> users;
	
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
		
		logger.debug("UserListCDIBean init");
		
		findUsers();
		
	}

	/**
	 * Look-up method to find users.
	 * <p>
	 * List all users from db.
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
	 * Edit given {@link User}.
	 * <p>
	 * Set selected <code>User</code> in request parameter map.
	 * <p>
	 * Redirect to <code>userDetail.xhtml</code>.
	 *
	 * @param u <code>User</code> to edit.
	 *
	 * @return Navigation outcome.
	 */
	public String editUser(User u) {
		
		logger.debug("edit user={}", u);
		
		setSelectedUser(u);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("selectedUser", u);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("selectedUserId", u.getUserId());
		
		return "userDetail2?faces-redirect=true";
	}

}
