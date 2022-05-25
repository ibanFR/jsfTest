/**
 * 
 */
package com.ibanfr.jsf.inplace;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibanfr.jsf.checkbox.CheckboxBean;

import java.io.Serializable;

/**
 * @author ivan
 *
 */
@ManagedBean
@ViewScoped
public class InplaceTestBean implements Serializable {

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


	/**
	 * valueChangeListener method is invoked during the end of the PROCESS_VALIDATIONS phase. At that moment,
	 * the submitted value is not been updated in the model yet. So you cannot get it by just accessing the bean
	 * property which is bound to the input component's value. You need to get it by ValueChangeEvent#getNewValue().
	 * The old value is by the way also available by ValueChangeEvent#getOldValue().
	 *
	 * @param event {@link ValueChangeEvent}
	 */
	public void inputChangedListener(ValueChangeEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		// ...

		logger.debug("inputChangedListener, oldValue={}, newValue={}, this.name={}", oldValue, newValue, name);

		//Set updated. flag on TrialSimModel class


	}


	/**
	 * Change event can set flag on TrialSimModelEntity
	 *
	 * @param event
	 */
	public void ajaxListener(AjaxBehaviorEvent event){


		logger.debug("ajax change event triggered, textContent={}", name);

		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("ajax change event triggered, name="+name));

	}

	public void cancelEvent(AjaxBehaviorEvent event){

		logger.debug("ajax cancel event triggered, textContent={}", name);


	}

	public void submitForm(){
		logger.debug("action triggered from different form, name={}", name);

	}

}
