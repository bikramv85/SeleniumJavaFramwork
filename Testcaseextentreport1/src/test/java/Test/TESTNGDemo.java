package Test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import config.propertiesfiledemo;
import demo.Log4jdemo;

public class TESTNGDemo {
	WebDriver driver = null;
	ExtentSparkReporter spark;
	ExtentReports Extent;
	
	
	public static String browsername = null;
	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Log4jdemo.class);
	
	@BeforeTest
	public void setUpTest() {
		spark = new ExtentSparkReporter("index.html");
		Extent = new ExtentReports();

		Extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		
		propertiesfiledemo.getProperties();
		
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty(browsername, browsername);
		}


	}


	@Test
	public void pagenavigate () throws InterruptedException {
		ExtentTest test1 = Extent.createTest("Test 1", "This is a sample test");
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://login.yahoo.com");
		driver.manage().window().maximize();
		test1.pass("Navigated Successfully");
		
		WebElement username = driver.findElement(By.id("login-username"));
		username.sendKeys("bikramv@yahoo.com");
		Thread.sleep(2000);
		
		test1.pass("Entered invalid value");

		driver.findElement(By.name("signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createacc")).click();
		
		test1.pass("Navigated to create screen");
	}

	@AfterTest
	public void endTest() throws Exception {

		Thread.sleep(2000);
		driver.close();
		System.out.println("Test Completed");
		propertiesfiledemo.setproperties();
		logger.info("Information Message");
		logger.error("ErrorMessage");
		logger.warn("warnMessage");
		logger.fatal("fatalMessage");
		logger.trace("Trace Message");
		Extent.flush();
		


	}

}