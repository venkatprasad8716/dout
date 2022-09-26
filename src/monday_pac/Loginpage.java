package monday_pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	@FindBy(xpath="//input[@id='userid']") private WebElement un;
	@FindBy(xpath="//input[@id='password']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")private WebElement click;
	
	public  Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
	}
	// Enter user ID
	public void Enterusername(String username)
	{

un.sendKeys(username);
	}
		//Enter password
		public void EnterPassword(String password)
		{
pass.sendKeys(password);
		}
		
		//Click login
		public void Clickonlogin()
		{
		click.click();
}
}

