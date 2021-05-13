package com.amazonAuto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeTest
	public void preConditions() {
		
	WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		driver.manage().window().maximize();
        String baseUrl = "https://www.amazon.in/";
        driver.get(baseUrl);
	}
	
	@AfterTest
	public void postConditions() {
		//driver.close();
	}
}
