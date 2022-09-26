package monday_pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.info.Seleniumpractice.Pagefactory.DataDriven.Homepage;

public class LoginTest {
    WebDriver driver;
    Workbook w;
    Loginpage l;
	Pinpage p;
	Homepage h ;
    
   @BeforeTest
	public  void browserlaunch() throws EncryptedDocumentException, IOException  
	{
		System.setProperty("webdriver.chrome.driver","G:\\java program\\eclipse examples\\Framework\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://kite.zerodha.com/");
		
	/*	String username = "Dp6852";
	 String password = "Pramod@2105";
		String pins = "976976";*/
	String filepath = "G:\\java program\\eclipse examples\\com.info.Seleniumpractice\\src\\excel sheet\\Zerodha login.xlsx";
		FileInputStream file = new FileInputStream(filepath);
		w = WorkbookFactory.create(file);
		 l = new Loginpage(driver);
		 p = new Pinpage(driver);
		 h = new Homepage(driver);
	}	
	 
	@BeforeClass	 
public void logintoapp() 
{
		l.Enterusername( w.getSheet("Sheet1").getRow(10).getCell(0).getStringCellValue());
		l.EnterPassword( w.getSheet("Sheet1").getRow(10).getCell(1).getStringCellValue());
		l.Clickonlogin();
		
		p.Enterpin(w.getSheet("Sheet1").getRow(10).getCell(2).getStringCellValue());
		p.clicksubmit();
		
}
@Test
public void verifylogo() 
{
		h.Logoverify(w.getSheet("Sheet1").getRow(10).getCell(5).getBooleanCellValue()); 
}

@Test
public void verifyofinitials() 
{
		h.Verifyint(w.getSheet("Sheet1").getRow(10).getCell(3).getStringCellValue());	
}
@AfterClass
public void closebrowser()
{	
		driver.close();
}
}

