package monday_pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pinpage 
{
	@FindBy(xpath="//input[@id='pin']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	
	public Pinpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Enterpin
	
	public void Enterpin(String pins)
	{
		pin.sendKeys(pins);
	}
		//click on Continue
	
	public void clicksubmit()
	{
		submit.click();
}
}