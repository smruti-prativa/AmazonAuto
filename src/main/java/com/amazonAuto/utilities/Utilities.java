package com.amazonAuto.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Utilities {

	WebDriver driver;
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}
	private Logger log=Logger.getLogger(Utilities.class);
	public void goBack(){
		driver.navigate().back();
		log.info("Go to back page");
	}
	
}
