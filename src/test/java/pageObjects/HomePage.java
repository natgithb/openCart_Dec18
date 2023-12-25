package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//Constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	
	// MyAccount feature
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount ;	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister ;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin ;
	
	// Search feature
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
		
	// Methods
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void enterProduct(String pName) {
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	
}
