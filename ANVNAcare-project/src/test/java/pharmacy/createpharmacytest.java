package pharmacy;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.baseclass;
import generic_utility.file_utility;
import repoobject.home_page;
import repoobject.login_page;
import repoobject.pharmacyfillpage;
@Listeners(listener_utility.list_imp.class)
public class createpharmacytest extends baseclass {
	@Test
	public void pharmtest() throws IOException, ParseException {
		Actions act=new Actions(driver);
		//login
		//homepage in pharmacy
		home_page hp=new home_page(driver);
		WebElement pharmacy=hp.getpharmacy();
		pharmacy.click();
		
		//addtocart
		pharmacyfillpage pfp=new pharmacyfillpage(driver);
		WebElement addtocart=pfp.getaddtocart();
		
		act.scrollToElement(addtocart).perform();
		addtocart.click();
		
		//cart
		WebElement cart=pfp.getcart();
		cart.click();
		
		//checkout
		WebElement checkout=pfp.getcheckout();
		act.scrollToElement(checkout).perform();
		//act.scrollByAmount(0,950);
		checkout.click();
		
	
			
		
	}
	

}
