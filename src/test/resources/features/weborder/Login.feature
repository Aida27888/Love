
@regression

Feature: Testing Login Functionality of WebOrder page


Background: User navigates to page
 Given User navigates to WebOrderPage
@smoke
  Scenario: Testing positive Login(correct username and correct password)
#    Given User navigates to the WebOrder Page
    When User provides username 'guest1@microworks.com' and password 'Guest1!' for WebOrder
    Then User validates the title 'ORDER DETAILS - Weborder' from homepage

  Scenario: Testing positive Login(Correct username and correct password)
#    Given User navigates to the WebOrder Page
    When User provides username 'guest1@microworks.com' and password 'Ahmet' for WebOrder
    Then User validates the error message 'Sign in Failed'
    @ahmet
    Scenario: Testing negative Login(Wrong username and wrong password)
#     Given User navigates to the WebOrder Page
      When User provides username 'guest123@microworks.com' and password 'Ahmetkjhk' for WebOrder
      Then User validates the error message 'Sign in Failed'