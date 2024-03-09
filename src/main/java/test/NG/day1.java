package test.NG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {
	@Test
	public  void Demo() {
		System.out.println("Hello");

	}
	@Test(groups={"Smoke"})
	public void Secondtest() {
		System.out.println("Bye");
	}
	@AfterTest
	public void lastexecute() {
	System.out.println("I Will Execute Last");	
	}

	@AfterSuite
	public void afsuite() {
		System.out.println(" I am the  no 1 from last ");
	}
}
