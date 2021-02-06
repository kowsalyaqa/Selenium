package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.HomePage;
import pages.NewOperatingHoursPage;
import pages.NewWorkTypePage;
import pages.WorkTypeHomePage;
import projectspecificmethods.BaseClass;
import utilities.ReadExcelData;

public class CreateNewWorkType extends BaseClass {
	
	@DataProvider(name="createWorkTypeData",parallel=true)
	public String[][] getData() throws Exception
	{
		ReadExcelData rd=new ReadExcelData();
		String[][] data=rd.readExcelData();
		return data;	
	}
	

	@Test(dataProvider="createWorkTypeData")
	public void createNewWorkType(String WorkTypeName,String description,String newOperatingHoursName,String newOperatingHoursTimeZone,String estimatedDuration) throws Exception  
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnAppLauncherIcon();
		hp.clickOnViewAllLink();
		AppLauncherPage alp=new AppLauncherPage(driver);
		alp.clickOnWorkTypesLink();
		WorkTypeHomePage wthp=new WorkTypeHomePage(driver);
		wthp.clickOnNewLink();
		NewWorkTypePage nwtp=new NewWorkTypePage(driver);
		nwtp.enterWorkTypeName(WorkTypeName);
		nwtp.enterDescription(description);
		nwtp.clickOnSearchOperatingHours();
		nwtp.clickOnNewOperatingHours();
		NewOperatingHoursPage nohp=new NewOperatingHoursPage(driver);
		nohp.enteShiftName(newOperatingHoursName);
		nohp.clickOnTimeZoneDropDownList();
		nohp.selectTimeZoneValueDropDownValue(newOperatingHoursTimeZone);
		nohp.clickOnSave();
		nohp.verifyShiftCreationMessage();
		nwtp.enterEstimatedDuration(estimatedDuration);
		nwtp.clickOnNewSave();
		nwtp.verifyWorkTypeCreationMessage();				
	}
}
