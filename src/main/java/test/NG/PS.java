package test.NG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	public void doThis() {
		System.out.println("I am Here");
	}
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run Me First");
	}
	@AfterMethod
	public void afterRun() {
		System.out.println("Run Me last");
	}

}
