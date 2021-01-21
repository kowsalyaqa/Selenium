package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditWorkTypeValidation {

	public static void main(String[] args) throws Exception {
		//1) Launch the app
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				WebDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				
				//2) Click Login
				driver.get("https://login.salesforce.com/");
				
				//3) Login with the credentials
				driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
				driver.findElement(By.name("pw")).sendKeys("Bootcamp@1234");
				driver.findElement(By.name("Login")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//4) Click on the App Launcher Icon left to Setup
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				//5) Click on View All
				Actions action1=new Actions(driver);
				WebElement eleViewAll=driver.findElement(By.xpath("//button[text()='View All']"));
				action1.moveToElement(eleViewAll).click().build().perform();
				
				//6) Click on Work Types
				WebElement eleWorkType = driver.findElement(By.xpath("//span/p[text()='Work Types']"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", eleWorkType);
				driver.findElement(By.xpath("//span/p[text()='Work Types']")).click();	
				
				//7) Click on the Arrow button at the end of the first result
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td//a")).click();
			
				//8) Click on Edit
				//Actions action=new Actions(driver);
				Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[text()='Edit']/parent::a")).click();
				 Thread.sleep(2000);
				//action.moveToElement(eleedit).click().build().perform();
				
				//9) Remove estimated time by clicking on the X button
				//WebElement ele = driver.findElement(By.xpath("//input[@class=' input']"));
				 //ele.clear();
				 
				WebElement eleEstimatedDuration=driver.findElement(By.xpath("(//label/span[text()='Estimated Duration']/following::input)[1]"));
				//eleEstimatedDuration.clear();---Not working in automation, Manual run working
				eleEstimatedDuration.sendKeys(Keys.CONTROL + "a");
				eleEstimatedDuration.sendKeys(Keys.DELETE);
				eleEstimatedDuration.sendKeys(Keys.TAB);
				
				//10) Enter Time Frame Start as '9'
				WebElement timeStart=driver.findElement(By.xpath("//span[contains(text(),'Timeframe Start')]/parent::*/following-sibling::input"));
				timeStart.clear();
				timeStart.sendKeys("9");
				
				//11) Enter Time Frame End as '18'
				WebElement timeEnd=driver.findElement(By.xpath("//span[contains(text(),'Timeframe End')]/parent::*/following-sibling::input"));
				timeEnd.clear();
				timeEnd.sendKeys("18");
				
				//12) Click on Save
				driver.findElement(By.xpath("//div[@class='button-container-inner slds-float_right']/button[3]")).click();
				
				//13) Verify the success message
				String text = driver.findElement(By.xpath("//div[@class='desktop forcePageError']//span")).getText();
				System.out.println(text);
				String text1=driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
				System.out.println(text1);
	
				//14)  Close browser
				driver.close();	
			}
			
	}


