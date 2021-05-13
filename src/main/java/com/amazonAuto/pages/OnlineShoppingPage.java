package com.amazonAuto.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OnlineShoppingPage {
	WebDriver driver;
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchField;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchIcon;

	@FindBy(id = "add-to-cart-button")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[contains(text(),'Proceed to Buy')]")
	private WebElement proceedToBuy;
	
	@FindBy(xpath = "//a[contains(text(),'Deliver to this address')]")
	private WebElement deliveryAddress;
	
	@FindBy(xpath = "//input[@value='Continue' and @class='a-button-text']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//span[text()='Net Banking' and contains(@class,'bold')]/../../../..")
	private WebElement netbankingPayment;
	
	@FindBy(xpath = "//span[text()='EMI' and contains(@class,'bold')]/../../../..")
	private WebElement EMIPayment;
	
	@FindBy(id = "nav-cart-count")
	private WebElement cartPage;
	
	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	private WebElement deleteFirstFrmCart;
	
	@FindBy(id="productTitle")
	private WebElement productSelected;
	
	public OnlineShoppingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String searchKey) {
		searchField.clear();
		searchField.sendKeys(searchKey);
		searchIcon.click();
	}
	
	public void clickOnItem(String item) {
		WebElement elementToClick=driver.findElement(By.xpath("//*[contains(text(),'"+item+"')]/parent::a"));
		elementToClick.click();
	}
	
	public void addItemToCart(String item){
		Set<String> allPages=driver.getWindowHandles();
		System.out.println(allPages);
		Iterator<String> i = allPages.iterator();
        while (i.hasNext()){
        	String child=i.next();
        	driver.switchTo().window(child);
        	if(driver.getTitle().contains(item)){
        		System.out.println(driver.getTitle());
        		break;
        	}
    	}
        Assert.assertTrue(productSelected.getText().contains(item), productSelected.getText()+" dosn't contain "+item);
		addToCart.click();
		proceedToBuy.click();
	}
	
	public void selectAddress(){
		deliveryAddress.click();
		continueBtn.click();
	}
	
	public void selectPaymentType(String type){
		WebElement elementToClick=driver.findElement(By.xpath("//span[text()='"+type+"' and contains(@class,'bold')]/../../../..//input[@name='ppw-instrumentRowSelection']"));
		elementToClick.click();
	}
	
	public void goToCart(){
		cartPage.click();
	}
	
	public void delete1stItem(){
		deleteFirstFrmCart.click();
	}
	
}
