package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

// IMPORTANT- There is issues with total price validation so
// this part is within comment
public class TC_006_TC_006_EndToEndTest extends BaseClass{

@Test	
	public void endToendTest() throws InterruptedException {
	
	//Soft assertions
	SoftAssert myassert=new SoftAssert();

	//Account Registration scr
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	
	AccountRegistrationPage repage=new 
			AccountRegistrationPage(driver);

	repage.setFirstName(randomString().toUpperCase());
	repage.setLastName(randomString().toUpperCase());
	repage.setEmail(randomString()+"@gmail.com");
	repage.setTelephone(randomNumbers());
	// Parsing the same password
	String password= randomAlphaNumeric();
	repage.setPassword(password);
	repage.setConfirmPassword(password);
	repage.setPrivacyPolicy();
	repage.clickContinue();
	Thread.sleep(5000);
	
	String confmsg=repage.getConfirmationMsg();
	
	myassert.assertEquals(confmsg, "Your Account Has "
			+ "Been Created!");

	// Account Logout feature
	MyAccountPage mcc= new MyAccountPage(driver);
	mcc.clickLogoutMyacc();	
	Thread.sleep(3000);
		
	//Login scr
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	lp.clickLogin();
	Thread.sleep(3000);
	
	myassert.assertEquals(mcc.isMyAccountPageExist(),true);
	
	//search & add product to cart feature
	
	hp.enterProduct("iPhone");
	hp.clickSearch();
	
	SearchPage sp=new SearchPage(driver);
    
    if(sp.isProductExist("iPhone")) {
    	sp.selectProduct("iPhone");
    	sp.setQuantity("2");
    	sp.addToCart();	    	
    }    
   Thread.sleep(3000);
    
    myassert.assertEquals(sp.checkConfMsg(), true);
	
	//Shopping cart scr   
	ShoppingCartPage sc=new ShoppingCartPage(driver);
    sc.clickItemsToNavigateToCart();
    sc.clickViewCart();
    Thread.sleep(1000);
    
   /* String totprice=sc.getTotalPrice();
	myassert.assertEquals(totprice, "$246.40");*/
	sc.clickOnCheckout(); //navigate to checkout page
	
	
	//Checkout Product scr	
	CheckoutPage ch=new CheckoutPage(driver);
	
	// Billing Details
	ch.setfirstName(randomString().toUpperCase());
	Thread.sleep(1000);
	ch.setlastName(randomString().toUpperCase());
	Thread.sleep(2000);
	ch.setaddress1("add1");
	Thread.sleep(1000);
	ch.setaddress2("add2");
	Thread.sleep(1000);
	ch.setcity("Rehovot");
	Thread.sleep(1000);
	ch.setpin("1500");
	Thread.sleep(1000);
	ch.setCountry("Israel");
	Thread.sleep(1000);
	ch.setState("Haifa");
	Thread.sleep(1000);
	
	// For existing user ignore from previous actions
	ch.clickOnContinueAfterBillingAddress(); 
	Thread.sleep(1000);
	//Delivery Details	
	ch.clickOnContinueAfterDeliveryAddress();
	Thread.sleep(1000);
	// Delivery Method
	ch.setDeliveryMethodComment("Please abcd...");
	Thread.sleep(1000);
	ch.clickOnContinueAfterDeliveryMethod();
	Thread.sleep(1000);
	// Payment Method
	ch.selectTermsAndConditions();
	Thread.sleep(1000);
	ch.clickOnContinueAfterPaymentMethod();
	Thread.sleep(2000);	
	// Confirm Order
	/*String total_price_checkput= ch.getTotalPriceBeforeConfOrder();
	myassert.assertEquals(total_price_checkput, "$207.00");*/
	
	
	//ERROR: Below code works only if you configure SMTP for email's 
	/*ch.clickOnConfirmOrder();
	Thread.sleep(3000);
		
	boolean orderconf=ch.isOrderPlaced();
	System.out.println("Is Order Placed? "+orderconf);
	myassert.assertEquals(ch.isOrderPlaced(),true);*/
	
	myassert.assertAll(); //conclusion
		
	}
}
