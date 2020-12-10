package com.sample.tools;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverSelection {

	public WebDriver getDriver(WebDriver driver, String url) {
		
		if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
			System.setProperty("webdriver.chrome.driver", "Browsers\\Chrome\\chromedriver_win.exe");
	    	}else if(System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0 || System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0 || System.getProperty("os.name").toLowerCase().indexOf("aix") > 0) {
	    		System.setProperty("webdriver.chrome.driver", "Browsers/Chrome/chromedriver");
	    	}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public WebDriver getRemoteDriver(WebDriver driver, String url, String browser, String remoteurl)
			throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}


}
