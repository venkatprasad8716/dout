package monday_pac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Normal_Java {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","G:\\java program\\eclipse examples\\Framework\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://kite.zerodha.com/");
		
		// Enter user ID
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("Dp6852");
		
		//Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pramod@2105");
		
		//Click login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Enterpin
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("976976");
		
		//click on Continue
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//to verify logo
		
		boolean expected = true;
		boolean actlogo = driver.findElement(By.xpath("//div/a/img")).isDisplayed();

		if(expected==actlogo)
		{
			System.out.println("logo verification is pass");
		}
		else
		{
			System.out.println("logo verification is fail");
		}

		//to verify initials
		String expinitials = "PM";
		String actinitials = driver.findElement(By.xpath("//div[@class='avatar']")).getText();
		if(expinitials.equals(actinitials)){
			System.out.println("initals is verified");
		}
		else
		{
			System.out.println("logo verification is failed");
		}
		driver.close();
	}
	}

