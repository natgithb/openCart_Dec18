package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;



public class TC_004_SearchProduct extends BaseClass {
	@Test(groups= {"Master"})
	void test_search() {

		logger.info(" Starting TC_004_SearchProduct Test ");

		try {
		
		HomePage hp=new HomePage(driver);
		hp.enterProduct("mac");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
	    sp.isProductExist("mac");
	    
	    Assert.assertEquals(sp.isProductExist("mac"), true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info(" Finished TC_004_SearchProduct Test ");

	}
}
