package repoobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
	WebDriver driver;
	public login_page(WebDriver driver) {
	
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="navLogin")
	private WebElement loginbtn;
	
	public WebElement getloginbtn() {
		return loginbtn;
	}
	
	@FindBy(id="emailInput")
	private WebElement emailfield;
	
	public WebElement getemailfield() {
		return emailfield;
	}
	
	@FindBy(id="passwordInput")
	private WebElement passwordfield;
	
	public WebElement getpasswordfield() {
		return passwordfield;
	}
	
	@FindBy(id="submitBtnText")
	private WebElement signinfield;
	
	public WebElement getsigninfield() {
        return signinfield;
	}

}
