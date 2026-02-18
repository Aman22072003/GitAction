package test;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Read_Properties;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeSuite
	public void setup() throws IOException {
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new"); // run headless
	    options.addArguments("--no-sandbox"); 
	    options.addArguments("--disable-dev-shm-usage");
	    
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(Read_Properties.readProperty().getProperty("Base_URL"));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void navigateToBaseUrl() throws IOException {
		// Ensure each test starts from the login page to avoid stale page state between tests
		driver.get(Read_Properties.readProperty().getProperty("Base_URL"));
	}
	
	@AfterSuite
	public void teardown() {
//		driver.quit();
	}
}