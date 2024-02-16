package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccoutDropMenu;
	@FindBy(linkText = "Login")
	WebElement loginLink;
	@FindBy(linkText = "Register")
	WebElement registerLink;
	@FindBy(css = "input[name='search']")
	WebElement searchTextField;
	@FindBy(css = "button[class='btn btn-default btn-lg']")
	WebElement searchButton;
	



	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// Business Logic
	
	public LoginPage navigateToLoginPage() {
		myAccoutDropMenu.click();
		loginLink.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccoutDropMenu.click();
		registerLink.click();
		return new RegisterPage(driver);
	}
	
	public  void enterDataInSearchTextField(String product) {
		searchTextField.sendKeys(product);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void searchProduct(String product) {
		enterDataInSearchTextField(product);
		clickSearchButton();
	}
	
}
