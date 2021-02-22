/**
 * 
 */
package com.ibanfr.jsf.slider;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SlideEndEvent;

/**
 * @author ivan
 *
 */
@ManagedBean
@SessionScoped
public class SliderTestBean {

	private Integer sliderValue;

	/**
	 * @return the sliderValue
	 */
	public Integer getSliderValue() {
		return sliderValue;
	}

	/**
	 * @param sliderValue the sliderValue to set
	 */
	public void setSliderValue(Integer sliderValue) {
		this.sliderValue = sliderValue;
	}
	
	public void onSlideEnd(SlideEndEvent event) {
		int value = (int) event.getValue();
		//add faces message
		FacesMessage msg = new FacesMessage("OnSlideEventEn", "OnSlideEventEn value "+value);  
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
}
