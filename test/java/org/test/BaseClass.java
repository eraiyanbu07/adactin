package org.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;

	

	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}

	

	public static void fill(WebElement webElement, String text) {
		((WebElement) webElement).sendKeys(text);
	}

	public static void btnClick(WebElement lognButton) {
		((WebElement) lognButton).click();
	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void applyWaitToAllElement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void takeSnap(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\tajunissa\\Downloads\\eclipse-committers-oxygen-3a-win32-x86_64\\Selenium\\screenshot"
						+ filename + ".png");
		FileUtils.copyFile(src, dest);

	}

	public static void findsyDateTime() {
		Date d = new Date(0);
	}

	public static void endsyDateTime() {
		Date d = new Date(0);
	}

	public static void closeBrowser() {
		driver.quit();

	}

}
