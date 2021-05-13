package com.amazonAuto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.amazonAuto.utilities.ConfigPropLoader;

public class BaseTest {
	public WebDriver driver;
	Logger log;
	@BeforeTest
	public void preConditions() throws IOException {
		ConfigPropLoader.mapPropertiesToConstants(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		BasicConfigurator.configure();
		log = Logger.getLogger(BaseTest.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties");
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get(ConfigPropLoader.url);
	    log.info("The base URL is:"+ConfigPropLoader.url);
	}
	
	@AfterTest
	public void postConditions() {
		driver.quit();
		log.info("Closing all the browsers");
	}
}
