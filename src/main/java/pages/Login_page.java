package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.Constants.Valid_UserName;
import static utilities.Constants.Valid_Password;
import static utilities.Constants.Invalid_UserName;
import static utilities.Constants.Invalid_Password;
import static utilities.Constants.Error_MESSAGE;
import static utilities.Constants.SUCCESS_MESSAGE;

public class Login_page extends rootbase.Base_Root<Login_page> {
	String Actualresult;
	private static Login_page  A= new Login_page();
	private Login_page() {
		
	}
		
	public  static Login_page getPages() {
		if(A==null) {
			A = new Login_page();
		}
		return A;
	} 
	
	
	protected static WebElement UserName_Textfield;
	protected static WebElement Password_Textfield;
	protected static WebElement Login_Btn;
	protected static WebElement Cancel_Btn;
	protected static WebElement Error_Msg;
	
	
	private static final String UserName = "com.malmstein.yahnac:id/login_username";
	private static final String Password = "com.malmstein.yahnac:id/login_password";
	private static final String LoginBtn = "com.malmstein.yahnac:id/login_login";
	private static final String CancelBtn= "com.malmstein.yahnac:id/login_cancel";
	private static final String ErrorMsg = "com.malmstein.yahnac:id/login_error_label";
	
	
	public Login_page loginwith_InvalidUNandPW() throws InterruptedException { // Try to login with Invalid credentials and validate the error message
		
		
		UserName_Textfield = driver.findElement(By.id(UserName));
		enterText(UserName_Textfield, Invalid_UserName);
		
		Password_Textfield = driver.findElement(By.id(Password));
		enterText(Password_Textfield, Invalid_Password);
		
		Login_Btn = driver.findElement(By.id(LoginBtn));
		clickonView(Login_Btn);
		
		Error_Msg = driver.findElement(By.id(ErrorMsg));
		Actualresult = Error_Msg.getText();
		Assertvalues(Actualresult, Error_MESSAGE);
		
		
		
		return this;
		
	}
	
	public Login_page LoginWithoutCredentials() throws InterruptedException { // Login without adding credentials 
		
		clearText(UserName_Textfield);
		clearText(Password_Textfield);
		clickonView(Login_Btn);
		Assertvalues(Actualresult, Error_MESSAGE);
		
		
		return this;
		
	}
	


	public Login_page Cancel_btnBehavior() throws InterruptedException { // Click on Login button and verify user is navigating to Launch page
		
		enterText(UserName_Textfield, Invalid_UserName);
		enterText(Password_Textfield, Invalid_Password);
		
		Cancel_Btn = driver.findElement(By.id(CancelBtn));
		clickonView(Cancel_Btn);
		VerifyElementisPresent(Launch_Page.Login_icon);
		

		return this;

	}
	

	public Login_page LoginWithValidCredentials() throws InterruptedException { // Login with valid credentials and Verify user is successfully logged in
		
		clickonView(Launch_Page.Login_icon);
		enterText(UserName_Textfield, Valid_UserName);
		enterText(Password_Textfield, Valid_Password);
		clickonView(Login_Btn);
		String Actualresult = Error_Msg.getText();
		Assertvalues(Actualresult, SUCCESS_MESSAGE);
		
		
		return this;
		
	}
	

}
