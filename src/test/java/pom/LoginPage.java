package pom;

import generic.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	@FindBy(id="username")
	private WebElement untbox;
	
	@FindBy(name="pwd")
	private WebElement pwdtbox;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errmsg;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void setUserName(String un)
	{
		untbox.sendKeys(un);
	}
	
	public void setPassword(String pwd)
	{
		pwdtbox.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
	
	public void verifyErrmsg()
	{
		verifyElement(errmsg);
	}
	
	public void verifyLoginPage(String lp_title)
	{
		verifyTitle(lp_title);
	}
}
