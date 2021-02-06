package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws Exception {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\git\\Selenium\\Salesforce\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@1234");
		driver.findElement(By.id("Login")).click();
		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//span[text()='App Launcher']/preceding-sibling::div")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		Thread.sleep(1000);
		WebElement viewAllButton = driver.findElement(By.xpath("//button[text()='View All']"));
		Actions action=new Actions(driver);
		action.moveToElement(viewAllButton);
		action.click().build().perform();
		Thread.sleep(2000);
		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//p[text()='Service Console']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}		
		}
		Thread.sleep(2000);
		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		Thread.sleep(1000);
		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//ul/li/div/a[@title='Home']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		Thread.sleep(2000);

		WebElement closedValueEle = driver.findElement(By.xpath("//span[text()='Closed']/following-sibling::span[contains(text(),'$')]"));
		String closedValue = closedValueEle.getText();
		closedValue=closedValue.replace("$","");
		System.out.println(closedValue);
		int cv=Integer.parseInt(closedValue);
		System.out.println(cv);
		WebElement openValueEle = driver.findElement(By.xpath("//span[starts-with(text(),'Open (')]/following-sibling::span[contains(text(),'$')]"));
		String openValue = openValueEle.getText();
		openValue=openValue.replace("$", "");
		int ov=Integer.parseInt(openValue);
		System.out.println(ov);
		int goalValue=(cv+ov);		
		System.out.println(goalValue);
		if(goalValue<10000)
		{
			driver.findElement(By.xpath("//span[text()='Goal']/parent::*/child::button[@title='Edit Goal']")).click();
			Thread.sleep(1000);
			WebElement currencyValEle = driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input"));
			currencyValEle.clear();
			currencyValEle.sendKeys("10000");
			driver.findElement(By.xpath("//span[@id='currencyCode']/following::button/span[text()='Save']")).click();
			Thread.sleep(1000);
			String changedgoalValue = driver.findElement(By.xpath("//span[text()='Goal']/following-sibling::span[contains(text(),'$')]")).getText();
			Assert.assertEquals(changedgoalValue, "$10,000");
		}

		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

		Thread.sleep(1000);

		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//ul/li/div/a[@title='Dashboards']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		Thread.sleep(4000);
		for(int i=0;i<3;i++)
		{
			try
			{
				driver.findElement(By.xpath("//a[@title='New Dashboard']")).click();
				break;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		Thread.sleep(2000);
		WebElement frameDashboardWindow = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameDashboardWindow);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Kowsalya_Workout");
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(2000);
		String dashboardName = driver.findElement(By.xpath("//div[@class='slds-form-element editTitle']/descendant::span")).getText();
		System.out.println(dashboardName);
		if(dashboardName.contains("Kowsalya_Workout"))
		{
			System.out.println("Dashbozrd name is verified");
		}
		else
		{
			System.out.println("Need to verify on dashboard name creation");
		}


		driver.close();

	}

}
