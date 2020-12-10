package com.sample.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sample.pages.GmailPage;
import com.sample.utils.Constant;
import com.sample.utils.TestDataset;

public class GmailLoginTest extends GmailPage{

	private GmailPage pageObj;;
	
	@BeforeClass
	public void initialization() {
		
		TestDataset.setTestDataFilePath(Constant.SAMPLE_DATA);
		
		pageObj = new GmailPage();
	}
	
	@Test
	public void validateLoginPage() throws IOException {
		
		pageObj.loginToPage(getProperties().getProperty("user"), getProperties().getProperty("password"));
	}
	
	@Test(dataProvider = "testData", dataProviderClass = TestDataset.class, priority = 1)
	public void validateLoginPageDataProvider(Map<String, String> dataObj) throws IOException {
		
		pageObj.loginToPage(dataObj);
		validatePage();
	}
	
}
