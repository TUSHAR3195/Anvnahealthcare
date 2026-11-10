package repoobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home_page {
	public home_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="navPharmacy")
	private WebElement pharmacy;
	
	public WebElement getpharmacy() {
		return pharmacy;
	}
	
	// logout
	@FindBy(id="userMenuDropdown")
	private WebElement logouticon;
	
	public WebElement getlogouticon() {
		return logouticon;
	}
	
	@FindBy(id="dropdownLogout")
	private WebElement logout;
	
	public WebElement getlogout() {
		return logout;
	}
	

}
