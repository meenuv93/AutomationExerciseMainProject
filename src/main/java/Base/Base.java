package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base
{
    public WebDriver driver;

    ExtentHtmlReporter report;
    ExtentTest test;
    ExtentReports extent;

    @BeforeTest
    public void start()
    {
        report = new ExtentHtmlReporter("MainReport/mainProjectReport.html");

        report.config().setDocumentTitle("Automation Testing");
        report.config().setReportName("E-Commerce Website Testing");
        report.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(report);

        extent.setSystemInfo("Hostname", "Localhost");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Testername", "Meenu");
        extent.setSystemInfo("Browser", "Chrome");

        driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");
    }

    @BeforeMethod
    public void second()
    {
        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterMethod
    public void browserclose(ITestResult result)
    {
    	test=extent.createTest(result.getName());
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		test.log(Status.FAIL, "Test case failed"+""+result.getName());
    		test.log(Status.FAIL, "Test case failed"+""+result.getThrowable());
    	}
    	else if (result.getStatus()==ITestResult.SKIP) 
    	{
    		test.log(Status.SKIP, "Test case skipped"+result.getName());
    		test.log(Status.SKIP, "Test case skipped"+result.getThrowable());
    	}
    	else if (result.getStatus()==ITestResult.SUCCESS) 
    	{
    		test.log(Status.PASS, "Test case passed" + result.getName());
    	}
    }
    	@AfterTest
    	public void end()
    	{
    		driver.quit();
    		extent.flush();
    	}
}