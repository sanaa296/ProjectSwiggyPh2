package com.Simplilearn;

import static org.testng.Assert.assertEquals;

import com.Simplilearn.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Simplilearn.Pages.MainPageLocation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepsSwiggyMainPageCityCheck {
	//static WebDriver driver;
	BrowserDriver bdriver;
	MainPageLocation MPage;
	String MainPageCity;
	String ActualPageurl;
	String ExpectedPageurl = "https://www.swiggy.com/restaurants";
	
	  @Given("user opens the {string}")
	    public void user_Open_Browser(String S) {
		  //System.out.println(S);
		  bdriver = new BrowserDriver();
		  Hooks.driver = bdriver.getdriver(S);
		  MPage = new 	MainPageLocation(Hooks.driver);
	    }
	    
	    
	    @When("user navigate to swiggy location page")
	    public void user_Swiggy_Page() throws Throwable {
	    	//Hooks.driver.get("https://www.swiggy.com/");
	    	MPage.navigate();
	        //System.out.println("Swiggy open");
	        //Hooks.driver.manage().window().maximize();
	    }
	    
	    @And("user enters {string} location")
	    public void enter_location(String city) {
	        //System.out.println("user enter city..."+city);
	        //Hooks.driver.findElementById("location").sendKeys(city);
	        //Hooks.driver.findElementByLinkText("FIND FOOD");
	        MPage.EnterLoc(city);
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    
	    @Then("user Main Page city is {string}")
	    public void Check_CityinmainPage(String result) {
	    	MainPageCity = MPage.getMainPageCity();
	    	Assert.assertEquals(MainPageCity,result);
	        //System.out.println("Swiggy Close"+ActualPageurl);
	    }
}
