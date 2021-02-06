package testcases;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.EditWorkTypePage;
import pages.HomePage;
import pages.LoginPage;
import pages.WorkTypeHomePage;
import projectspecificmethods.BaseClass;


public class EditWorkType extends BaseClass{



	@Test(priority=2)
	public  void editWorkType() throws Exception
	{
		new LoginPage(driver).enterUserName().enterPassword().clickOnLogin();
		HomePage hp=new HomePage(driver);
		hp.clickOnAppLauncherIcon();
		hp.clickOnViewAllLink();
		AppLauncherPage alp=new AppLauncherPage(driver);
		alp.clickOnWorkTypesLink();
		WorkTypeHomePage wthp=new WorkTypeHomePage(driver);
		wthp.clickOnRowEndArrow();
		wthp.clickOnEditLink();
		EditWorkTypePage ewthp=new EditWorkTypePage(driver);
		ewthp.enterFrameEndTextbox();
		ewthp.enterFrameEndTextbox();
		ewthp.clickOnEditSaveButton();
		ewthp.verifyEditedWorkTypeUpdationMessage();
		
	
	
				
		
		
		
				
			
		/*Thread.sleep(2000);;
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		*/
	}
	
}
