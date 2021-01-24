package Pages;

import org.openqa.selenium.By;

import ProjectSpecificMethods.BaseClass;

public class EditWorkTypePage extends BaseClass{



	public EditWorkTypePage enterFrameStartTextbox()
	{
		//9) Enter Time Frame Start as '9'
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe Start')]/parent::*/following-sibling::input")).clear();
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe Start')]/parent::*/following-sibling::input")).sendKeys("9");
		return this;
	}


	public EditWorkTypePage enterFrameEndTextbox()
	{
		//10) Enter Time Frame End as '18'
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe End')]/parent::*/following-sibling::input")).clear();
		driver.findElement(By.xpath("//span[contains(text(),'Timeframe End')]/parent::*/following-sibling::input")).sendKeys("18");
		return this;
	}

	public WorkTypeHomePage clickOnEditSaveButton()
	{

		//11) Click on Save
		driver.findElement(By.xpath("(//div[@class='button-container-inner slds-float_right']/button)[3]")).click();
		return new WorkTypeHomePage();
	}

	public WorkTypeHomePage verifyEditedWorkTypeUpdationMessage()
	{
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
		return new WorkTypeHomePage();
	}
}
