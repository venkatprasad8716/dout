package monday_pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	@FindBy(xpath="//div/a/img")private WebElement actlogo;
	@FindBy(xpath="//div[@class='avatar']")private WebElement actinitials;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//to verify logo
	public void Logoverify(boolean expected)
	{
	//	boolean expected = true;
		boolean act = actlogo.isDisplayed();

		if(expected==act)
		{
			System.out.println("logo verification is pass");
		}
		else
		{
			System.out.println("logo verification is fail");
		}
	}

		//to verify initials
	public void Verifyint(String expinitials)
	{
		//String expinitials = "PM";
		String actint = actinitials.getText();
		if(expinitials.equals(actint)){
			System.out.println("initals is verified");
		}
		else
		{
			System.out.println("logo verification is failed");
		}
	}
}
