package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectspecificmethods.BaseClass;

public class HomePage extends BaseClass{
	
	WebDriver driver;
	public HomePage(WebDriver dr) {
		
		this.driver=dr;
	}

	public AppLauncherPage clickOnAppLauncherIcon() throws Exception
	{
		//4) Click on the App Launcher Icon left to Setup
		//driver.navigate().refresh();
		Thread.sleep(4000);
		WebElement appIconEle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.elementToBeClickable(appIconEle));
		appIconEle.click();
		return new AppLauncherPage(driver);

	}

	public AppLauncherPage clickOnViewAllLink()
	{
		//5) Click on View All
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
		return new AppLauncherPage(driver);

	}



}
