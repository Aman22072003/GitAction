package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "username")
	WebElement username_input;
	
	@FindBy(name = "password")
	WebElement password_input;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement submit_button;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgetPassword_link;
	
	@FindBy(xpath = "//p[@class = 'oxd-userdropdown-name']")
	WebElement user_dropdown;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout_button;
	
	@FindBy(xpath = "//img[@class = 'oxd-userdropdown-img']")
	WebElement profile_picture;
	
	@FindBy(xpath = "//p[@class = 'oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement errorMessage;
	
	public void enterUsername(String user) {
		waitForVisibility(username_input);
		username_input.clear();
		username_input.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		waitForVisibility(password_input);
		password_input.clear();
		password_input.sendKeys(pass);
	}
	
	public boolean isLoginSuccessful() {
		
		if(profile_picture.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void getErrorMessageText() {
		waitForVisibility(errorMessage);
		System.out.println("Error Message: " + errorMessage.getText());
	}
	
	public boolean isLoginButtonDisplayed() {
		waitForVisibility(submit_button);
		return submit_button.isDisplayed();
	}
	
	public boolean areFieldsPresent() {
		waitForVisibility(username_input);
		waitForVisibility(password_input);
		return username_input.isDisplayed() && password_input.isDisplayed();
	}
	
	public void submit() {
		waitForClickability(submit_button);
		submit_button.click();
	}
	
	public void clickForgetPassword() {
		waitForClickability(forgetPassword_link);
		forgetPassword_link.click();
	}
	
	public void userdropdown() {
		waitForClickability(user_dropdown);
		user_dropdown.click();
	}
	
	public void logout() {
		waitForClickability(logout_button);
		logout_button.click();
	}
}