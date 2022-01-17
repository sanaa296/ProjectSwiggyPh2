package com.Simplilearn;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.Simplilearn.Pages.MainPageLocation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepsSwiggyMainPage {
	//static WebDriver driver;
	BrowserDriver bdriver;
	MainPageLocation MPage;
	String MainPageCity;
	String ActualPageurl;
	String ExpectedPageurl = "https://www.swiggy.com/restaurants";
	
	  @Given("user opens the {string} browser")
	    public void user_Open_Browser(String S) {
		  //System.out.println(S);
		  bdriver = new BrowserDriver();
		  Hooks.driver = bdriver.getdriver(S);
		  MPage = new 	MainPageLocation(Hooks.driver);
	    }
	    
	    
	    @When("user navigate to swiggy page")
	    public void user_Swiggy_Page() throws Throwable {
	    	//Hooks.driver.get("https://www.swiggy.com/");
	    	MPage.navigate();
	        //System.out.println("Swiggy open");
	        //Hooks.driver.manage().window().maximize();
	    }
	    
	    @And("user enter {string} location")
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
	    
	    @Then("user can see main page")
	    public void Check_mainPage() {
	    	ActualPageurl = MPage.getCurrentUrl();
	    	Assert.assertEquals(ActualPageurl,ExpectedPageurl);
	        //System.out.println("Swiggy Close"+ActualPageurl);
	    }
	    
}
