package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppLauncherPage;
import pages.HomePage;
import pages.NewOperatingHoursPage;
import pages.NewWorkTypePage;
import pages.WorkTypeHomePage;
import runner.TestRunner;

public class TestStepDefinitions{
	WebDriver driver;
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		//Launch browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//driver.set(new ChromeDriver(options));
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		System.out.println("Thread Id"+Thread.currentThread().getId());	
	}

	@Given("Enter the URL as \"(.*)\"$")
	public void enter_the_url_as(String url) {
		driver.get(url); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Given("Enter UserName as \"(.*)\"$")
	public void enter_userName(String userName) {
		driver.findElement(By.name("username")).sendKeys(userName);

	}

	@Given("Enter Password as \"(.*)\"$")
	public void enter_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}


	@Given("Click Login")
	public void click_login() {
		driver.findElement(By.id("Login")).click();

	}

	@Given("Click on the App Laucher Icon left to Setup")
	public void click_on_the_app_laucher_icon_left_to_setup() throws Exception {
		Thread.sleep(4000);
		WebElement appIconEle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.elementToBeClickable(appIconEle));
		appIconEle.click();
	}

	@Given("Click on View All")
	public void click_on_view_all() {
		Actions action1=new Actions(driver);
		WebElement eleViewAll=driver.findElement(By.xpath("//button[text()='View All']"));
		for(int i=0;i<3;i++)
		{
		try {
		action1.moveToElement(eleViewAll).click().build().perform();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
	}
	@Given("Click on Work Types")
	public void click_on_work_types() throws Exception {
		Thread.sleep(4000);
		//6) Click on Work Types
		WebElement eleWorkType = driver.findElement(By.xpath("//p[text()='Work Types']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView();",eleWorkType);
		eleWorkType.click();	
	
	}
	@Given("Click on New")
	public void click_on_new() {
		WebElement eleNew = driver.findElement(By.xpath("//a[@title='New']"));
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.visibilityOf(eleNew));
		for(int i=0;i<=3;i++)
		{
			try
			{
				eleNew.click();
				break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


	}
	@Given("Enter Work Type Name as {string}")
	public void enter_work_type_name_as(String workTypeName) {
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(workTypeName);
		
	}
	@Given("Enter Description as {string}")
	public void enter_description_as(String description) throws Exception {
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);
		driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
		WebElement ele=driver.findElement(By.xpath("//span[text()='New Operating Hours']"));
		WebDriverWait wait6=new WebDriverWait(driver,60);
		wait6.until(ExpectedConditions.elementToBeClickable(ele));
		for(int i=0;i<3;i++)
		{
			try
			{
				ele.click();
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		Thread.sleep(2000);

	}

	@Given("Create new operating hours by Entering a name as {string}")
	public void create_new_operating_hours_by_entering_a_name_as(String newOperatingHoursName ) throws Exception {
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(newOperatingHoursName);
	}
	
	@Given("Select {string} for Time Zone")
	public void select_for_time_zone(String newOperatingHoursTimeZone) throws Exception {
		driver.findElement(By.xpath("//span[text()='Time Zone']/following::a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='scrollable']//li[@class='uiMenuItem uiRadioMenuItem']//a[contains(text(),'(GMT+00:00) Greenwich Mean Time (GMT)')]")).click();
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
	}
	@Given("Click on Save & Verify the success message")
	public void click_on_save_verify_the_success_message() {
		WebElement ele = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Operating Hours')]"));
		WebDriverWait wait4=new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.visibilityOf(ele));
		String actualShiftCreatedMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Operating Hours')]")).getText();
		if(actualShiftCreatedMessage.contains("Operating Hours"))
		{
			System.out.println("Created Shift Message is verified");
		}
		else
		{
			System.out.println("Created Shift Message is not displayed as expected");
		}
		
	}
	@Given("Enter Estimated Duration as {string}")
	public void enter_estimated_duration_as(String estimatedDuration) {

		driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::*/following-sibling::input")).sendKeys(estimatedDuration);
	}

	@When("Click on Save")
	public void click_on_save() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='button-container-inner slds-float_right']/button[3]")).click();
	}
	@Then("Verify the Created message as {string}")
	public void verify_the_created_message_as(String workTypeName) throws Exception {
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]"));
		WebDriverWait wait5=new WebDriverWait(driver,60);
		wait5.until(ExpectedConditions.visibilityOf(ele2));
		String actualCreatedMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]")).getText();	
		if(actualCreatedMessage.contains("Work Type"+"\""+workTypeName+"\""+" was created"))
		{
			System.out.println("Work Type message is verifed");
		}
		else
		{
			System.out.println("Created Message is not matched");
		}
		
		Thread.sleep(2000);
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	   driver.quit();
	}





}
