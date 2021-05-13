package com.amazonAuto.tests;

import org.testng.annotations.Test;

import com.amazonAuto.pages.LoginPage;
import com.amazonAuto.pages.OnlineShoppingPage;
import com.amazonAuto.utilities.ConfigPropLoader;
import com.amazonAuto.utilities.Utilities;


public class AmazonTest extends BaseTest {
	@Test
	public void test() throws InterruptedException {
		com.amazonAuto.pages.LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigPropLoader.username, ConfigPropLoader.password);

		OnlineShoppingPage oSP = new OnlineShoppingPage(driver);
		oSP.searchItem("Zebronics ZEB-KM2100 Multimedia USB Keyboard Comes with");
		oSP.clickOnItem("Zebronics ZEB-KM2100 Multimedia USB Keyboard Comes with");
		oSP.addItemToCart("Zebronics ZEB-KM2100 Multimedia USB Keyboard Comes with 114 Keys Including 12 Dedicated Multimedia Keys");
		oSP.selectAddress();
		oSP.selectPaymentType("Other UPI Apps");
		
		Utilities utilities =new Utilities(driver);
		utilities.goBack();
		utilities.goBack();
		utilities.goBack();
		oSP.goToCart();
		oSP.delete1stItem();
	}
}
