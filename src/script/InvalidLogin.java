package script;

import org.testng.annotations.Test;

import page.LoginPage;
import generic.BaseTest;
import generic.Lib;

public class InvalidLogin extends BaseTest{
	@Test(priority=2,groups={"login"})
	public void testInvalidLogin(){
		int rc=Lib.getRowCount(XL_PATH,"InvalidLogin");
		for(int i=1;i<=rc;i++){
		String un=Lib.getCellValue(XL_PATH,"InvalidLogin",i,0);
		String pw=Lib.getCellValue(XL_PATH,"InvalidLogin",i,1);
		//Enter invalid user name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//Click on login
		l.clickLogin();
		//Verify err msg is Displayed
		l.verifyErrMsgIsDisplayed();
		}
	}
}