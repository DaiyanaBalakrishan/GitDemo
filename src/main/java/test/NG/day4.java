package test.NG;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {

	@Test(timeOut=4000)
	public void Webloginhomeloan() {
		System.out.println("Webloginhomeloan");
	}
	@BeforeMethod
	public void beforeevery() {
		System.out.println(" I Will execute before every test method in the day 3 class");
	}
	
	@Test(enabled=false)
	public void Mobileloginhomeloan() {
		System.out.println("Mobileloginhomeloan");
	}
	@Test
	@Parameters("URL")
	public void LoginAPIhomeloan(String uname) {
		System.out.println("LoginAPIhomeloan");
		System.out.println(uname);
	}
	@Test
	public void APIhomeloan() {
		System.out.println("LoginAPIhomeloan");
	}
	@AfterMethod
	public void afterevery() {
		System.out.println(" I Will execute After every test method in the day 3 class");
	}
}
