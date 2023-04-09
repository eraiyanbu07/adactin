package org.sample;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testing {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {

	// initializing driver variable using FirefoxDriver
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\georg\\\\eclipse-workspace\\\\EraiTestNG\\\\driver\\\\chromedriver.exe");
	driver=new ChromeDriver();
	// launching gmail.com on the browser
	driver.get("https://www.facebook.com/");
	// maximized the browser window
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,10, 5000);
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("eraiyanbu07@gmail.com");
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("12365478");
     	WebElement lgnbtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
		lgnbtn1 = driver.findElement(By.name("login"));
		lgnbtn1.click();
	}

	@AfterMethod
	public void teardown() {
	// closes all the browser windows opened by web driver
	driver.quit();
	}

	}
	


