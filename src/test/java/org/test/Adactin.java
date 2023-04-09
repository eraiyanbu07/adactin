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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Adactin extends BaseClass{
	
public WebDriver driver;
	 
	
	@BeforeSuite
		 public void setup() {
		 	  
		 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\driver\\chromedriver.exe");
		 	  
		 	driver = new ChromeDriver();
		 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	   
	}
	@BeforeTest
		 public void appSetup() {
		 	
		 	driver.get("http://adactinhotelapp.com/");
		 	driver.manage().window().maximize();
	}	 
	@Test(priority = 1)
	     public void login() throws InterruptedException {
		
		    WebElement e = driver.findElement(By.name("username"));
		    e.sendKeys("anbuerai");
		    WebElement p = driver.findElement(By.name("password"));
		    p.sendKeys("@Anbu1234");
		    WebElement l = driver.findElement(By.name("login"));
		    l.click();
		    Thread.sleep(3000);
	}
	@Test(priority = 2)
	     public void searchHotel() throws InterruptedException {
		
		    WebElement l = driver.findElement(By.name("location"));
		    Select s = new Select(l);
		    s.selectByVisibleText("New York");
		    WebElement h = driver.findElement(By.name("hotels"));
		    Select s1 = new Select(h);
		    s1.selectByVisibleText("Hotel Sunshine");
		    WebElement r = driver.findElement(By.name("room_type"));
		    Select s2 = new Select(r);
		    s2.selectByVisibleText("Deluxe");
		    WebElement nbrOfRoom = driver.findElement(By.name("room_nos"));
		    Select s3 = new Select(nbrOfRoom);
		    s3.selectByIndex(2);
		    WebElement chkIn = driver.findElement(By.name("datepick_in"));
		    chkIn.sendKeys("22/02/2023");
		    WebElement chkOut = driver.findElement(By.name("datepick_out"));
		    chkOut.sendKeys("24/02/2023");
		    WebElement adlt = driver.findElement(By.name("adult_room"));
		    Select s5 = new Select(adlt);
		    s5.selectByIndex(1);
		    WebElement child = driver.findElement(By.name("child_room"));
		    Select s6 = new Select(child);
		    s6.selectByIndex(0);
		    WebElement sbt = driver.findElement(By.name("Submit"));
		    sbt.click();
		   
		    Thread.sleep(3000);
		   
	}	  
	@Test(priority = 3)
	     public void confirmBooking() throws InterruptedException {
		
		    WebElement radiobtn = driver.findElement(By.id("radiobutton_0"));
		    radiobtn.click();
		    
		    if (radiobtn.isSelected()) {
		    	System.out.println("Radio button is selected");
				
			} else {
				System.out.println("Radio button is not selected");

			}
		    
		    WebElement clk = driver.findElement(By.xpath("(//input[@class='reg_button'])[1]"));
		    clk.click();
		
		
			     
	}
	@Test(priority = 4)
	     public void verification() throws InterruptedException {
		 
		    
		    WebElement fstname = driver.findElement(By.xpath("(//input[@class='reg_input'])[1]"));
		    fstname.sendKeys("Erai");
		    WebElement lstname = driver.findElement(By.xpath("(//input[@class='reg_input'])[2]"));
		    lstname.sendKeys("anbu");
		    WebElement adrs = driver.findElement(By.name("address"));
		    adrs.sendKeys("1/38 middlestreet,sellampattu(pt),chinnasalem(tk),kallakurichi(dt)-606207");
		    WebElement creditno = driver.findElement(By.name("cc_num"));
		    creditno.sendKeys("7894563210321654");
		    WebElement cardtype = driver.findElement(By.name("cc_type"));
		    Select s = new Select(cardtype);
		    s.selectByVisibleText("VISA");
		    WebElement expmnth = driver.findElement(By.name("cc_exp_month"));
		    Select s1 = new Select(expmnth);
		    s1.selectByVisibleText("May");
		    WebElement expyr = driver.findElement(By.name("cc_exp_year"));
		    Select s2 = new Select(expyr);
		    s2.selectByIndex(11);
		    WebElement cvvno = driver.findElement(By.name("cc_cvv"));
		    cvvno.sendKeys("058");
		    WebElement booknow = driver.findElement(By.name("book_now"));
		    booknow.click();
		    Thread.sleep(3000);
	}   
	@AfterTest
	      public void screenshot() throws InterruptedException, IOException {
		
		    TakesScreenshot ts = (TakesScreenshot)driver;
		    File source =ts.getScreenshotAs(OutputType.FILE);
		    File destination = new File("C:\\Users\\georg\\eclipse-workspace\\EraiTestNG\\screenshot.png");
		    FileUtils.copyFile(source, destination);
		    
		    System.out.println("The report is ready");
		    
		    
	}
	@AfterSuite
	      public void cleanup() {
		
		    driver.quit();
		    System.out.println("close the browser");
	}

  
}
