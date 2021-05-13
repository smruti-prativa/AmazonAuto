package com.amazonAuto.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
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
	
	private Logger log=Logger.getLogger(OnlineShoppingPage.class);
	
	public OnlineShoppingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String searchKey) {
		searchField.clear();
		searchField.sendKeys(searchKey);
		searchIcon.click();
		log.info("Searched item: "+searchKey);
	}
	
	public void clickOnItem(String item) {
		WebElement elementToClick=driver.findElement(By.xpath("//*[contains(text(),'"+item+"')]/parent::a"));
		elementToClick.click();
		log.info("Clicked on item: "+item);
	}
	
	public void addItemToCart(String item){
		Set<String> allPages=driver.getWindowHandles();
		Iterator<String> i = allPages.iterator();
        while (i.hasNext()){
        	String child=i.next();
        	driver.switchTo().window(child);
        	if(driver.getTitle().contains(item)){
        		log.info("Page title: "+driver.getTitle());
        		break;
        	}
    	}
        Assert.assertTrue(productSelected.getText().contains(item), productSelected.getText()+" dosn't contain "+item);
		addToCart.click();
		log.info("Clicked on add to cart of item:"+item);
		proceedToBuy.click();
		log.info("Clicked on proceed to buy of item:"+item);
	}
	
	public void selectAddress(){
		deliveryAddress.click();
		log.info("Selected 1st delivery Address:");
		continueBtn.click();
		log.info("Clicked on continue button");
	}
	
	public void selectPaymentType(String type){
		WebElement elementToClick=driver.findElement(By.xpath("//span[text()='"+type+"' and contains(@class,'bold')]/../../../..//input[@name='ppw-instrumentRowSelection']"));
		elementToClick.click();
		log.info("Selected payment method type: "+type);
	}
	
	public void goToCart(){
		cartPage.click();
		log.info("Go to cart");
	}
	
	public void delete1stItem(){
		deleteFirstFrmCart.click();
		log.info("Deleted 1st item from the cart");
	}
	
}
