/**
 * 
 */
package com.ibanfr.test.stringscape;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;

import com.sun.faces.util.HtmlUtils;

/**
 * @author ivan
 *
 */
public class StringScapeUtils {

	
	
	/**
	 * 
	 */
	public StringScapeUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "<p>learner: Welcome to Arabica coffeeshop, we have the best coffee in the world. Which one&nbsp;can I serve you?</p>";
		System.out.println(StringEscapeUtils.escapeHtml4(s));
		System.out.println(StringEscapeUtils.escapeHtml3(s));
		System.out.println(StringEscapeUtils.unescapeHtml4(s));
		System.out.println(Jsoup.parse(s).text());
		
	}

}
