package com.sample.tools;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Firefox implements DriverSelection {
	
	public WebDriver getDriver(WebDriver driver, String url) {
		
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			System.setProperty("webdriver.gecko.driver", "Browsers\\Firefox\\geckodriver_win.exe");
		} else if (System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0
				|| System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0
				|| System.getProperty("os.name").toLowerCase().indexOf("aix") > 0) {
			System.setProperty("webdriver.gecko.driver", "Browsers/Firefox/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;

	}

	public WebDriver getRemoteDriver(WebDriver driver, String url, String browser, String remoteurl)
			throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}
}
