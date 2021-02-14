package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import projectspecificmethods.BaseClass;

public class ReportsHomePage extends BaseClass{
	@Given("Click on New Report SalesForce Classic")
	public CreateNewReportPage click_on_new_report_salesforce_classic() throws Exception
	{
		Thread.sleep(4000);
		WebElement eleNewReportClassic =driver.findElement(By.xpath("//div[text()='New Report (Salesforce Classic)']"));
		eleNewReportClassic.click();	
		return new CreateNewReportPage();
		
	}

}
