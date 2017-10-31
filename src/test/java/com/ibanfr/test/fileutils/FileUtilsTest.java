package com.ibanfr.test.fileutils;




import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.Test;

public class FileUtilsTest {
	
	private String baseUrl = "/usr/local/etu_sims/";
	
	@Test
	public void testCopyDirectoryNoXml() {
		
		String oldSim = "Sim48";
		String newSim = "Sim49";
		
		File srcDir = new File(baseUrl+oldSim);
		File destDir = new File(baseUrl+newSim);
		
		IOFileFilter xmlSuffixfilter = FileFilterUtils.suffixFileFilter(".xml");
		FileFilter filter = FileFilterUtils.notFileFilter(xmlSuffixfilter);
		try {
			FileUtils.copyDirectory(srcDir, destDir, filter);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	@Test
	public void testCopyDirectoryOnlyResources() {
		String oldSim = "Sim48";
		String newSim = "Sim49";
		
		File srcDir = new File(baseUrl+oldSim);
		File destDir = new File(baseUrl+newSim);
		
//		IOFileFilter xmlSuffixfilter = FileFilterUtils.prefixFileFilter("fs");
		FileFilter filter = FileFilterUtils.prefixFileFilter("fs");
		
		try {
			FileUtils.copyDirectory(srcDir, destDir, filter);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	@Test
	public void testCopyDirectoryOnlyMedia() {
		String oldSim = "Sim48";
		String newSim = "Sim56";
		

		File srcDir = new File(baseUrl+oldSim);
		File destDir = new File(baseUrl+newSim);
		
		
		IOFileFilter notXmlFilter = FileFilterUtils.notFileFilter(FileFilterUtils.suffixFileFilter(".xml"));
		IOFileFilter notFslFilter = FileFilterUtils.notFileFilter(FileFilterUtils.prefixFileFilter("fs"));
		
		FileFilter filter = FileFilterUtils.and(notXmlFilter, notFslFilter);
		
		try {
			FileUtils.copyDirectory(srcDir, destDir, filter);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

}
