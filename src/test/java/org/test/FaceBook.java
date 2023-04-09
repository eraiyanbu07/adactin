package org.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FaceBook {
	
	public WebDriver driver;
	
	@Test(priority = 1)
	public void login1() {
		
		driver.findElement(By.name("email")).sendKeys("eraiyanbu07@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Eraiyanbu");
		driver.findElement(By.name("login")).click();		
		String exp = "The password that you've entered is incorrect. Forgotten password?";
		WebElement errmsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String act = errmsg.getText();
		Assert.assertEquals(act, exp);
		System.out.println("The error message is :" + act);
		 	 
	}
	@Test(priority = 2)
	public void login2() {
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("email")).sendKeys("0000004569");
		driver.findElement(By.name("pass")).sendKeys("anbu1234");
		driver.findElement(By.name("login")).click();		
		String exp = "Wrong credentials\n"
				+ "Invalid username or password";
		WebElement errmsg = driver.findElement(By.xpath("//div[@class='pam _3-95 _9ay3 uiBoxRed']"));
		String act = errmsg.getText();
		Assert.assertEquals(act, exp);
		System.out.println("The error message is :" + act);
	}
	@Test(priority = 3)
	public void login3() {
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("pass")).sendKeys("");
		driver.findElement(By.name("login")).click();		
		String exp = "Wrong credentials\n"
				+ "Invalid username or password";
		WebElement errmsg = driver.findElement(By.xpath("//div[@class='pam _3-95 _9ay3 uiBoxRed']"));
		String act = errmsg.getText();
		Assert.assertEquals(act, exp);
		System.out.println("The error message is :" + act);
		
	}
	@Test(priority = 4)
	public void login4() {
		
		driver.findElement(By.name("email")).sendKeys("eraiyanbu07@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("12365445");
		driver.findElement(By.name("login")).click();

		try {

			WebElement e = driver.findElement(By.xpath("//label"));
			e.isDisplayed();

		} catch (Exception e) {
			String exp = "The password that you've entered is incorrect. Forgotten password?";
			WebElement errmsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
			String act = errmsg.getText();
			Assert.assertEquals(act, exp);
			System.out.println("The error message is:" + act);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("pass")).clear();
		    driver.findElement(By.name("email")).sendKeys("eraiyanbu07@gmail.com");
			driver.findElement(By.name("pass")).sendKeys("@anbu1234");
			driver.findElement(By.name("login")).click();

			System.out.println("Successfully login");
		}
	}
	
	@BeforeTest
	public void beforeTest() {

		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\screenshot.png");
		FileUtils.copyFile(source, destination);
	}

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		
		driver.close();
		
		
	}
  
}
