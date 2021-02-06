package testcases;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.DeleteModalWindowPage;
import pages.HomePage;
import pages.LoginPage;
import pages.WorkTypeHomePage;
import projectspecificmethods.BaseClass;


public class DeleteWorkType extends BaseClass{

	@Test
	public  void deleteWorkType() throws Exception{
		new LoginPage(driver).enterUserName().enterPassword().clickOnLogin();
		HomePage hp=new HomePage(driver);
		hp.clickOnAppLauncherIcon();
		hp.clickOnViewAllLink();
		new AppLauncherPage(driver).clickOnWorkTypesLink();
		WorkTypeHomePage wthp=new WorkTypeHomePage(driver);
		wthp.clickOnRowEndArrow();
		wthp.clickOnDeleteLink();
		DeleteModalWindowPage dmwp=new DeleteModalWindowPage(driver);
		dmwp.clickOnDeleteButton();
		dmwp.VerifyDelatedToastMessage();
		wthp.afterDeleteRowCount();
		wthp.searchDeletedWorkTypeName();
		wthp.verifyDeletedWorkTypeMessageInGrid();
		
	

















	}
}
