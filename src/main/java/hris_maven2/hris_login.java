package hris_maven2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hris_login {

	WebDriver driver;
	
	public hris_login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private WebElement getUsernameEntry()
	{
		return this.driver.findElement(By.id("txtUserName"));
	}
	
	private WebElement getPasswordEntry()
	{
		return this.driver.findElement(By.id("txtPassword"));
	}
	
	private WebElement getSubmitButton() {
		return this.driver.findElement(By.xpath("//input[@value='Sign In']"));
	}
	
	private WebElement getErrorMessageElement()
	{
		return this.driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]"));
	}
	
	
	
	private void login(String username,String password)
	{
		getUsernameEntry().clear();
		getUsernameEntry().sendKeys(username);
		getPasswordEntry().clear();
		getPasswordEntry().sendKeys(password);
		getSubmitButton().submit();
		
	}
	
	public String loginWithIncorrectCredentials(String username,String password)
	{
		login(username,password);
		return getErrorMessageElement().getText();
		
	}
	
	public boolean loginWithCorrectCredentials(String username,String password) throws InterruptedException
	{
		login(username,password);
		Thread.sleep(4000);
		try {
		driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e);
			System.out.println("Alert Not Present");
		}
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl().contains("profile?gid");
		
	}
	public boolean loginWithEmptyPasswordField()
	{
		 return getPasswordEntry().getAttribute("style").contains("red");
	}
}

