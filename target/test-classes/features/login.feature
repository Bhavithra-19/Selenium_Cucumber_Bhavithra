Feature: Login functionality

Scenario:Login with valid credentials .
Given User has navigated to login page
When User enters valid email "Bhaviravi@gmail.com" into email field
And User enters valid password "Bhaviravi" into password field
And User clicks on login button
Then User should successfully logged in.

Scenario:Login with invalid credentials .
Given User has navigated to login page
When User enters invalid email into email field
And User enters invalid password "Bhaviraviwq" into password field
And User clicks on login button
Then User should get a warning message

Scenario:Login with valid email and invalid password 
Given User has navigated to login page
When User enters valid email "Bhaviravi@gmail.com" into email field
And User enters invalid password "Bhaviravi123" into password field
And User clicks on login button
Then User should get a warning message

Scenario:Login with invalid email and valid password 
Given User has navigated to login page
When User enters invalid email into email field
And User enters valid password "Bhaviravi" into password field
And User clicks on login button
Then User should get a warning message

Scenario:Login with empty fields 
Given User has navigated to login page
When User doesn't enter email into email field
And User doesn't enter password into password field
And User clicks on login button
Then User should get a warning message







