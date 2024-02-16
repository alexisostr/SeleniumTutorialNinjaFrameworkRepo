package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver; 
	
	@FindBy(id="input-email")
	WebElement email_field;
	@FindBy(id="input-password")
	WebElement password_field;
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_button;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(this.driver, this);
	}
	
	// ***Business logic
	public void enterEmailAddress(String email) {
		email_field.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		password_field.sendKeys(password);
	}
	
	public void clickLoginButton() {
		login_button.click();
	}
	
	public void loginToMyAccount(String email, String password) {
		enterEmailAddress(email);
		enterPassword(password);
		clickLoginButton();
	}
}
