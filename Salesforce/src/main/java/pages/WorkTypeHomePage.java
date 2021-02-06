package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectspecificmethods.BaseClass;

public class WorkTypeHomePage extends BaseClass{
	
	WebDriver driver;
	public WorkTypeHomePage(WebDriver dr) {
		this.driver=dr;
	}

	public String workTypeName;
	
	public NewWorkTypePage clickOnNewLink()
	{
		WebElement eleNew = driver.findElement(By.xpath("//a[@title='New']"));
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.visibilityOf(eleNew));
		for(int i=0;i<=3;i++)
		{
			try
			{
				eleNew.click();
				break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		return new NewWorkTypePage(driver);

	}

	public WorkTypeHomePage clickOnRowEndArrow()
	{
		
		//7) Click on the Arrow button at the end of the first result
		for(int i=0;i<=3;i++)
		{
			try
			{
				driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/th//a/ancestor::th/following-sibling::td[last()]/descendant::a")).click();
				//driver.findElement(By.xpath("(//table//tr//td//a)[1]")).click();
				break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	
		return this;
	}


	public WorkTypeHomePage clickOnEditLink() throws Exception
	{
		
		//8) Click on Edit
		Actions action=new Actions(driver);
		WebElement eleedit = driver.findElement(By.xpath("//a/div[contains(text(),'Edit')]"));
		for(int i=0;i<=2;i++)
		{
			try
			{
				action.moveToElement(eleedit).click().build().perform();
				break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		Thread.sleep(3000);
		return this;
	}



	public WorkTypeHomePage invisibleOfLoadingIcon()
	{
		WebElement eleLoading = driver.findElement(By.xpath("//span[text()='Loading...']/ancestor::div[@class='slds-spinner_container slds-grid']"));
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		return this;
	}

	public WorkTypeHomePage beforeDeleteRowCount()
	{
		String beforeDeleteCount = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println("BeforeDeleteCount: "+beforeDeleteCount);
		workTypeName= driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/th//a")).getText();
		return this;
	}
	
	public DeleteModalWindowPage clickOnDeleteLink()
	{
		driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
		return new DeleteModalWindowPage(driver);
	}
	
	public WorkTypeHomePage afterDeleteRowCount()
	{
		String afterDeleteCount = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println("AfterDeleteCount: "+afterDeleteCount);
		return new WorkTypeHomePage(driver);
	}
	
	public WorkTypeHomePage searchDeletedWorkTypeName() throws Exception
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(workTypeName,Keys.RETURN);
		return this;
	}
	
	public WorkTypeHomePage verifyDeletedWorkTypeMessageInGrid() throws Exception
	{
		Thread.sleep(5000);
		String deleteVerficationMessage = driver.findElement(By.xpath("//p[text()='No items to display.']")).getText();
		if(deleteVerficationMessage.contains("No items to display."))
		{
			System.out.println("Deleted item is erified");
			
		}
		else
		{
			System.out.println("Need verification on deletd item");
		}
		return this;

	}
	
}
