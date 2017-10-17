package script;

import org.testng.annotations.Test;

import page.EnterTimeTrackPage;
import page.LoginPage;
import generic.BaseTest;
import generic.Lib;

public class ValidLogin extends BaseTest {
	@Test(priority=1,groups={"login","smoke"})
	public void testValidLogin(){
		String un=Lib.getCellValue(XL_PATH,"ValidLogin",1,0);
		String pw=Lib.getCellValue(XL_PATH,"ValidLogin",1,1);
		String title=Lib.getCellValue(XL_PATH,"ValidLogin",1,2);
		//enter valid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//enter valid password
		l.setPassword(pw);
		//click on login button
		l.clickLogin();
		//verify that Home Page is Displayed
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver,title);
	}
}


