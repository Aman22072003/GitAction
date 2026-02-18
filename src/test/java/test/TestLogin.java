package test;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TestLogin extends BaseTest{
	@Test(priority = 1)
	public void ValidLogin() {
		
		LoginPage login = new LoginPage(driver);
		login.areFieldsPresent();
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.isLoginButtonDisplayed();
		login.submit();
		
//		login.isLoginSuccessful();
		login.userdropdown();
		login.logout();
		
	}
	@Test(priority = 0)
	public void InValidLogin() {
		
		LoginPage login = new LoginPage(driver);
//		login.areFieldsPresent();
		login.enterUsername("Admin");
		login.enterPassword("admin1234");
		login.isLoginButtonDisplayed();
		login.submit();
		
//		login.getErrorMessageText();
		
	}
	@Test(priority = 2)
	public void forgetPassword() {
		
		LoginPage login = new LoginPage(driver);
		login.clickForgetPassword();
		login.enterUsername("Admin");
		login.submit();
		
//		String ResetVerification = driver.findElement(By.xpath("//h6[contains(@class, 'orangehrm-forgot-password-title')]")).getText();
//		if(ResetVerification.contains("Reset Password link sent successfully")) {
//			System.out.println("Test Passed: Reset successful");
//		}
//		else {
//			System.out.println("Test Failed: Reset unsuccessful");
//		}
	}
}