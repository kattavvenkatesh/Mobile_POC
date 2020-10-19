package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.Launch_Page;
import pages.Login_page;

public class Login_TestCase extends root_base.Base_Root{
	
	
	public Login_TestCase() {
		super();
		
	}
	
	@Test (priority = 1)
	
	public void launchandVerifys () throws Exception {
		
        test = extent.createTest("Test Case 1", "PASSED test case");
	
		
			Launch_Page.getPages()
			.validateHamburger_btn()
			.NavigatetoLoginScreen();
		
		test.log(Status.PASS, "Test Case suucessful");
		
	}
	
	@Test (priority = 2)
	
	public void validateLoginFunction() throws Exception {
		
		
			Login_page.getPages()
			.loginwith_InvalidUNandPW()
			.LoginWithoutCredentials()
			.Cancel_btnBehavior()
			.LoginWithValidCredentials();

		test.log(Status.FAIL, "Test Case Failing");

		
		
		
	}

}
