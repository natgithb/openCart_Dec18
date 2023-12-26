package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage 
{
	
	//Constructor
 public ShoppingCartPage(WebDriver driver) {
	 super(driver); 
 }
 
	// Elements
	
	// Action for SearchPage testing (TC004)

//	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	@FindBy(xpath="//div[@id='cart']")	
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")	
	WebElement lnkViewCart;
	
	@FindBy(xpath="//tr[4]//strong[contains(text(),'Total')]/following::td[27]")	
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//a[text()='Checkout']")	
	WebElement btnCheckout;
	
	
	
	// Methods
	
	public void clickItemsToNavigateToCart() {
		btnItems.click();
	}
	
	public void clickViewCart() {
		lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnCheckout);
	}



	
	

}
