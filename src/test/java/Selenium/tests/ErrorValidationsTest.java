package Selenium.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.TestComponent.BaseTest;
import Selenium.TestComponent.Retry;
import SeleniumFrameWork.pageObjects.CartPage;
import SeleniumFrameWork.pageObjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" },retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		
		landingPage.loginApplication("daiyana@gmail.com", "Daiy@971");
		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorValidation());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String Productname = "ZARA COAT 3";
		ProductCatalogue productsCatalogue = landingPage.loginApplication("bala44@gmail.com", "Bala#8754");

		List<WebElement> products = productsCatalogue.getProductList();
		productsCatalogue.addProductToCart(Productname);
		CartPage cartPage = productsCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}
