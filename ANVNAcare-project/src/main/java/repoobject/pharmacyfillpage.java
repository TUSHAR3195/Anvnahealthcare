package repoobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pharmacyfillpage {
	public pharmacyfillpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="addCartBtn-4")
	private WebElement addtocart;
	
	public WebElement getaddtocart() {
		return addtocart;
	}
	
	@FindBy(xpath="//span[text()='1']")
	private WebElement cart;
	
	public WebElement getcart() {
		return cart;
	}
	
	//checkout
	@FindBy(id="checkoutBtn")
	private WebElement checkout;
	
	public WebElement getcheckout() {
		return checkout;
	}
	
	
	
	

}
