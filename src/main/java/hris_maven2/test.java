package hris_maven2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class test {

	protected WebDriver driver;
	hris_login loginform;
	
	@BeforeTest
	public void launchDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhinigam\\Desktop\\New folder\\tasks\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		loginform=new hris_login(driver);

	}
	
	@Test(priority=0)
	public void launchUrl()
	{
		driver.get("https://hris.qainfotech.com");
		
	}
	
	@Test(priority=1)
	public void incorrectLogin()
	{
		Assert.assertTrue(loginform.loginWithIncorrectCredentials("shubhinigam", "sdjgchs").equals("Invalid Login"));		
	}
	
	@Test(priority=3)
	public void correctLogin() throws InterruptedException
	{
		Assert.assertTrue(loginform.loginWithCorrectCredentials("shubhinigam", "Shubhi@321#"));		
	}
	
	@Test(priority=2)
	public void IncorrectLoginWithEmptyPassword()
	{
		Assert.assertTrue(loginform.loginWithEmptyPasswordField());
	}

}
