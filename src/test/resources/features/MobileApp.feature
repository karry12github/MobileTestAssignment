Feature: Validate the tests for Mobile App

  Scenario: Validate the login functionality for the Mobile app with Valid credentials
    Given the app is launched
    And Login with valid credentials
    And Validate the homePage of the mobileApp
    Then Logout of the App


  Scenario: Validate the login functionality for the Mobile app with InValid credentials
    Given the app is launched
    And Login with invalid credentials
    Then validate the error message "Username and password do not match any user in this service."

  Scenario: Validate the count of products displayed on the home page

    Given the app is launched
    And Login with valid credentials
    And Validate the homePage of the mobileApp
    Then get the count of number of products and validate if it is equal to 2
    Then Logout of the App
