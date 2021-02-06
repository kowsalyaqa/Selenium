package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectspecificmethods.BaseClass;

public class AppLauncherPage extends BaseClass {
	
	WebDriver driver;
	public AppLauncherPage(WebDriver dr) {
		this.driver=dr;
	}

	public WorkTypeHomePage clickOnWorkTypesLink() throws Exception
	{
		Thread.sleep(4000);
		//6) Click on Work Types
		WebElement eleWorkType = driver.findElement(By.xpath("//p[text()='Work Types']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView();",eleWorkType);
		eleWorkType.click();	
		/*WebDriverWait wait3=new WebDriverWait(driver,60);
		wait3.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='New']"))));*/		
		return new WorkTypeHomePage(driver);


	}

}
