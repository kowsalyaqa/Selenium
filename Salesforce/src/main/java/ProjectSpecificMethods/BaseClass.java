package ProjectSpecificMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver=null;
	
	@BeforeMethod
	public void setUp() {
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
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
