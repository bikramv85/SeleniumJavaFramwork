package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreports {

	WebDriver driver = null;

	@Test	
	public extentreports() throws InterruptedException {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");

		ExtentTest test1 = extent.createTest("Test 1", "This is a sample test");

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		test1.log(Status.INFO, "Starting Test Case");


		driver.get("https://login.yahoo.com");
		test1.pass("Navigated Successfully");


		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("bikramv@yahoo.com");
		test1.addScreenCaptureFromPath("screen1.png");

		test1.pass("Entered invalid value");
		Thread.sleep(2000);

		driver.findElement(By.name("signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createacc")).click();
		test1.pass("Navigated to create screen");
		driver.close();
		test1.info("Test Completed");

		ExtentTest test2 = extent.createTest("Test 2", "This is second sample test");

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		test2.log(Status.INFO, "Starting Test Case");


		driver.get("https://login.yahoo.com");
		test2.fail("Navigated Successfully");


		driver.manage().window().maximize();
		driver.findElement(By.id("login-username")).sendKeys("nivedita@yahoo.com");
		test2.pass("Entered invalid value");
		Thread.sleep(2000);

		driver.findElement(By.name("signin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("createacc")).click();
		test2.pass("Navigated to create screen");
		driver.close();
		test2.info("Test Completed");


		extent.flush();




	}


}
