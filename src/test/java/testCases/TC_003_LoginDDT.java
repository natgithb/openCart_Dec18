package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{


	HomePage hp;
	LoginPage lp;
	MyAccountPage mcc;
	
@Test(dataProvider="LoginData", 
dataProviderClass=DataProviders.class)
public void test_loginDDT(String email, 
		String password, String exp) {

	logger.info("***  Starting TC_003_LoginDDT  ***");
	
	try {
		
	hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	lp=new LoginPage(driver);	
	logger.info("****  Providing login details ");
	// Data coming from dp file
	lp.setEmail(email);
	lp.setPassword(password);
	lp.clickLogin();
	
	mcc=new MyAccountPage(driver);
	boolean targetpage= mcc.isMyAccountPageExist();
	
	if(exp.equals("Valid")) {
	
	if(targetpage==true) {
		
		mcc.clickLogoutMyacc();;
		Assert.assertTrue(true);		
	} else {
		Assert.fail();
		//Assert.assertTrue(false);		
	}
}
if(exp.equals("Invalid")) {
	
	if(targetpage==true) {
		
		mcc.clickLogoutMyacc();
		Assert.assertTrue(false);
		
	}else {
		Assert.assertTrue(true);		
			}
		}
	}
	
	catch(Exception e) {
		Assert.fail();
	}

logger.info("***  Finished  ***");
	
   }
}
