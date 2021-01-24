package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class EditWorkType extends BaseClass{

	
	@Test
	public  void editWorkType() throws Exception
	{
	
		
		//4) Click on the App Launcher Icon left to Setup
		driver.navigate().refresh();
		WebElement appIconEle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.elementToBeClickable(appIconEle));
		appIconEle.click();
		
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
		for(int i=0;i<=3;i++)
		{
			try
			{
			driver.findElement(By.xpath("(//table//tr//td//a)[1]")).click();
			break;
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
		
	
		//8) Click on Edit
		Actions action=new Actions(driver);
		WebElement eleedit = driver.findElement(By.xpath("//a/div[contains(text(),'Edit')]"));
		for(int i=0;i<=2;i++)
		{
			try
			{
				action.moveToElement(eleedit).click().build().perform();
			break;
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
		
		//9) Enter Time Frame Start as '9'
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe Start')]/parent::*/following-sibling::input")).clear();
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe Start')]/parent::*/following-sibling::input")).sendKeys("9");
		
		//10) Enter Time Frame End as '18'
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe End')]/parent::*/following-sibling::input")).clear();
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe End')]/parent::*/following-sibling::input")).sendKeys("18");
		
		//11) Click on Save
		driver.findElement(By.xpath("(//div[@class='button-container-inner slds-float_right']/button)[3]")).click();
		
		//12) Verify the success message

		String editMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]")).getText();
		if(editMessage.contains("Work Type"))
		{
			System.out.println("Edit Message is verified");
		}
		else
		{
			System.out.println("Edit Message is not displayed as expected");
		}
		
		Thread.sleep(2000);;
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		
	}
	
}
