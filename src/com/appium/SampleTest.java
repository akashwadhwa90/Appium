package com.appium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SampleTest {
	private WebDriver driver;
	AppiumDriverLocalService service;

	/**
	 * Instantiates the {@link #driver} instance by using DesiredCapabilities which specify the
	 * 'iPhone Simulator' device and 'safari' app.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		File classPathRoot = new File(System.getProperty("user.dir"));

		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withLogFile(new File(new File(classPathRoot, File.separator + "log"), "iosLog.txt"))
				.withIPAddress("0.0.0.0").usingPort(4723)); 
		System.out.println("Starting Appium server"); 
		service.start(); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("deviceName", "iPad Air");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("UDID", "9789F981-B281-4146-A43D-1F8978A3D8FC");
		capabilities.setCapability("browserName", "safari");
		//driver = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver = new IOSDriver<WebElement>(service.getUrl(),capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	/**
	 * Navigates to http://saucelabs.com/test/guinea-pig and interacts with the browser.
	 *
	 * @throws Exception
	 */
	@Test
	public void runTest() throws Exception {
		driver.get("http://saucelabs.com/test/guinea-pig");
		Thread.sleep(1000);
		WebElement idElement = driver.findElement(By.id("i_am_an_id"));
		assertNotNull(idElement);
		assertEquals("I am a div", idElement.getText());
		WebElement commentElement = driver.findElement(By.id("comments"));
		assertNotNull(commentElement);
		commentElement.sendKeys("This is an awesome comment");
		WebElement submitElement = driver.findElement(By.id("submit"));
		assertNotNull(submitElement);
		submitElement.click();
		Thread.sleep(7000);
		WebElement yourCommentsElement = driver.findElement(By.id("your_comments"));
		assertNotNull(yourCommentsElement);
		assertTrue(driver.findElement(By.id("your_comments")).getText().contains("This is an awesome comment"));
		System.out.println(driver.getCurrentUrl());

	}

	@After
	public void teardown() throws Exception {
		driver.quit();
		service.stop();
	}

}
