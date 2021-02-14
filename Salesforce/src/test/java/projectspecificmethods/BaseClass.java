package projectspecificmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests  {

	protected static WebDriver driver;

	@Parameters({"browser","url","userName","password"})
	@BeforeMethod
	public void setUp(String browser,String url,String userName,String password) {
		if(browser.equalsIgnoreCase("chrome"))
		{

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			System.out.println("Thread Id"+Thread.currentThread().getId());	
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}


	@AfterMethod
	public void tearDown()
	{

		driver.quit();
	}


}
