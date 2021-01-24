package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ProjectSpecificMethods.BaseClass;

public class NewOperatingHoursPage extends BaseClass {

	public NewOperatingHoursPage enteShiftName(String newOperatingHoursName)
	{
		//11) Select '(GMT+00:00) Greenwich Mean Time (GMT)' for Time Zone
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(newOperatingHoursName);
		return this;
	}

	



	public NewOperatingHoursPage clickOnTimeZoneDropDownList() throws Exception
	{
		
		driver.findElement(By.xpath("//span[text()='Time Zone']/following::a")).click();
		Thread.sleep(1000);
		return this;
	}

	public NewOperatingHoursPage selectTimeZoneValueDropDownValue(String newOperatingHoursTimeZone) 
	{
		driver.findElement(By.xpath("//ul[@class='scrollable']//li[@class='uiMenuItem uiRadioMenuItem']//a[contains(text(),'(GMT+00:00) Greenwich Mean Time (GMT)')]")).click();
		return this;
	}

	public NewWorkTypePage clickOnSave()
	{

		//12) Click on Save
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();					
		return new NewWorkTypePage();			
	}


	public NewWorkTypePage verifyShiftCreationMessage()
	{
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
		
		return new NewWorkTypePage();


	}
}
