/**
 * 
 */
package com.ibanfr.jsf.enums;

/**
 * @author ivan
 *
 */
public enum DashboardsEnum {
	
	SIMULATION_COMPLETIONS("simUsageStatsNew.jsf?faces-redirect=true","simCompletions"),
	DECISIONS_OVERVIEW("decisionsList.jsf?faces-redirect=true","decisonsOverview")
	;
	
	private String url;
	private String label;
	
	private DashboardsEnum(String url, String label) {
		this.url = url;
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
