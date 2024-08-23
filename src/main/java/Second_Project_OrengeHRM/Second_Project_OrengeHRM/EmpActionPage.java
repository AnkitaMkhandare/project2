package Second_Project_OrengeHRM.Second_Project_OrengeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpActionPage {

	WebDriver d;
// find web elements of  Add Employee Details, Search Employee & Delete Emp Details

// find PIM Menu and click on PIM Menu
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pIM;

// find Add employee and click on Add Employee option
	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmp;

// enter first name
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstname;

// enter last name
	@FindBy(xpath = " //input[@placeholder='Last Name']")
	WebElement lastname;

// click save button
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;

// find Employee List  and click on Employee List 
	@FindBy(xpath = "//a[normalize-space()='Employee List']")
	WebElement empList;

// find input Menu and click on it  
	@FindBy(tagName = "input")
	WebElement inputName;

// click  search button
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;

// click on delete icon of the record
	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteIcon;

// click on yes, delete message button
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement clickOnDelete;

	public EmpActionPage(WebDriver driver) {
		d = driver;
		PageFactory.initElements(d, this);
	}

// Methods for operations
	public void pIM() {
		pIM.click();
	}

	public void addEmp() {
		addEmp.click();
	}

	public void firstname(String name) {
		firstname.sendKeys("John");
		new WebDriverWait(d, Duration.ofSeconds(120, 1));
	}

	public void lastname(String name) {
		lastname.sendKeys("Wick");
		new WebDriverWait(d, Duration.ofSeconds(120, 1));
	}

	public void save() {
		save.click();
		new WebDriverWait(d, Duration.ofSeconds(120, 1));

		String confirmationMessage = d.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();

		if (confirmationMessage.contains("Personal Details")) {
			System.out.println("Employee added successfully!");
		} else {
			System.out.println("Failed to add employee!");
		}
	}

	public void empList() {
		empList.click();

	}

	public void inputName(String name) {
		inputName.sendKeys("John");
		new WebDriverWait(d, Duration.ofSeconds(120, 1));
	}

	public void search() {
		search.click();

		List<WebElement> element = d.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));

		String expected_message = "Record Found";
		String message_actual = element.get(0).getText();
		System.out.println(message_actual);
	}

	public void deleteIcon() {
		deleteIcon.click();
		new WebDriverWait(d, Duration.ofSeconds(120, 1));
	}

	public void clickOnDelete() {
		clickOnDelete.click();
		new WebDriverWait(d, Duration.ofSeconds(120, 1));

		String msg = d.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]")).getText();

	}

}
