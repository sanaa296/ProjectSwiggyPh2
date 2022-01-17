Feature: Test Website Swiggy Location Page

@sanity
Scenario: Test location in Swiggy site
        Given user opens the "chrome" browser
        When user navigate to swiggy page
        And user enter "New Delhi" location
        Then user can see main page       
				
@multibrowser
Scenario Outline: Test multiple location in Swiggy site
        Given user opens the "<browser>" browser
        When user navigate to swiggy page
        And user enter "New Delhi" location
        Then user can see main page
        Examples:
        |browser         |
				|chrome       	 |
				|firefox       	 |
				|edge          	 |