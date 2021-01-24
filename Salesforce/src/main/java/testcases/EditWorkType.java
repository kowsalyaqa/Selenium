package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.AppLauncherPage;
import Pages.EditWorkTypePage;
import Pages.HomePage;
import Pages.WorkTypeHomePage;
import ProjectSpecificMethods.BaseClass;


public class EditWorkType extends BaseClass{

	
	@Test
	public  void editWorkType() throws Exception
	{
		HomePage hp=new HomePage();
		hp.clickOnAppLauncherIcon();
		hp.clickOnViewAllLink();
		AppLauncherPage alp=new AppLauncherPage();
		alp.clickOnWorkTypesLink();
		WorkTypeHomePage wthp=new WorkTypeHomePage();
		wthp.clickOnRowEndArrow();
		wthp.clickOnEditLink();
		EditWorkTypePage ewthp=new EditWorkTypePage();
		ewthp.enterFrameEndTextbox();
		ewthp.enterFrameEndTextbox();
		ewthp.clickOnEditSaveButton();
		ewthp.verifyEditedWorkTypeUpdationMessage();
		
	
	
				
		
		
		
				
			
		/*Thread.sleep(2000);;
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		*/
	}
	
}
