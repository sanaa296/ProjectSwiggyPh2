package com.Simplilearn.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "com.Simplilearn",
        tags = "@multilocation",
        plugin = {"html:target/SwiggyTestReport.html"}
)

public class TestRunner2 extends AbstractTestNGCucumberTests{
	
	@DataProvider
	@Override
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}


}
