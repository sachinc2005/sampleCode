package com.sample.services;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sample.locators.CommonLocators;
import com.sample.tools.DriverFactory;
import com.sample.tools.DriverSelection;
import com.sample.utils.Constant;

public class TestBase extends CommonLocators{

		protected static WebDriver driver;
		Properties prop;
		DriverFactory df = new DriverFactory();

		@Parameters({ "browser" })
		@BeforeClass
		public void testInit(@Optional() String browser) throws IOException {

			String type = getProperties().getProperty("remote");
			String parallel = getProperties().getProperty("parallel");

			if (parallel.equals("yes")) {

				launchBrowser("remote", getProperties().getProperty("server"), browser,
						getProperties().getProperty("remoteURL"));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			}

			if (parallel.equals("no") && type.equals("yes")) {

				launchBrowser("remote", getProperties().getProperty("server"), getProperties().getProperty("browser"),
						getProperties().getProperty("remoteURL"));

			} else if (parallel.equals("no") && type.equals("no")) {

				launchBrowser(getProperties().getProperty("browser"), getProperties().getProperty("server"));

			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		private void launchBrowser(String browser, String Url) throws MalformedURLException {

			DriverSelection ds = df.getDriver(browser);
			driver = ds.getDriver(driver, Url);
		}

		public void launchBrowser(String type, String Url, String browser, String remoteUrl)
				throws MalformedURLException {

			DriverSelection ds = df.getDriver(type);
			driver = ds.getRemoteDriver(driver, Url, browser, remoteUrl);
		}

		public Properties readPropertiesFile(String fileName) throws IOException {
			FileInputStream fis = null;
			Properties prop = null;
			try {
				fis = new FileInputStream(fileName);
				prop = new Properties();
				prop.load(fis);
			} catch (IOException fnf) {
				fnf.printStackTrace();
			} finally {
				fis.close();
			}
			return prop;
		}

		@AfterClass
		public void closeDriver() {

			driver.close();

		}
		
		public WebElement $(By element) {

			waitForElement(element);
			return driver.findElement(element);
		}

		public java.util.List<WebElement> $$(By element) {

			waitForElement(element);
			return driver.findElements(element);
		}
		
		public boolean waitForElement(By path) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			boolean status;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(path));

			if (element.isDisplayed())
				status = true;
			else
				status = false;
			return status;
		}
		
		public void validatePage() {
			
			boolean result = $(homePage()).isDisplayed();
			Assert.assertEquals(result, true);
			
		}

		public Properties getProperties() throws IOException {

			prop = readPropertiesFile(Constant.TEST_PROPERTIES);

			return prop;
		}
	}

