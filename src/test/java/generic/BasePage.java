package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage
{
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleContains(eTitle));
			//String aTitle=driver.getTitle();
			//Assert.assertEquals(aTitle,eTitle);
			Reporter.log(eTitle+" Title is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log(eTitle+" Title is not matching",true);
			Assert.fail();
		}		
	}
	
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present",true);
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present",true);
			Assert.fail();
		}
	}
}
