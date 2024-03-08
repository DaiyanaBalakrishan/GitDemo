package SeleniumFrameWork.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWork.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		//initiazation
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//WebElement userEmail=driver.findElement(By.id("userEmail"));
//	driver.findElement(By.id("userPassword"))
//pagefactory
@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement passwordEle;

@FindBy(id="login")
WebElement submit;

@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;

public ProductCatalogue loginApplication(String email,String password) {
	userEmail.sendKeys(email);
	passwordEle.sendKeys(password);
	submit.click();
	ProductCatalogue productsCatalogue=new ProductCatalogue(driver);
	return productsCatalogue;
}

public String getErrorValidation() {
	wairtForWebElementAppear(errorMessage);
	return errorMessage.getText();
	
}
public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");
}


}
