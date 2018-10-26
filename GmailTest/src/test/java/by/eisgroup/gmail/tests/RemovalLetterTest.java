package by.eisgroup.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovalLetterTest extends BaseTest {

	@Test
	public void test_UserCanRemoveIncomingLetter() {
		
		steps.authorize("annaolekhniktest@gmail.com", "1q_2w3e4r");
		steps.removeLetter();
		Assert.assertEquals(steps.verifyLetterWasRemoved(), "Цепочка помещена в корзину.");
	}

}
