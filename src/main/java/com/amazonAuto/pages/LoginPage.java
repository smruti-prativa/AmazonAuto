package com.amazonAuto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	private WebElement signIn;
	
	@FindBy(id="ap_email")
	private WebElement emailTb;
	
	@FindBy(id="continue")
	private WebElement continuebtn;
	
	@FindBy(id="ap_password")
	private WebElement passwordTb;
	
	@FindBy(id="signInSubmit")
	private WebElement siginbtn;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement afterLoginNameIcon;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email, String password) {
		signIn.click();
		emailTb.clear();
		emailTb.sendKeys(email);
		continuebtn.click();
		passwordTb.clear();
		passwordTb.sendKeys(password);
		siginbtn.click();
		Assert.assertEquals(afterLoginNameIcon.getText(), "Hello, Smruti","Logged in with wrong user");
	}

}
