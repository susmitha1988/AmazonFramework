package com.amazon.customer.web.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class AmazonBasePage {
	protected WebDriver driver=null;
	public void connectingurl() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".\\ObjectRepository.properties");
		prop.load(file);
		
		driver.get(prop.getProperty("BASE_URL"));
		
	}
	
}
