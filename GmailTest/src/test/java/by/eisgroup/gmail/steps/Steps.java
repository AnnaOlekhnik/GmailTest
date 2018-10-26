package by.eisgroup.gmail.steps;

import org.openqa.selenium.WebDriver;

import by.eisgroup.gmail.pages.LoginPage;
import by.eisgroup.gmail.pages.MailPage;

public class Steps {

	private WebDriver driver;
	private LoginPage loginPage;
	private MailPage mailPage;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}

	public MailPage authorize(String mailName, String password) {

		loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.setUserData(mailName, password);
		mailPage = new MailPage(driver);
		
		return mailPage;
	}

	public String verifyAuthorization() {
		
		mailPage = new MailPage(driver);  
		String email = mailPage.checkUserAuthorized().getText();
		
		return email;
	}

	public void sendLetter(String address, String theme, String message) {
		
		MailPage mailPage = new MailPage(driver);
		mailPage.createNewLetter();
		mailPage.fillingLetter(address, theme, message);
		mailPage.submitLetterSending();
	}

	public String verifyLetterWasSent() {
		
		MailPage mailPage = new MailPage(driver);
		String sendingInfo = mailPage.getLetterSendingInfo().getText();
		
		return sendingInfo;
	}

	public void removeLetter() {
	
		MailPage mailPage = new MailPage(driver);
		mailPage.tickLetter();
		mailPage.deleteLetter();
		
	}

	public String verifyLetterWasRemoved() {

		MailPage mailPage = new MailPage(driver);
		String removalInfo = mailPage.getLetterRemoveInfo().getText();
		return removalInfo;
	}
	
	
	
}
