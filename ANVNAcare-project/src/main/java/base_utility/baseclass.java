package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.file_utility;
import repoobject.home_page;
import repoobject.login_page;

public class baseclass {
	public static WebDriver sdriver=null;
	public WebDriver driver = null;
	
	@BeforeClass
	public void setup() throws IOException, ParseException {
		file_utility futil = new file_utility();
		String browser = futil.getdatafromjsonfile("bro");
		if (browser.equals("chrome")) {
				driver = new ChromeDriver();

			} else if (browser.equals("edge")) {

				driver = new EdgeDriver();

			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();

			} else {
				driver = new ChromeDriver();
			}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@BeforeMethod
	public void login() throws IOException, ParseException, InterruptedException {
		file_utility futil = new file_utility();
		String url = futil.getdatafromjsonfile("url");
		String email = futil.getdatafromjsonfile("email");
		String password = futil.getdatafromjsonfile("pwd");
		driver.get(url);
		
		login_page lp=new login_page(driver);
		WebElement loginbtn=lp.getloginbtn();
		loginbtn.click();
		
		WebElement emailfield=lp.getemailfield();
		emailfield.sendKeys(email);
		
		WebElement passwordfield=lp.getpasswordfield();
		passwordfield.sendKeys(password);
		
		WebElement signinfield=lp.getsigninfield();
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.elementToBeClickable(signinfield));
		Actions act=new Actions(driver);
		act.scrollByAmount(0,400).perform();
		signinfield.click();
		
		Thread.sleep(3000);
		
	
	}
	
	@AfterMethod
	public void logout() {
		home_page hp=new home_page(driver);
		WebElement logouticon=hp.getlogouticon();
		Actions act=new Actions(driver);
		act.moveToElement(logouticon);
		logouticon.click();
		
		WebElement logout=hp.getlogout();
		logout.click();
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
