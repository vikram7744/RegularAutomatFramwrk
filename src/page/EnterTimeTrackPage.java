package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement helpMenu;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutMenu;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void clickHelp(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helpMenu.click();
	}
	
	public void clickAboutMenu(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aboutMenu.click();
	}
	
	public void verifyVersion(String eVersion){
		String aVersion=version.getText();
		Assert.assertEquals(aVersion,eVersion);
	}
	
	public void clickClose(){
		closeBTN.click();
	}
	
	public void clickLogout(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logoutLink.click();
	}
	
	public void verifyTitle(WebDriver driver,String eTitle){
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is Matching",true);
		}
		catch(Exception e){
			Reporter.log("Title is NOT Matching",true);
			Assert.fail();
		}
	}
}