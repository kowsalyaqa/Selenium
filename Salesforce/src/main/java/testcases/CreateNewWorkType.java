package testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.AppLauncherPage;
import Pages.HomePage;
import Pages.NewOperatingHoursPage;
import Pages.NewWorkTypePage;
import Pages.WorkTypeHomePage;
import ProjectSpecificMethods.BaseClass;
import utilities.ReadExcelData;

public class CreateNewWorkType extends BaseClass {
	
	@DataProvider
	public String[][] getData() throws Exception
	{
		ReadExcelData rd=new ReadExcelData();
		String[][] data=rd.readExcelData();
		return data;	
	}
	

	@Test(dataProvider="getData")
	public void createNewWorkType(String WorkTypeName,String description,String newOperatingHoursName,String newOperatingHoursTimeZone,String estimatedDuration) throws Exception  
	{
		HomePage hp=new HomePage();
		hp.clickOnAppLauncherIcon();
		hp.clickOnViewAllLink();
		AppLauncherPage alp=new AppLauncherPage();
		alp.clickOnWorkTypesLink();
		WorkTypeHomePage wthp=new WorkTypeHomePage();
		wthp.clickOnNewLink();
		NewWorkTypePage nwtp=new NewWorkTypePage();
		nwtp.enterWorkTypeName(WorkTypeName);
		nwtp.enterDescription(description);
		nwtp.clickOnSearchOperatingHours();
		nwtp.clickOnNewOperatingHours();
		NewOperatingHoursPage nohp=new NewOperatingHoursPage();
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
