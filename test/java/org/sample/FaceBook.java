package org.sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class FaceBook {

	public WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() throws IOException {

		driver.quit();
		System.out.println("close the browser");
	}

	@Test(priority = 1)
	public void f() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("eraiyanbu07@gmail.com");
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("12365478");
		WebElement lgnbtn1 = WebDriverWait();
		lgnbtn1 = driver.findElement(By.name("login"));
		lgnbtn1.click();
		String exp = "The password that you've entered is incorrect. Forgotten password?";
		WebElement errmsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String act = errmsg.getText();
		Assert.assertEquals(act, exp);
		System.out.println("The error message is :" + act);
		 	 
	}

	@Test(priority = 2)

	public void login() {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(10))
				    .pollingEvery(Duration.ofMillis(500))
				    .ignoring(NoSuchElementException.class);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).clear();
		WebElement username1 = driver.findElement(By.name("email"));
		username1.sendKeys("12365478");
		WebElement password1 = driver.findElement(By.name("pass"));
		password1.sendKeys("@anbu1234");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
		WebElement lgnbtn1 = driver.findElement(By.name("login"));
		lgnbtn1.click();
		String exp1 = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		WebElement errmsg1 = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String act1 = errmsg1.getText();
		Assert.assertEquals(act1, exp1);
		System.out.println("The erroe message is :" + act1);

	}

	@BeforeTest
	public void beforeTest() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\screenshot.png");
		FileUtils.copyFile(source, destination);

	}

}
