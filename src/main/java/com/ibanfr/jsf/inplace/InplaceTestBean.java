/**
 * 
 */
package com.ibanfr.jsf.inplace;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibanfr.jsf.checkbox.CheckboxBean;

/**
 * @author ivan
 *
 */
@ManagedBean
@ViewScoped
public class InplaceTestBean {

	final static Logger logger = LoggerFactory.getLogger(InplaceTestBean.class);
	
	private boolean readOnlyMode = false;
	private String name = "";
	
	/**
	 * @return the readOnlyMode
	 */
	public boolean isReadOnlyMode() {
		return readOnlyMode;
	}

	/**
	 * @param readOnlyMode the readOnlyMode to set
	 */
	public void setReadOnlyMode(boolean readOnlyMode) {
		this.readOnlyMode = readOnlyMode;
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
	 * 
	 */
	public InplaceTestBean() {

	}
	
	public void handleSaveSectionNameEvent() {
		
		logger.debug("enter handleSaveSectionNameEvent");
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "save section", "save section detail message");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
