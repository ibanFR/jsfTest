package com.ibanfr.jsf.enums;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="actionEnumsBean")
@SessionScoped
public class ActionEnumsBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DashboardsEnum dashboard;

	@PostConstruct
	private void postConstruct(){
		dashboard=DashboardsEnum.DECISIONS_OVERVIEW;
		name="Enums example";
	}

	public ActionEnumsBean() {
		super();
	}

	private String name;

	
	public DashboardsEnum[] getDashboards(){
		return DashboardsEnum.values();
	}
	
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

	/**
	 * @return the dashboard
	 */
	public DashboardsEnum getDashboard() {
		return dashboard;
	}

	/**
	 * @param dashboard the dashboard to set
	 */
	public void setDashboard(DashboardsEnum dashboard) {
		this.dashboard = dashboard;
	}
	
	

}
