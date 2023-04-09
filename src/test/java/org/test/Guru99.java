package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99 {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\driver\\chromedriver.exe");
		driver =new ChromeDriver();
	}
	@BeforeTest
	public void launchUrl() {
		
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}
	@Test
	public void testCase1() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//div[@class='canvas-middle'])[7]")).click();
		driver.findElement(By.xpath("(//span[text()='Testing']")).click();
		driver.findElement(By.xpath("(//li[@class='menu-item menu-item-type-custom menu-item-object-custom current-menu-item menu-item-4600'])[1]")).click();
		
		
		
		
		
		
	}
  
}
