
Feature: Create new account and signin

Scenario: Signup on google site
Given Open the Chrome and open google site
When Fill all required fields
Then Click on signup button
And Enter user phone and confirmation code
And Complete user data birthday and gender
Then Accept creation terms


Scenario: Login with new credentials
Given Open SignIn site
When Enter email and password
Then SignIn with new credentials
