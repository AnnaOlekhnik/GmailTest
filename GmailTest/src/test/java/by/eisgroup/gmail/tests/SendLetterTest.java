package by.eisgroup.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendLetterTest extends BaseTest {
	
	@Test
	public void test_UserCanSendLetter() {
		
		steps.authorize("annaolekhniktest@gmail.com", "1q_2w3e4r");
		steps.sendLetter("annaolekhniktest@gmail.com","Hello","Text of the message");
		String sendingInfo = steps.verifyLetterWasSent();
		Assert.assertEquals(sendingInfo, "Message sent.");
	}
}
