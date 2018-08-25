package scripts;
import generic.BaseTest;
import generic.Excel;

import org.testng.annotations.Test;

import pom.EnterTimeTrackPage;
import pom.LoginPage;
public class ValidLoginLogout extends BaseTest
{
	@Test
	public void testValidLoginLogout() throws Exception
	{
		String un=Excel.getCellValue(PATH,"ValidLoginLogout",1,0);
		String pwd=Excel.getCellValue(PATH,"ValidLoginLogout",1,1);
		
		//String hp_title=Excel.getCellValue(PATH,"ValidLoginLogout",1,2);
		//String lp_title=Excel.getCellValue(PATH,"ValidLoginLogout",1,3);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(un);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		Thread.sleep(2000);
		//ep.verifyTitle(hp_title);
		ep.clickHelp();
		Thread.sleep(2000);
		ep.clickAboutActiTime();
		Thread.sleep(2000);
		ep.verifyActiTimeVersion("actiTIME 2014 Pro");
		Thread.sleep(2000);
		ep.clickClose();
		Thread.sleep(2000);
		ep.clickLogout();
		Thread.sleep(2000);
		//ep.verifyTitle(lp_title);
	}
}
