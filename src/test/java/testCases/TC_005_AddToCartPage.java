package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPage extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	void test_search(){
		
		logger.info(" Starting TC_005_AddToCartPage Test ");
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProduct("iPhone");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		
	    if(sp.isProductExist("iPhone")) {
	    	sp.selectProduct("iPhone");
	    	sp.setQuantity("3");
	    	sp.addToCart();	    	
	    }
	    
	    Assert.assertEquals(sp.checkConfMsg(), true);
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info(" Finished TC_005_AddToCartPage Test ");

	}

}
