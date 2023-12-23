package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistreationTest extends BaseClass
{
	
	@Test(groups= {"Regression","Master"})
	void test_account_registration() {
		
		logger.debug("application logs..."); // debug is for developers
		
		logger.info("***  Starting TC_test_account_Registeration"); // for testers
				
		try {				
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on myaccount link");

		
		hp.clickRegister();
		logger.info("Click on register link");

		
		AccountRegistrationPage repage=new 
				AccountRegistrationPage(driver);
	
		logger.info("Providing customres data");		
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"@gmail.com");
		repage.setTelephone(randomNumbers());
		// Parsing the same password
		String password= randomAlphaNumeric();
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		repage.setPrivacyPolicy();
		
		logger.info("Click on continue");
		repage.clickContinue();
		
		//Using Assertion to compare between message
		
		//1. msg doesn't match 
		//2. Tel not located 
		//TCs will failed and catch block will be 
		//throw an exception 

       logger.info("Vlaidate expected message");
		String confmsg=repage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has "
				+ "Been Created!");
		}
		
		catch(Exception e)
		{
		logger.error("Test Failed");

			Assert.fail();
		}
		
       logger.info("***  Finished TC_test_account_Registeration");

	}	
}
