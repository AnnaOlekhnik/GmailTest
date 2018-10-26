package by.eisgroup.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void test_UserCanLogIn() {

		steps.authorize("annaolekhniktest@gmail.com", "1q_2w3e4r");		
		String email = steps.verifyAuthorization();
		Assert.assertEquals(email, "annaolekhniktest@gmail.com");
	}
}
