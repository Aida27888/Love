
Feature: Testing Search Functionality of Etsy Search Bar Scenario Outline


  Scenario Outline: Validation Title of Etsy Search for Hat
    Given User navigates to '<url>'
    When User searches for '<key>' in Etsy Webpage
    Then User validates the title '<title>' from Etsy
    Examples:
      | url                   | key | title      |
      | https://www.etsy.com/ | Hat | Hat - Etsy |





