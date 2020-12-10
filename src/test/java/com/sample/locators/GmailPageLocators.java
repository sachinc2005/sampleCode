package com.sample.locators;

import org.openqa.selenium.By;

import com.sample.services.TestBase;

public class GmailPageLocators extends TestBase{

	public By userName() {
		return By.id("identifierId");
	}

	public By nextButton() {
		return By.xpath("//div[@class='VfPpkd-RLmnJb']/..");
	}
	
	public By password() {
		return By.name("password");
	}
	
	
}
