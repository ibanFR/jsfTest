/**
 * 
 */
package com.ibanfr.jsf.checkbox;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ivan
 *
 */
@ManagedBean
@SessionScoped
public class CheckboxBean {
	
	final static Logger logger = LoggerFactory.getLogger(CheckboxBean.class);
	
	private boolean value1;

	public CheckboxBean() {
		super();
		value1=false;
	}

	/**
	 * @return the value1
	 */
	public boolean isValue1() {
		return value1;
	}

	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(boolean value1) {
		this.value1 = value1;
	}
	
	public void checkValue() {
		logger.debug("Checkbox value: "+value1);		
	}
	

}
