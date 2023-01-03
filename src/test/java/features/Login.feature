Feature: Login into Application

Scenario Outline: Positive test validating login
Given Intialize the browser with chrome
And navigate to "http://www.qaclickacademy.com" site
And click on login link in homepage to land on Secure signin page
When User enters <username> and <password> and logs in
Then verify that user is successfully logged in

Examples:
|username		|password	|
|test99@gmail.com	|hi	|
|test3@gmail.com	|hello	|

