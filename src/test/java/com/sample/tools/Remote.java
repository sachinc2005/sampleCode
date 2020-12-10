package com.sample.tools;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remote implements DriverSelection {

	public WebDriver getDriver(WebDriver driver, String url) throws MalformedURLException {
		return null;
	}

	public WebDriver getRemoteDriver(WebDriver driver, String url, String browser, String remoteurl)
			throws MalformedURLException {

		DesiredCapabilities cap = null;

		try {
	
		
		
		if (browser.equalsIgnoreCase("firefox")) {
			cap = new DesiredCapabilities().firefox();
			driver = new RemoteWebDriver(new URL(remoteurl), cap);
			driver.get(url);
		}
		
		if (browser.equalsIgnoreCase("chrome")) {
			cap = new DesiredCapabilities().chrome();
			driver = new RemoteWebDriver(new URL(remoteurl), cap);
			driver.get(url);
		}
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		return driver;
	}

}
