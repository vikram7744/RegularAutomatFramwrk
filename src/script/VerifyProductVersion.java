package script;

import org.testng.annotations.Test;

import page.EnterTimeTrackPage;
import page.LoginPage;
import generic.BaseTest;
import generic.Lib;

public class VerifyProductVersion extends BaseTest{
	@Test(priority=3,groups={"product"})
	public void testProductVersion(){
		String sheet="VerifyProductVersion";
		String un=Lib.getCellValue(XL_PATH,sheet,1,0);
		String pw=Lib.getCellValue(XL_PATH,sheet,1,1);
		String version=Lib.getCellValue(XL_PATH,sheet,1,2);
		//enter valid username
				LoginPage l=new LoginPage(driver);
				l.setUserName(un);
				//enter valid password
				l.setPassword(pw);
				//click on login button
				l.clickLogin();
				//click help
				EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
				e.clickHelp();
				//Click on About actiTIME
				e.clickAboutMenu();
				//verify Product version 
				e.verifyVersion(version);
				//click on close button
				e.clickClose();
				//click on logout
				e.clickLogout();
	}

}