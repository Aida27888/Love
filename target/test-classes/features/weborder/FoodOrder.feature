
@regression
Feature: Testing Food Order Functionality of WebOrder page

  Background:
    Given User navigates to the WebOrder Page and login successfully
    And User validates the title 'ORDER DETAILS - Weborder' from order page
    When User on Order Page clicks Group Order box and Next button
    Then User sends the word 'Enjoy ur Pizza' for Note to Invitees part
    And User sends email which are 'aidahh77@gmail.com' and 'mehmet777@gmail.com' for Invite List
@smoke @ahmet
  Scenario: Testing WebOrder page Food Order Functionality
    And User choose the delivery address 'My House' and validate the address '3137 Laguna Street'
    And User clicks the create Group Order button
    Then User validates the header of page is 'View Group Order'

@ahmet
  Scenario: Testing WebOrder page Food Order for Functionality Office
    And User choose the delivery address 'Office' and validate the address '2012 EMPIRE BLVD'
    And User clicks the create Group Order button
    Then User validates the header of page is 'View Group Order'


