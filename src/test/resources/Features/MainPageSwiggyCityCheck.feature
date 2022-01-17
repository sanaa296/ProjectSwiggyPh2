Feature: Test Website Swiggy Location on MainPage
        
@multilocation      
Scenario Outline: Test multiple location in Swiggy site
        Given user opens the "chrome"
        When user navigate to swiggy location page
        And user enters "<city>" location
        Then  user Main Page city is "<result>"
        
        Examples:
        |city         |result       |
				|New Delhi    |New Delhi    |
				|Jalandhar    |Jalandhar    |
				|Chennai      |madras       |         
			