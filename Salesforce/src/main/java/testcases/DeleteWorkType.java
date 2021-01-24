package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class DeleteWorkType extends BaseClass{
	
	@Test
	public static void deleteWorkType() throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		Actions action=new Actions(driver);
		WebElement eleviewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		action.moveToElement(eleviewAll).click().build().perform();
		WebElement eleWorkTypes = driver.findElement(By.xpath("//h2[text()='App Launcher']/following::p[text()='Work Types']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", eleWorkTypes);
		eleWorkTypes.click();
		
		WebElement eleLoading = driver.findElement(By.xpath("//span[text()='Loading...']/ancestor::div[@class='slds-spinner_container slds-grid']"));
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		
		String beforeDeleteCount = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println("BeforeDeleteCount: "+beforeDeleteCount);
		String workTypeName= driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/th//a")).getText();
		driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/th//a/ancestor::th/following-sibling::td[last()]/descendant::a")).click();
		driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
		driver.findElement(By.xpath("//span[text()='Delete']/parent::button")).click();
		String deleteToastMessage = driver.findElement(By.xpath("//div[@class='slds-align-middle slds-hyphenate']")).getText();
		if(deleteToastMessage.contains("was deleted"))
		{
			System.out.println("Worktype is deleted");
		}		
		String afterDeleteCount = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println("AfterDeleteCount: "+afterDeleteCount);
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(workTypeName,Keys.RETURN);
		String deleteVerficationMessage = driver.findElement(By.xpath("//p[text()='No items to display.']")).getText();
		if(deleteVerficationMessage.contains("No items to display."))
		{
			System.out.println("Deleted item is erified");
			
		}
		else
		{
			System.out.println("Need verification on deletd item");
		}
		
		driver.quit();
	}
}
