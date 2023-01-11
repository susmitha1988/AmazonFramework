package com.amazon.customer.web.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AmazonWebBaseTest extends AmazonBasePage{
	
	private String drivertype="chrome";
	@BeforeMethod
	public void setup() {
		driver=BrowserFactory.getDriver(drivertype);
	}

	@AfterMethod
	public void clear() {
		driver.close();
	}
}
