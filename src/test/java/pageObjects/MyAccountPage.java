package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	//Constructor
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement lnkLogoutMacc;
	
	// Methods
	
	public boolean isMyAccountPageExist() {
		try {
			return(msgHeading.isDisplayed());
			
		}catch(Exception e) {
			return(false);
		}		
	}
	
	public void clickLogoutMyacc() {
		lnkLogoutMacc.click();
	}
}
