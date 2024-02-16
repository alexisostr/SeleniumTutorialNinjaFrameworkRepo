package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id = "input-firstname")
	WebElement firstNameField;
	@FindBy(id = "input-lastname")
	WebElement lastNameField;
	@FindBy(id = "input-email")
	WebElement emailField;
	@FindBy(id = "input-telephone")
	WebElement phoneField;
	@FindBy(id = "input-password")
	WebElement passwordField;
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordField;
	@FindBy(css = "input[value='1'][name='newsletter']")
	WebElement newsletterRadioButton;
	@FindBy(name = "agree")
	WebElement agreeCheckBox;
	@FindBy(css = "input[type='submit']")
	WebElement submitButton;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// Business logic
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPhoneNumber(String phone) {
		phoneField.sendKeys(phone);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}

	public void selectNewsletter() {
		newsletterRadioButton.click();
	}

	public void selectAgreeCheckBox() {
		agreeCheckBox.click();
	}

	public void submitProfile() {
		submitButton.click();
	}
	
	public void registerWithMandatoryFields(String firstName, String lastName, String email, String phone, String password) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPhoneNumber(phone);
		enterPassword(password);
		enterConfirmPassword(password);
		selectAgreeCheckBox();
		submitProfile();
	}
	public void registerWithAllFields(String firstName, String lastName, String email, String phone, String password) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPhoneNumber(phone);
		enterPassword(password);
		enterConfirmPassword(password);
		selectNewsletter();
		selectAgreeCheckBox();
		submitProfile();
	}
	
}
