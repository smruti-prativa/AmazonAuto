package com.amazonAuto.utilities;

import org.openqa.selenium.WebDriver;

public class Utilities {

	WebDriver driver;
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goBack(){
		driver.navigate().back();
	}
	
}
