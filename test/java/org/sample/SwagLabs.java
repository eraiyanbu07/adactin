package org.sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SwagLabs {
	
	public WebDriver driver;
	
	@BeforeSuite 	
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

  @Test
  public void login() {
	  
	  driver.findElement(By.name("user-name")).sendKeys("standard_user");
	  driver.findElement(By.name("password")).sendKeys("secret_sauce");
	  driver.findElement(By.name("login-button")).click();
  }
  @Test
  public void selectTheProduct1() {
	  driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[1]")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheroduct1() {
	  driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[1]")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheProduct2() {
	  
	  driver.findElement(By.xpath("//img[@alt='Sauce Labs Bike Light']")).click();
	  driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheProduct3() {
	  
	  driver.findElement(By.xpath("//img[@alt='Sauce Labs Bolt T-Shirt']")).click();
	  driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheProduct4() {
	  
	  driver.findElement(By.xpath("(//img[@class='inventory_item_img'])[4]")).click();
	  driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheProduct5() {
	  
	  driver.findElement(By.xpath("//img[@alt='Sauce Labs Onesie']")).click();
	  driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  @Test
  public void selectTheProduct6() {
	  
	  driver.findElement(By.xpath("//img[@alt='Test.allTheThings() T-Shirt (Red)']")).click();
	  driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	  driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")).click();
  }
  
  @AfterSuite
  public void close() {
	  
	  driver.close();
  }
}
