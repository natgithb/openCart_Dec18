package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage  extends BasePage {

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// Elements
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement txtaddress1;
	
	@FindBy(xpath="//input[@id='input-payment-address-2']")
	WebElement txtaddress2;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement txtcity;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement txtpin;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	WebElement drpCountry;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement drpState;
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement btncontinueBillingAddress;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement btncontinueDeliveryAddress;	
	
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement txtDeliveryMethod;
		
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement btncontinueShippingAddress;
		
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkboxTerms;
		
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement btncontinuePaymentMethod;
	
	//	@FindBy(xpath="//strong[text()='Total:']//following::td")
	@FindBy(xpath="//tfoot/tr[3]/td[contains(text(),'$')]")
	WebElement lblTotalPrice;
		
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btnConfOrder;
	
	//  //h1[normalize-space()='Your order has been placed!']
	//  //h1[text()='Your order has been placed!'] OR //h1
	@FindBy(xpath="//*[@id='content']/h1")
	WebElement lblOrderConMsg;
	
		
	// Methods
	
	public void setfirstName(String firstName) {
	txtfirstName.sendKeys(firstName);
	}
	
	public void setlastName(String lastName) {
		txtlastName.sendKeys(lastName);
	}
	
	public void setaddress1(String address1) {
		txtaddress1.sendKeys(address1);
	}
	
	public void setaddress2(String address2) {
		txtaddress2.sendKeys(address2);
	}
	
	public void setcity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void setpin(String pin) {
		txtpin.sendKeys(pin);
	}
	
	public void setCountry(String Country) {
		new Select(drpCountry).selectByVisibleText(Country);
	}
	
	public void setState(String State) {
		new Select(drpState).selectByVisibleText(State);
	}
	
	public void clickOnContinueAfterBillingAddress() //stuck
	{
		btncontinueBillingAddress.click();
	}
	
	public void clickOnContinueAfterDeliveryAddress()
	{
		btncontinueDeliveryAddress.click();
	}
	
	public void setDeliveryMethodComment(String deliverymsg)
	{
		txtDeliveryMethod.sendKeys(deliverymsg);		
	}
	
	public void clickOnContinueAfterDeliveryMethod()
	{
		btncontinueShippingAddress.click();
	}
	
	public void selectTermsAndConditions()
	{
		chkboxTerms.click();
	}
	
	public void clickOnContinueAfterPaymentMethod()
	{
		btncontinuePaymentMethod.click();
	}
	
	public String  getTotalPriceBeforeConfOrder()
	{
		return lblTotalPrice.getText(); //$207.00		
	}
	
	public void clickOnConfirmOrder() {
		
		//btnConfOrder.click();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click();", btnConfOrder);
	    
	}
	
	
 /*   public boolean isOrderPlaced() {
    	
   	 WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            wait.until(ExpectedConditions.visibilityOf(lblOrderConMsg));

            // Consider using more explicit waits instead of Thread.sleep
            Thread.sleep(2000);

            btnConfOrder.click();
            wait.until(ExpectedConditions.visibilityOf(lblOrderConMsg));

            return lblOrderConMsg.getText().equals("Your order has been placed!");
        } catch (Exception e) {
            return false;
        }
   
    
	public boolean isOrderPlaced() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", lblOrderConMsg);
            Thread.sleep(2000); // Use an explicit wait instead of Thread.sleep

            js.executeScript("arguments[0].click();", btnConfOrder);
            Thread.sleep(2000); // Use an explicit wait instead of Thread.sleep

            return lblOrderConMsg.getText().equals("Your order has been placed!");
        } catch (Exception e) {
            return false;
        }
    } }*/

    
	/*public boolean isOrderPlaced() {
		try {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	        wait.until(ExpectedConditions.visibilityOf(lblOrderConMsg));

	        
			Thread.sleep(2000);
			btnConfOrder.click();
			Thread.sleep(2000);
			
			if(lblOrderConMsg.getText().equals("Your order has"
					+ " been placed!")) {
				return true;
			}
			else {
				return false;			
			}			
		} 
		catch(Exception e) {
			return false;
		}
	}*/
	
// Class code	
	public boolean isOrderPlaced() throws InterruptedException
	{
		try
		{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		btnConfOrder.click();
		Thread.sleep(3000);
		if(lblOrderConMsg.getText().equals("Your order has been placed!"))
			return true;
		else
			return false;
		}catch(Exception e)
		{
			return false;
		}
		
	}
		
	public String isOrderPlaceds() {
			try {
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				btnConfOrder.click();
				Thread.sleep(2000);
				return(lblOrderConMsg.getText());
			} 
			catch(Exception e) {
				return(e.getMessage());
			}
	}
	
	
	
	
	

	
}
