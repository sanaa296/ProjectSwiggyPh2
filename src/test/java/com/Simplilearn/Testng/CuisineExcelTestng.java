package com.Simplilearn.Testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Simplilearn.BrowserDriver;
import com.Simplilearn.ReadExcel;
import com.Simplilearn.Pages.CitySpecificMainPage;
import com.Simplilearn.Pages.FilterOptionPage;
import com.Simplilearn.Pages.MainPageLocation;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CuisineExcelTestng {
	WebDriver driver;
	BrowserDriver bdriver;
	MainPageLocation MPage;
	//CitySpecificMainPage Main1 ;
	FilterOptionPage fil1;
	String curUrl;
	final int implicit_waitTime=15;
	
		
		@BeforeMethod
		public void beforeTest() {
			
			System.out.println("Testng before....");
			//bdriver = new BrowserDriver();
			//driver = bdriver.getdriver("chrome");
		}
		
		@AfterMethod
		public void afterTest() {
			System.out.println("Testng after....");
			driver.close();
		}
	
		@Test
		@DataProvider(name="excelTestdata")
		public Object[][] getdata(){
			String projectPath=System.getProperty("user.dir");
			String excelFilePath=projectPath+"/Phase2Swiggy.xlsx";
			
			Object[][] obj=ReadExcel.loadExcel(excelFilePath, 0,true);
			
			return obj;
			
		}

		@Test(dataProvider = "excelTestdata")
		public void FilterCuisine(String cuisine,String urlCheck) throws Throwable{
			bdriver = new BrowserDriver();
			driver = bdriver.getdriver("chrome");
			//System.out.println("Cuisine="+cuisine+", url="+urlCheck);
			
			MPage = new MainPageLocation(driver);
			MPage.navigate();
			MPage.EnterLoc("New Delhi");
			
			fil1 = new FilterOptionPage(driver);
			fil1.ClickFilterOption();
			fil1.ClickCuisine(cuisine);
			
			fil1.ClickShowRestaurant();
			
			Thread.sleep(10000);
			
			curUrl = fil1.getCurrentUrl();
			Assert.assertEquals(curUrl, urlCheck);
		}

}
