/**
 * 
 */
package com.ibanfr.test.stringutils;

import java.util.List;


import com.google.common.collect.Lists;

/**
 * @author ivan
 *
 */
public class StringUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listIntegers = Lists.newArrayList();
		listIntegers.add(1);
		listIntegers.add(3);
		System.out.println(org.apache.commons.lang3.StringUtils.join(listIntegers,","));
	}

}
