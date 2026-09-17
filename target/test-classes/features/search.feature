Feature: Search functionality
Scenario: User serach for valid product

Given User opens the application
When User enters a valid product "HP" in search box
And User clicks on search button
Then User should get a valid product display in the search field

Scenario: User serach for invalid product

Given User opens the application
When User enters a invalid product "Laptop" in search box
And User clicks on search button
Then User should get a  message about  no product match

Scenario: User serach without any product

Given User opens the application
When User didn't  enter a  product in search box
And User clicks on search button
Then User should get a  message about  no product match
