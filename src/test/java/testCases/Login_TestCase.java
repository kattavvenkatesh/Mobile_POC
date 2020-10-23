package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.Launch_Page;
import pages.Login_page;

public class Login_TestCase extends rootbase.Base_Root{
	ExtentTest test;
	
	public Login_TestCase() {
		super();
		
	}
	
	@Test (priority = 1)
	
	public void launchandVerifys () throws InterruptedException {
		
	//testcreateTest("Test Case 1", "PASSED test case1");
	//test.log(Status.PASS, "Test Case suucessful");
		Launch_Page.getPages()
		.validateHamburger_btn()
		.NavigatetoLoginScreen();
		
	}
	
	@Test (priority = 2)
	
	public void validateLoginFunction() throws InterruptedException {
		
		//test = extent.createTest("Test Case 2", "FAIL test case2");
		//test.log(Status.FAIL, "Test Case Failing");

		Login_page.getPages()
		.loginwith_InvalidUNandPW()
		.LoginWithoutCredentials()
		.Cancel_btnBehavior()
		.LoginWithValidCredentials();
		
		
		
		
	}

}
