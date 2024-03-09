package test.NG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@Test
	public void Weblogincarloan() {
	System.out.println("Webloginloan");	
	}
	@Test
	@Parameters("URL")
	public void Mobilelogincarloan(String urlname) {
		System.out.println("Mobileloginloan");
		System.out.println(urlname);
	}
	@BeforeSuite(groups={"Smoke"})
	public void bfsuite() {
		System.out.println("I am No 1");
	}
	@Test(dependsOnMethods={"Mobilelogincarloan","Weblogincarloan"})
	public void APIcarLoan() {
		System.out.println("LoginAPIcar");
	}
	@BeforeTest
	public void prerequiste() {
		System.out.println("I Will execute first");
	}
	
	
	

}
