package by.eisgroup.gmail.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private static final String BASE_URL = "https://gmail.com";
	
	@FindBy(xpath="//*[@id='identifierId']")
	private WebElement mailAddressField;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	private WebElement nextButton;
	
	@FindBy(xpath=".//*[@id='password']//input[@name='password']")
	private WebElement passwordField;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void setUserData(String mailName, String password) {
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		mailAddressField.sendKeys(mailName);	
		nextButton.click();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		passwordField.sendKeys(password);
		nextButton.click();
	}

}
