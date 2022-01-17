package com.Simplilearn;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserDriver {

	WebDriver driver = null;
	final int implicit_waitTime=15;

	public WebDriver getdriver(String S) {
		
		if (driver == null) {
			String currPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currPath + "\\chromedriver.exe");
			
			switch(S) {
			
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
					throw new RuntimeException("incorrect browser");
			}
			driver.manage().window().maximize();
			Duration waitTime = Duration.ofSeconds(implicit_waitTime);
			driver.manage().timeouts().implicitlyWait(waitTime);

		}

		return driver;
	}

	
	/*
	 * public static void main(String[] s) throws Throwable{
	 * 
	 * BrowserDriver bdriver = new BrowserDriver(); WebDriver driver =
	 * bdriver.getdriver("edge"); Thread.sleep(8000); driver.quit(); }
	 */
	  
	 
}
