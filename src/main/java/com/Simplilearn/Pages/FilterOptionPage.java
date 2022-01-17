package com.Simplilearn.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterOptionPage {
	
	int implicit_waitTime = 15;
	WebDriver driver;
	//List<WebElement> checkbox;
	List<WebElement> checkbox2;
	int FilterSize;
	WebDriverWait wait;
	
	By FilterOp = By.xpath("//span[contains(@class,'h0xOG')]");
	By CuisineAsian = By.xpath("(//div[contains(@class, 'MsBqD')])[2]");
	//By CuisineIndian = By.xpath("(//div[contains(@class, 'MsBqD')])[2]");
	//By CuisineItalian = By.xpath("(//div[contains(@class, 'MsBqD')])[2]");
	String CuisineFilter = "//div[contains(@class, 'MsBqD')]";
	By ShowRestaurant = By.linkText("SHOW RESTAURANTS");
	By FilterCuisine;
	
	public FilterOptionPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void ClickFilterOption() {
		driver.findElement(FilterOp).click();
		Duration waitTime = Duration.ofSeconds(implicit_waitTime);
		driver.manage().timeouts().implicitlyWait(waitTime);
	}
	//driver.findElementByXPath("(//i[contains(@class,\"a-icon a-icon-checkbox\")])[1]").click();
	
	public void ClickCuisine() {
		driver.findElement(CuisineAsian).click();
//		Duration waitTime = Duration.ofSeconds(implicit_waitTime);
//		driver.manage().timeouts().implicitlyWait(waitTime);
	}
	
	public void ClickCuisine(String cuisine) {
		
		System.out.println(cuisine);
		
		//checkbox = driver.findElements(By.name("CUISINES"));
		checkbox2 = driver.findElements(By.className("MsBqD"));
        FilterSize = checkbox2.size();     
        
        
        for(int i=0; i < FilterSize; i++){   
        	//String val = checkbox.get(i).getAttribute("value");
        	String val = checkbox2.get(i).getText();
        	
        	// check box name stored to the string variable, using ‘Value' attribute
        	//System.out.println(val);
 
        	if (val.equalsIgnoreCase(cuisine)){       
        		// Selecting the check box if its value is same as that we are looking for
        		System.out.println("CuisineFilter"+i);
        		//FilterCuisine = By.xpath("(//div[contains(@class, 'MsBqD')])[i]");
        		//driver.findElement(FilterCuisine).click();
        		        		
        		Actions actions = new Actions(driver);
        		
        		actions.moveToElement(checkbox2.get(i)).build().perform();

        		checkbox2.get(i).click();
        		
        		break;
        	}
        }
	}
	public void ClickShowRestaurant() {
		driver.findElement(ShowRestaurant).click();
	}

	public String getCurrentUrl() {

		return driver.getCurrentUrl();
	}

	
}
