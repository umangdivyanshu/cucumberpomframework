Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forget password link
Given user is on login page
Then Forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "dec2020secondbatch@gmail.com"
And user enters password "Selenium@12345"
And user clics on login button
Then user gets the title of the page
And page title should be "My account - My Store123"