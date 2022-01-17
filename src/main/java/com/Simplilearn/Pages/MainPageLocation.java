package com.Simplilearn.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Simplilearn.ReadProperties;

public class MainPageLocation {
	WebDriver driver;
	String city;
	
 	//String page_url="https://www.swiggy.com/";
	
	
	By id_Loc = By.id("location");
	By linkl_loc= By.linkText("FIND FOOD");
	By loc_Opfirst = By.xpath("(//span[contains(@class,'_2W-T9')])[1]");
	By loc_cityMainPage = By.xpath("//span[contains(@class,'_3odgy')]");
	

	public MainPageLocation(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigate() throws Throwable {
		String url=ReadProperties.getProperties("loginUrl");
		//System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	  public String getCurrentUrl() {
	  
	  return driver.getCurrentUrl(); 
	  }
	 
	
	public void EnterLoc(String city) {
		
		driver.findElement(id_Loc).sendKeys(city);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(loc_Opfirst).click();
			
	}
	
	public String getMainPageCity() {
		
		  String text = driver.findElement(loc_cityMainPage).getText();		  
		  return text; 
		  }
	
}
