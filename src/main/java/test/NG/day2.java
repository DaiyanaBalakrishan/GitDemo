package test.NG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day2 {
	@Test(groups={"Smoke"})
	public void ploan() {
		System.out.println("Good");
	}
	@AfterClass
	public void afclass() {
		System.out.println("Afetr executing all methods in the class");
	}
	@BeforeClass
	public void Bfclass() {
		System.out.println("Before executing all methods in the class");
	}

}
