package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import projectspecificmethods.BaseClass;

public class AppLauncherPage extends BaseClass{
	
	@Given("Click on Service")
	public ServiceHomePage clickOnWorkTypesLink() throws Exception
	{
		Thread.sleep(4000);
		WebElement eleService =driver.findElement(By.xpath("//p[text()='Service']"));
		eleService.click();	
		return new ServiceHomePage();
}

}