package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ProjectSpecificMethods.BaseClass;

public class WorkTypeHomePage extends BaseClass{
	
	
	public NewWorkTypePage clickOnNewLink()
	{
		WebElement eleNew = driver.findElement(By.xpath("//a[@title='New']"));
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOf(eleNew));
		eleNew.click();
		return new NewWorkTypePage();
		
	}
	
	public WorkTypeHomePage clickOnRowEndArrow()
	{
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
				
			
		return this;
	}
	
	
	public WorkTypeHomePage clickOnEditLink() throws Exception
	{
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
	Thread.sleep(3000);
		return this;
	}

}
