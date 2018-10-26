package by.eisgroup.gmail.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import by.eisgroup.gmail.driver.DriverSingletone;
import by.eisgroup.gmail.steps.Steps;

public class BaseTest {
	
	protected WebDriver driver;
	protected Steps steps;
		
	@BeforeSuite
	public void setUpDriver() {
		
		driver = DriverSingletone.getDriver();
		steps = new Steps(driver);
	}

	@AfterSuite
	public void closeDriver() {
		DriverSingletone.closeDriver();
	}
	
	
}
