/**
 * 
 */
package com.ibanfr.test.stringutils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan
 *
 */
public class StringUtils {

	@Test
	public void testStringUtils1() {
		
		List<Integer> listIntegers = new ArrayList<>();
		listIntegers.add(1);
		listIntegers.add(3);
		System.out.println(org.apache.commons.lang3.StringUtils.join(listIntegers,","));
	}
	
	@Test
	public void testStringUtils2() {
		
		List<Integer> listIntegers = null;
		System.out.println(org.apache.commons.lang3.StringUtils.join(listIntegers,","));
	}
	
	@Test
	public void testStringFormat1() {
		
		List<Integer> listIntegers = null;
		System.out.println(String.format("this is a list of integers=%s", listIntegers));
	}
	
	@Test
	public void testStringFormat2() {
		
		List<Integer> listIntegers = new ArrayList<>();
		listIntegers.add(1);
		listIntegers.add(3);
		System.out.println(String.format("this is a list of integers=%s", listIntegers));
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listIntegers = new ArrayList<>();
		listIntegers.add(1);
		listIntegers.add(3);
		System.out.println(org.apache.commons.lang3.StringUtils.join(listIntegers,","));
	}

}
