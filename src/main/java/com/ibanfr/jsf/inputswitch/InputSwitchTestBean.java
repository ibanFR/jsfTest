/**
 * 
 */
package com.ibanfr.jsf.inputswitch;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author ivan
 *
 */
@ManagedBean
@SessionScoped
public class InputSwitchTestBean {

	private Boolean value;

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
	
}
