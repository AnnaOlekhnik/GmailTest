package by.eisgroup.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovalLetterTest extends BaseTest {

	@Test
	public void test_UserCanRemoveIncomingLetter() {
		
		steps.authorize("annaolekhniktest@gmail.com", "1q_2w3e4r");
		steps.removeLetter();
		String actualResult = steps.verifyLetterWasRemoved();
		Assert.assertEquals(actualResult, "Conversation moved to Trash.");
	}

}
