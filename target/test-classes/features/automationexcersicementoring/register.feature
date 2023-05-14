Feature: Testing the Registration of New User

  Scenario: Happy Path of Registration
    Given User navigates to the automationExercise WebPage and validates the 'Automation Exercise'
    When User clicks signUp button and validates the 'New User Signup!' visible
    And User provides username 'darina' and email address 'darin78@gmail.com' and click sign up button
    And User verify  'ENTER ACCOUNT INFORMATION' message is visible
    And User provides Title, Name, Email, Password 'password', Date of birth 'day', 'month', 'year'
    And User selects Sign up for our newsletter! and Receive Special offers from our partners!
    And User provides 'Darina', 'Marina', 'Damar', '123 Green street', '456 Yellow street', 'United States', 'Florida', 'Miami', '33054', '3057894512'
    Then User clicks Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue button and validates 'Logged in as darina'
    Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
    And User clicks continue button







#due date tomorrow   HOMEWORK


