package Mavexreport.Repextent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentrepTest {
      
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		String paths=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(paths);
		reporter.config().setReportName("Web Automation report");
		reporter.config().setDocumentTitle("report tittle");
		
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "imdad khan");
	}
	
	
	@Test
	public void initialDemo() {
		
		 //ExtentTest tests=
		extent.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		//driver.close();
		//tests.fail("This test has been failed ");
		extent.flush();
		
	}
}
