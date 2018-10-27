package by.eisgroup.gmail.pages;

import java.util.concurrent.TimeUnit;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends AbstractPage {

	@FindBy(xpath = "//*[@id='gb']/div[2]/div[3]/div/div[2]/div/a/span")
	private WebElement account;

	@FindBy(xpath = "//*[@id='gb']/div[2]/div[6]/div[1]/div/div[2]")
	private WebElement authorizedEmail;

	@FindBy(xpath = "//*[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement writeButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement recieverField;

	@FindBy(xpath = "//input[@name='subjectbox']" )
	private WebElement themeField;

	@FindBy(xpath = "//*[@class='Am Al editable LW-avf']")
	private WebElement messageField;

	@FindBy(xpath="//*[contains(@class,'aoO')]")
	private WebElement sendButton;

	@FindBy(xpath= "//*[@class='bAq']")
	private WebElement infoTable;
	
	@FindBy(xpath= "//*[@class='oZ-x3 xY']")
	private WebElement firstIncomingLetter;
	
	@FindBy(xpath = "//div[contains(@class,'nX')]/div")
	private WebElement deleteButton;

	public MailPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException("Only for authorized users");
	}

	public WebElement checkUserAuthorized() {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		account.click();
		return authorizedEmail; 
	}

	public void createNewLetter() {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		writeButton.click();
	}

	public void fillingLetter(String address, String theme, String message) {
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		recieverField.sendKeys(address);
		recieverField.sendKeys(Keys.ENTER);
		themeField.sendKeys(theme);
		messageField.sendKeys(message);
	}

	public void submitLetterSending() {
		
		sendButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement getLetterSendingInfo() {	
		return infoTable;
	}

	public void deleteLetter() {
		deleteButton.click();
	}

	public void tickLetter() {	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		firstIncomingLetter.click();
	}
	
	public WebElement getLetterRemoveInfo() {
		return infoTable;	
	}

	
}
