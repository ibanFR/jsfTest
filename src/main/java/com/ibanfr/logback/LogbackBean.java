package com.ibanfr.logback;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author ivan
 *
 */
@ManagedBean
@SessionScoped
public class LogbackBean {

	private static final Logger logger = LoggerFactory.getLogger(LogbackBean.class);
	private static Marker APPEND_IBANFR = MarkerFactory.getMarker("APPEND_IBANFR");
	
	private String message = "";
	
	public void addMessageToMarker() {
		logger.debug("Enter addMessageToMarker");
		logger.debug(APPEND_IBANFR, getMessage());
		logger.error("Added ERROR log");
		logger.debug("Exit addMessageToMarker");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@PostConstruct
	public void postConstruct() {
		logger.debug("Post Construct LogbackBean");
	}
}
