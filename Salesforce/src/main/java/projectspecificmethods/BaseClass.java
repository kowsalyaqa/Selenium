package projectspecificmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	protected WebDriver driver;
//	protected  ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	@Parameters({"browser","url","userName","password"})
	@BeforeMethod
	public void setUp(String browser,String url,String userName,String password) {
				if(browser.equalsIgnoreCase("chrome"))
				{
				//Launch browser
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				//driver.set(new ChromeDriver(options));
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
	
	/*public WebDriver driver
	{
		return driver.get();
	}*/
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
		driver.quit();
	}

}
