package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launch_Page extends root_base.Base_Root<Launch_Page>  {
	WebDriverWait wait = new WebDriverWait(driver, 60);

	private static Launch_Page  A= new Launch_Page();
	private Launch_Page() {
		
	}
		
	public  static Launch_Page getPages() {
		if(A==null) {
			A = new Launch_Page();
		}
		return A;
	} 
	
	
	protected static WebElement Hamburger_btn;
	protected static WebElement Outer_fram;
	protected static WebElement Login_icon;
	
	
	private static final String Menu_btn= "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
	
	private static final String outer_frame = "com.malmstein.yahnac:id/main_content";
	
	private static final String Login_Icon = "com.malmstein.yahnac:id/view_drawer_header_login";
	
	
	public Launch_Page validateHamburger_btn() throws Exception { // Verifying Hamburger button is present or not
		
		Hamburger_btn = driver.findElement(By.xpath(Menu_btn));
		//Outer_fram = driver.findElement(By.id(outer_frame));
		//clickonView(Outer_fram);
		VerifyElementisPresent(Hamburger_btn);
		return this;
		
	}
	
	public Launch_Page NavigatetoLoginScreen() { // Navigating to Login screen
	

	clickonView(Hamburger_btn);
	Login_icon = driver.findElement(By.id(Login_Icon));
	clickonView(Login_icon);
	
	return this;
	
	}
	
	
	
	
	
}
