package com.Simplilearn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
static WebDriver driver;
	
	@Before
	public void beforeTest() {
		
		System.out.println("hooks before....");
		
	}
	
	@After
	public void afterTest() {
		System.out.println("hooks after....");
		driver.close();
	}


}
