package com.sample.pages;

import java.util.Map;

import com.sample.locators.GmailPageLocators;

public class GmailPage extends GmailPageLocators {

	public void loginToPage(String uName, String password) {

		$(userName()).sendKeys(uName);
		$(nextButton()).click();
		$(password()).sendKeys(password);
		validatePage();
	}

	public void loginToPage(Map<String, String> dataObj) {

		$(userName()).sendKeys(dataObj.get("userName"));
		$(nextButton()).click();
		$(password()).sendKeys(dataObj.get("passWord"));
		validatePage();

	}
}
