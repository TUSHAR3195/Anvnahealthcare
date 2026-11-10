package login_check;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utility.file_utility;
import repoobject.login_page;

public class Login {
	@Test
	public void login() throws IOException, ParseException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		file_utility futil = new file_utility();
		String url = futil.getdatafromjsonfile("url");
		String email = futil.getdatafromjsonfile("email");
		String password = futil.getdatafromjsonfile("pwd");

		driver.get(url);

		login_page lp = new login_page(driver);
		WebElement loginbtn = lp.getloginbtn();
		loginbtn.click();

		WebElement emailfield = lp.getemailfield();
		emailfield.sendKeys(email);

		WebElement passwordfield = lp.getpasswordfield();
		passwordfield.sendKeys(password);

		WebElement signinfield = lp.getsigninfield();
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 400).perform();
		signinfield.click();
	}
}
