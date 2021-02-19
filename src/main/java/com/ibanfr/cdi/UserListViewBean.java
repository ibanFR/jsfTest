/**
 * 
 */
package com.ibanfr.cdi;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * {@link ViewScoped} Bean to present a master {@link User} list.
 * <p>
 *     
 * Contains getters and setters and processes events for components used in
 * <code>userListViewxhtml</code> page.
 * 
 *
 * @author ivan
 */
@Named
@ViewScoped
public class UserListViewBean implements Serializable{

	/**
	 * SFL4J Logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserListViewBean.class);

	/**
	 * The list of system users.
	 */
	private List<User> users;


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * Bean initialization method.
	 * <p>
	 * Load the list of system users.
	 *
	 */
	@PostConstruct
	public void postConstruct() {
		logger.debug("userListViewBean init");
		findUsers();
	}
	
	/**
	 * Look-up method to load the list of system users from db.
	 */
	private void findUsers() {
		try {

			UserManager manager = new UserManager();
			setUsers(manager.listAllUsers());
				
		}catch(Exception e) {
			logger.error("There was an error retrieving the users", e);
		}
	}

}
