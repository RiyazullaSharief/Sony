package pom;
import generic.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
public class EnterTimeTrackPage extends BasePage
{
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
	private WebElement help;
	
	@FindBy(xpath="//a[.='About actiTIME']")
	private WebElement aboutActiTime;
	
	@FindBy(xpath="//span[.='actiTIME 2014 Pro']")
	private WebElement actiTimeVersion;
	
	@FindBy(xpath="//img[@title='Close']")
	private WebElement close;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickAboutActiTime()
	{
		aboutActiTime.click();
	}
	
	public void clickClose()
	{
		close.click();
	}
	
	public void VerifyHomePage(String hp_title)
	{
		verifyTitle(hp_title);
	}
	
	public void verifyActiTimeVersion(String eversion)
	{
		String aversion=actiTimeVersion.getText();
		try
		{
			Assert.assertEquals(aversion,eversion);
			Reporter.log("Version is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Version is not matching",true);
			Assert.fail();
		}
	}
}
