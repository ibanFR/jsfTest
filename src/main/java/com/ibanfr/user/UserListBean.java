/**
 * 
 */
package com.ibanfr.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.ibanfr.hibernate.model.User;
import com.ibanfr.manager.UserManager5;


/**
 * @author ivan
 *
 */
@ManagedBean
@ViewScoped
public class UserListBean {
	
	private static final Logger logger = LoggerFactory.getLogger(UserListBean.class);
	
	private static Marker APPEND_IBANFR = MarkerFactory.getMarker("APPEND_IBANFR");
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@PostConstruct
	public void postConstruct() {
		
		logger.debug(APPEND_IBANFR, "Append some text to the log File");
		
		findUsers();
		
	}
	
	
	public void searchUsers() {
		findUsers();
	}
	
	
	
	private void findUsers() {
		try {

			UserManager5 manager = new UserManager5();
			setUsers(manager.listAllUsers());
				
		}catch(Exception e) {
			logger.error("There was an error retrieving the users", e);
		}
		
	}
	
	

}
