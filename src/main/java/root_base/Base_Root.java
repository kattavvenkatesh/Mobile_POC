package root_base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public abstract class Base_Root <T> extends Test_setup {
	
	
	public boolean validateObjectExistence(String element) throws Exception { // Wait for the element, as we know Explicit wait is unconditionally handled
		 																	//in appium, so I have just created a logic for wait.

		int i = 0;
		int small_wait=2;
		int max_attempt=30;
		do {
			try {
				driver.findElement(By.id(element));
				Thread.sleep(small_wait * 4);
				return true;
			} catch (Exception e) {
				i++;
				Thread.sleep(small_wait);
			}
		} while (i < max_attempt);
		return false;
	}
	
	
	
	
	
	public T clickonView(WebElement Btn) { // This method can be used to click function
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
		
			
		wait.until(ExpectedConditions.visibilityOf(Btn));
		Btn.click();
		}catch(Exception e) {
			System.out.println("Button not found");
		}
		return (T) this;
	}
	
	public T Assertvalues(String Actual, String Expected) throws InterruptedException { // This method can be used for Asserts function
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(Actual, Expected);
		softAssertion.assertAll();
		return (T) this;
	}
	
	public T ScrollDown() { // This Method can be used for scroll down function
	
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height*0.8);
		int endy = (int) (size.height*0.2);
		int startx = size.width/2;
		new TouchAction(driver).press(startx, starty).waitAction(300).moveTo(startx, endy).release().perform();
		return (T) this;
	}
	
	public T enterText(WebElement fieldname, String Text) {  // This method can be used for type function
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
		wait.until(ExpectedConditions.visibilityOf(fieldname));// To Enter Text
		fieldname.clear();
		fieldname.sendKeys(Text);
		}catch(Exception e) {
			System.out.println("Element not found");
			
		}
		
		return (T) this;
		
	}
	
	public T VerifyElementisPresent(WebElement Btn) { // This method can be used to click function
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
		wait.until(ExpectedConditions.visibilityOf(Btn));
		Btn.isDisplayed();
		}catch(Exception e) {
			System.out.println("Button not found");
		}
		return (T) this;
	}
	
	
	public T clearText(WebElement fieldname) {  // This method can be used for clear the text 
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
		wait.until(ExpectedConditions.visibilityOf(fieldname));// To Enter Text
		fieldname.clear();
		}catch(Exception e) {
			System.out.println("Element not found");
			
		}
		
		return (T) this;
		
	}
	
	
	}
	