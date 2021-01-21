package testcases;

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

public class CreateNewWorkType {
	
	public WebDriver driver=null;
	String workTypeName="Salesforce Project";

	public void createNewWorkType()  
	{
		//Launch browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//1)Launch the app
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//2)Click Login
		driver.findElement(By.id("Login")).click();
		
		//3)Login with Credentials
		driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@1234");
		driver.findElement(By.id("Login")).click();
		
		//4)Click on the App Launcher Icon left to Setup
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		//5) Click on View All
		Actions action=new Actions(driver);
		WebElement eleviewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		action.moveToElement(eleviewAll).click().build().perform();
		/*WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.textToBePresentInElement(eleviewAll, "App Launcher"));
	*/
		//6) Click on Work Types
		WebElement eleWorkType = driver.findElement(By.xpath("//p[text()='Work Types']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView();",eleWorkType);
		eleWorkType.click();
		WebDriverWait wait3=new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='New']"))));

		//7) Click on New	
		WebElement eleNew = driver.findElement(By.xpath("//a[@title='New']"));
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOf(eleNew));
		eleNew.click();

		//8) Enter Work Type Name as 'Salesforce Project'
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Salesforce Project");
		
		//9) Enter Description as 'Specimen'
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Specimen");
		
		//10) Create new operating hours by Entering a name as 'UK Shift'
		driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
		driver.findElement(By.xpath("//span[text()='New Operating Hours']")).click();
		
		//11) Select '(GMT+00:00) Greenwich Mean Time (GMT)' for Time Zone
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("UK Shift");
		driver.findElement(By.xpath("(//a[@class='select'])[6]")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']//li[@class='uiMenuItem uiRadioMenuItem']//a[contains(text(),'(GMT+00:00) Greenwich Mean Time (GMT)')]")).click();
		
		/*List<WebElement> list = driver.findElements(By.tagName("li"));
		for (int i=0;i<list.size();i++) {
			String text = list.get(i).getText();
			System.out.println(text);
			String expectedText="(GMT+00:00) Greenwich Mean Time (GMT)";
			if(text.equalsIgnoreCase(expectedText))
			{
				list.get(i).click();
				break;
			}
			
		}*/
		
		//12) Click on Save
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		
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
		
		//13) Enter Estimated Duration as '7'	
		driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::*/following-sibling::input")).sendKeys("7");
		
		//14) Click on Save
		driver.findElement(By.xpath("//div[@class='button-container-inner slds-float_right']/button[3]")).click();
		
		//15) Verify the Created message 
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]"));
		WebDriverWait wait5=new WebDriverWait(driver,30);
		wait5.until(ExpectedConditions.visibilityOf(ele2));
		String actualCreatedMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]")).getText();	
		if(actualCreatedMessage.contains("Work Type \"Salesforce Project\" was created"))
		{
			System.out.println("Work Type message is verifed");
		}
		else
		{
			System.out.println("Created Message is not matched");
		}
		
		//16)close browser
		driver.close();
		
	}

		public static void main(String[] args) {
			
			CreateNewWorkType cnwt=new CreateNewWorkType();
			cnwt.createNewWorkType();
		
			

		}
	

}
