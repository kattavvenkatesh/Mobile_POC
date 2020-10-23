package rootbase;


import java.io.FileInputStream;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.yara.utils.ResourceUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test_setup <T>{
	
	
	public static AppiumDriver<MobileElement> driver;
	private static ResourceUtility resourceUtility;
    ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
	
    
    @BeforeClass
	
	public T initialization() throws InterruptedException {
		
    	
		try {
			resourceUtility = new ResourceUtility("config");;
			String platformName = resourceUtility.getResource("platformName");
			String platformVersion = resourceUtility.getResource("platformVersion");
			String deviceName = resourceUtility.getResource("deviceName");
			String udid = resourceUtility.getResource("udid");

			System.out.println("Launching App");
			DesiredCapabilities cap= new DesiredCapabilities();
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("udid", udid);
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion); 
			cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/Resources/app-debug.apk");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver= new AppiumDriver<MobileElement>(url,cap);
			cap.setCapability("noReset", false);
			cap.setCapability("fullReset", true);

			

		}

		catch (Exception e) {

			System.out.println(e);
			
		}
			return (T) this;
		

	}	
	
	@BeforeTest
	public T startReport(){
	
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setEncoding("utf-8");
	        
	
	        return (T) this;
	}
	
	
	
  //@AfterMethod
    public T getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        
        	return (T) this;
    }
    
    
   // @AfterTest
    public T tearDown() {
    	//to write or update test information to reporter
        extent.flush();
    
        return (T) this;
    
    
    }

}
