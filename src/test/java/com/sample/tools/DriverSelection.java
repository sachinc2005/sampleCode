package com.sample.tools;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface DriverSelection {

	WebDriver getDriver(WebDriver driver, String url) throws MalformedURLException;

	WebDriver getRemoteDriver(WebDriver driver, String url, String browser, String remoteurl) throws MalformedURLException;

}

