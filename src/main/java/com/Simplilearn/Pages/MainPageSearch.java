package com.Simplilearn.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPageSearch {
	
	WebDriver driver;
	
	
	//By linkl_Search= By.linkText("/search");
	By linkl_Search= By.xpath("(//span[contains(@class,'_3yZyp')])[5]");
	By SearchInput = By.xpath("//input[contains(@placeholder,'Search for restaurants or dishes')]");
	//By SearchInput = By.xpath("//input[contains(@class,'_2BJMh')]");
	//By SearchInput = By.xpath("//div[contains(@class,'_38pEg undefined')]");
	WebElement SearchInputLoc;
	
	

	public MainPageSearch(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SearchFood(String FoodItem) {
		
		System.out.println(FoodItem);
		
 		driver.findElement(linkl_Search).click();
//		SearchInputLoc = driver.findElement(SearchInput);
//		
//		Actions actions = new Actions(driver);
//		
//		actions.moveToElement(SearchInputLoc).build().perform();
 		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(SearchInput).sendKeys(FoodItem);
		driver.findElement(SearchInput).sendKeys(Keys.RETURN);
	}

//	public static void main(String[] args) throws Throwable {
//		WebDriver driver = new ChromeDriver();
//		MainPageLocation MPage = new MainPageLocation(driver);
//		MPage.navigate();
//		MPage.EnterLoc("New Delhi");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//              
//		MainPageSearch m1 = new MainPageSearch(driver);
//		m1.SearchFood("Chaap");
//	}
}
