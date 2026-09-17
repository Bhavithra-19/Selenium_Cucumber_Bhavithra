Feature: Register Account

  Background:
    Given User navigates to the  registration page
    
  Scenario: Login with all details
    When User enters registration details into below field
      	| firstName       | Ravi6       |
		| lastName        | S           |
		| telephone       | 1234567890  |
		| password        | Test@12345  |
		| confirmPassword | Test@12345  |
		| newsletter      | Yes         |


    And User selects the Privacy Policy
    And User clicks on Continue button
    Then User should be successfully registered
    
   

  
  