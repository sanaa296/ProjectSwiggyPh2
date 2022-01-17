package com.Simplilearn.GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Simplilearn.Pages.CitySpecificMainPage;
import com.Simplilearn.Pages.MainPageLocation;

public class GRIDhub {
	WebDriver driver;
	CitySpecificMainPage Main1;
	String currUrl;
	String ActualUrl;
	MainPageLocation MPage;
	
	@BeforeMethod
	public void beforeTest() {
		
		System.out.println("GRID before....");
	}
	
	@AfterMethod
	public void afterTest() {
		System.out.println("GRID after....");
		driver.close();
	}
	
	    @Test
		public void TestGrid1() throws Throwable{

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(Platform.WINDOWS);
		caps.setBrowserName("chrome");

		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url, caps);

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		
		MPage = new MainPageLocation(driver);
		MPage.navigate();
		MPage.EnterLoc("New Delhi");
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		Main1.ClickDelTime();
		String currUrl = Main1.getCurrentUrl();
		ActualUrl = "https://www.swiggy.com/restaurants?sortBy=DELIVERY_TIME";
		Assert.assertEquals(ActualUrl,currUrl);
		
	}

	@Test
	public void Testgrid2() throws Throwable{

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(Platform.WINDOWS);
		caps.setBrowserName("firefox");

		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url, caps);

		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		
		MPage = new MainPageLocation(driver);
		MPage.navigate();
		MPage.EnterLoc("New Delhi");
		
		Main1.ClickRating();
		String currUrl = Main1.getCurrentUrl();
		ActualUrl = "https://www.swiggy.com/restaurants?sortBy=RATING";
		Assert.assertEquals(ActualUrl,currUrl);
				
	}
}
