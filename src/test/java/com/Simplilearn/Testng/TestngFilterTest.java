package com.Simplilearn.Testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Simplilearn.BrowserDriver;
import com.Simplilearn.Pages.CitySpecificMainPage;
import com.Simplilearn.Pages.FilterOptionPage;
import com.Simplilearn.Pages.MainPageLocation;
import com.Simplilearn.Pages.MainPageSearch;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestngFilterTest {
	WebDriver driver;
	BrowserDriver bdriver;
	MainPageLocation MPage;
	MainPageSearch MainSearch1 ;
	FilterOptionPage fil1;
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Testng before....");
		bdriver = new BrowserDriver();
		driver = bdriver.getdriver("chrome");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Testng after....");
		driver.close();
	}

	@Test
	public void CityMainPage() throws Throwable {
		MPage = new MainPageLocation(driver);
		MPage.navigate();
		MPage.EnterLoc("New Delhi");
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	
	@Test(dependsOnMethods = "CityMainPage")
	public void FilterTest()  {
	
		fil1 = new FilterOptionPage(driver);
		fil1.ClickFilterOption();
		fil1.ClickCuisine();
		fil1.ClickShowRestaurant();
        
	}

	@Test(dependsOnMethods = "CityMainPage")
	@Parameters({"FoodItem"})
	public void Search(String FoodItem) {
		MainSearch1 = new MainPageSearch(driver);
		MainSearch1.SearchFood(FoodItem);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	
}
