package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;


public class TC_004_SearchProduct extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	void test_search()  throws InterruptedException{

		logger.info(" Starting TC_004_SearchProduct Test ");

		try {
		
		HomePage hp=new HomePage(driver);
		hp.enterProduct("MacBook");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
	    sp.isProductExist("MacBook");
	    
	    Assert.assertEquals(sp.isProductExist("MacBook"), true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info(" Finished TC_004_SearchProduct Test ");

	}
}
