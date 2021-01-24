package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ProjectSpecificMethods.BaseClass;

public class NewWorkTypePage extends BaseClass{

	public NewWorkTypePage enterWorkTypeName(String WorkTypeName)
	{
		//8) Enter Work Type Name as 'Salesforce Project'
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(WorkTypeName);
		return this;	
	}


	public NewWorkTypePage enterDescription(String description)
	{
		//9) Enter Description as 'Specimen'
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(description);
		return this;
	}


	public NewWorkTypePage clickOnSearchOperatingHours()
	{

		//10) Create new operating hours by Entering a name as 'UK Shift'
		driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click();
		
		return  this;

	}

	public NewOperatingHoursPage clickOnNewOperatingHours() throws Exception
	{
		WebElement ele=driver.findElement(By.xpath("//span[text()='New Operating Hours']"));
		WebDriverWait wait6=new WebDriverWait(driver,60);
		wait6.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		return new NewOperatingHoursPage();
	}


	public NewWorkTypePage enterEstimatedDuration(String estimatedDuration) {
		//13) Enter Estimated Duration as '7'	
		driver.findElement(By.xpath("//span[text()='Estimated Duration']/parent::*/following-sibling::input")).sendKeys(estimatedDuration);
		return this;
	}

	public WorkTypeHomePage clickOnNewSave() throws Exception
	{
		//14) Click on Save
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='button-container-inner slds-float_right']/button[3]")).click();
		return new WorkTypeHomePage();
	}


	public WorkTypeHomePage verifyWorkTypeCreationMessage()
	{
		//15) Verify the Created message 
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]"));
		WebDriverWait wait5=new WebDriverWait(driver,60);
		wait5.until(ExpectedConditions.visibilityOf(ele2));
		String actualCreatedMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']/span[contains(text(),'Work Type')]")).getText();	
		if(actualCreatedMessage.contains("Work Type \"Salesforce Project\" was created"))
		{
			System.out.println("Work Type message is verifed");
		}
		else
		{
			System.out.println("Created Message is not matched");
		}

		return new WorkTypeHomePage();
	}

}
