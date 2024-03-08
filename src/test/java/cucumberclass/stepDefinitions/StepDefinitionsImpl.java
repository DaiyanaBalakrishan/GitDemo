package cucumberclass.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.TestComponent.BaseTest;
import SeleniumFrameWork.pageObjects.CartPage;
import SeleniumFrameWork.pageObjects.ChechoutPage;
import SeleniumFrameWork.pageObjects.ConfirmationPage;
import SeleniumFrameWork.pageObjects.LandingPage;
import SeleniumFrameWork.pageObjects.ProductCatalogue;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productsCatalogue;
	public ConfirmationPage confirmationPage;
@Given("I landed on Ecommerce Page")
public void I_landed_on_Ecommerce_Page() throws IOException
{
	landingPage=launchApplication();
	
}
@Given("^Logged in with username(.+) and password (.+)$")
public void  logged_in_username_and_password(String username,String password)
{
	productsCatalogue= landingPage.loginApplication(username,password);
}
@When("I add product {string} to cart")
public void i_add_product_to_cart(String productName) throws  InterruptedException
{
	System.out.println(productName);
	List<WebElement> products = productsCatalogue.getProductList();
	productsCatalogue.addProductToCart(productName);
	
}
@When("^Checkout (.+) and submit the order$")
public void checkout_submit_order(String productName)
{
	CartPage cartPage = productsCatalogue.goToCartPage();

	Boolean match = cartPage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
	ChechoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("india");
	confirmationPage= checkoutPage.submitOrder();
}
//@Then("{string} message is dispalyed on ConfirmationPage")
//public void message_dispalyed_confirmationPage(String string)
//{
//	String confirmMessage = confirmationPage.getConfirmationMessage();
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
//	driver.close();
	//System.out.println(confirmMessage);	


//@When("I add product \"(.*)\" to cart")
//public void i_add_product_zara_coat_to_cart(String productName) throws InterruptedException {
//    List<WebElement> products = productsCatalogue.getProductList();
//	productsCatalogue.addProductToCart(productName);
//}
@Then("{string} message is displayed on ConfirmationPage")
public void message_is_displayed_on_confirmation_page(String string) {
	String confirmMessage = confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	driver.close();
}

@Then("^\"([^\"]*)\" message is displayed$")
public void something_message_is_displayed(String strArg1) throws Throwable{
	Assert.assertEquals(strArg1, landingPage.getErrorValidation());
	driver.close();
}
}