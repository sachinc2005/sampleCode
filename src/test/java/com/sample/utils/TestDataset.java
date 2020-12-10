package com.sample.utils;

import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestDataset {
	
	static String fName;
	Map<String, String> data;
	DataParsingService generateDataObj;
	public static void setTestDataFilePath(String filePath) {
		fName = filePath;
	}
	
	public  Map<String, String> getTestData(String name) {

		generateDataObj = new DataParsingService(fName);
		data = generateDataObj.dataFilter(name);
		return data;
	}
	
	@DataProvider(name="testData")
	public  Object[][] testSampleData(){
		
		return new Object[][] {
			
			{getTestData("testData")}
		};
	}
	

}
