package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import projectspecificmethods.BaseClass;

public class ServiceHomePage extends BaseClass {

	
	@Given("Click on Reports")
	public ReportsHomePage click_on_reports() throws Exception
	{
		Thread.sleep(6000);
		WebElement eleReports =driver.findElement(By.xpath("//span[text()='Reports']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", eleReports);
		return new ReportsHomePage();
		
		
	}
}
