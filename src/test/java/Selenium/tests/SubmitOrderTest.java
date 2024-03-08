package Selenium.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.TestComponent.BaseTest;
import SeleniumFrameWork.pageObjects.CartPage;
import SeleniumFrameWork.pageObjects.ChechoutPage;
import SeleniumFrameWork.pageObjects.ConfirmationPage;
import SeleniumFrameWork.pageObjects.LandingPage;
import SeleniumFrameWork.pageObjects.OrderPage;
import SeleniumFrameWork.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String,String> input)
			throws IOException, InterruptedException {

		ProductCatalogue productsCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productsCatalogue.getProductList();
		productsCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productsCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		ChechoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirmMessage);
	}
	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistory() {
		ProductCatalogue productsCatalogue = landingPage.loginApplication("daiyana@gmail.com", "Daiy@73971");
		OrderPage orderPage = productsCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\data\\PurchaseOrder.Json");
 return new Object[][] { {data.get(0)},{data.get(1)} };

		

		//HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "daiyana@gmail.com");
//		map.put("password", "Daiy@73971");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","bala44@gmail.com");
//		map1.put("password", "Bala#8754");
//		map1.put("product", "IPHONE 13 PRO");
	}
	
}
