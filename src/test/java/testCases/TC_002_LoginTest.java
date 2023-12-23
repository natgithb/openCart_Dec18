package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	HomePage hp;
	LoginPage lp;
	MyAccountPage mcc;
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
	 try {	
		logger.info("***  Starting TC_002_LoginTest"); // for testers
				
		hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
				
		mcc=new MyAccountPage(driver);
		boolean targetpage= mcc.isMyAccountPageExist();
		
		Assert.assertEquals(targetpage,true);
	 }
	    catch(Exception e) {
	    	Assert.fail();
		 
	    } 
	 
     logger.info("***  Finished TC_002_LoginTest");

	}
  }

