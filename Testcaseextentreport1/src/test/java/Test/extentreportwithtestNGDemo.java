package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreportwithtestNGDemo {
	WebDriver driver = null;
	ExtentSparkReporter spark;
	ExtentReports Extent;

	@BeforeSuite
	public void setup () {
		spark = new ExtentSparkReporter("index.html");
		Extent = new ExtentReports();

		Extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		
		

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1280,800");
		driver = new ChromeDriver(options);


	}

	@Test (groups = {"smoke"})
	public void testone () throws Exception {
		ExtentTest test1 = Extent.createTest("Test 1", "This is a sample test");
		test1.log(Status.INFO, "Starting Test Case");

		driver.get("https://login.yahoo.com");
		test1.pass("Navigated Successfully");


		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("bikramv@yahoo.com");

		test1.pass("Entered invalid value");
		Thread.sleep(2000);

		driver.findElement(By.name("signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createacc")).click();
		test1.pass("Navigated to create screen");

	}


	@Test(groups = {"sanity"})
	public void testtwo () throws Exception {
		ExtentTest test2 = Extent.createTest("Test 2", "This is a sample test");
		test2.log(Status.INFO, "Starting Test Case");

		driver.get("https://login.yahoo.com");
		test2.pass("Navigated Successfully");
	
	

		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("nivedita@yahoo.com");

		test2.pass("Entered invalid value");
		Thread.sleep(2000);

		driver.findElement(By.name("signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createacc")).click();
		test2.fail("Navigated to create screen");

	}

	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
		System.out.println("Completed");

		Extent.flush();

	}
}
