package Second_Project_OrengeHRM.Second_Project_OrengeHRM;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.DataHandler;

public class LoginTest extends DataHandler {

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	private DataHandler dataHandler;

	@BeforeTest
	public void setup() {
		System.out.println("Before Test executed");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // 60 seconds
		dataHandler = new DataHandler();
	}

	@Test(priority = 1, enabled = true, testName = "TC01")
	public void testLogin() {
		Map<String, String> testData = dataHandler.getTestCaseData("TC01");

		LoginPage pg = new LoginPage(driver);

		pg.setUserName(testData.get("username"));
		pg.SetPassword(testData.get("password"));
		pg.clickLoginButton();

		String message_expected = "Invalid credentials";
		//String message_actual = pg.getInvalidText();

	//	Assert.assertEquals(message_expected, message_actual);

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
