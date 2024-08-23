package Second_Project_OrengeHRM.Second_Project_OrengeHRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmpActionTest {

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.out.println("Before Test executed");

		driver = new ChromeDriver();

		// maximise windows
		driver.manage().window().maximize();

		// open url
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // 60 seconds
	}

	@Test(priority = 1)

	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName("Admin");
		loginPage.SetPassword("admin123");
		loginPage.clickLoginButton();

	}

	@Test(priority = 2)
	public void testAddEmp() throws InterruptedException {
		EmpActionPage addEmp = new EmpActionPage(driver);

		addEmp.pIM();
		addEmp.addEmp();
		addEmp.firstname("John");
		addEmp.lastname("Wick");
		addEmp.save();

	}

	@Test(priority = 3)
	public void testSerachEmp() throws InterruptedException {
		EmpActionPage addEmp = new EmpActionPage(driver);

		// addEmp.pIM();
		addEmp.empList();
		addEmp.inputName("John Wick");
		addEmp.search();

	}

	@Test(priority = 3)
	public void testDeleteEmpRecord() throws InterruptedException {
		EmpActionPage addEmp = new EmpActionPage(driver);

		// addEmp.pIM();
		addEmp.empList();
		addEmp.inputName("John Wick");
		addEmp.search();
		addEmp.deleteIcon();
		addEmp.clickOnDelete();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}