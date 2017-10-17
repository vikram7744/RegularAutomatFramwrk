package generic;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String node,String browser) throws Exception{
		URL nodeURL=new URL(node);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(nodeURL,dc);
		String url=Lib.getPpt(CONFIG_PATH,"URL");
		driver.get(url);
		String strITO=Lib.getPpt(CONFIG_PATH,"ITO");
		long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApplication(){
		driver.quit();
	}
}
