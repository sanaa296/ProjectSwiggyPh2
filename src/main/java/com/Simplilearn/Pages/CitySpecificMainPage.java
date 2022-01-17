package com.Simplilearn.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CitySpecificMainPage {
	WebDriver driver;
	
	By BestinTown = By.linkText("BEST SELLERS");
	By Top2ndLink = By.xpath("//div[contains(@subtype,'topCarousel')][2]");
	
	By DelTime = By.xpath("//*[@id=\"all_restaurants\"]/div/div[1]/div/div/div/div[2]/div[2]");
	By Rating = By.xpath("//*[@id=\"all_restaurants\"]/div/div[1]/div/div/div/div[2]/div[3]");
	
	
	public CitySpecificMainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClickBestinTown() {
		driver.findElement(BestinTown).click();
	}
	
	public void ClickTopLink() {
		driver.findElement(Top2ndLink).click();
	}
	
	public void ClickDelTime() {
		driver.findElement(DelTime).click();
	}
	public void ClickRating() {
		driver.findElement(Rating).click();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
