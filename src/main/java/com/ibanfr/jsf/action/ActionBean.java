package com.ibanfr.jsf.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="actionBean")
@SessionScoped
public class ActionBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ActionBean() {
		super();
	}

	private String name;

	
	public void newName(){
		setName(new String());
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
