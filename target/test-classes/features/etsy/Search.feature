
Feature: Testing Search Functionality of Etsy Search Bar


  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Hat' in Etsy Webpage
    Then User validates the title 'Hat - Etsy' from Etsy

  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Key' in Etsy Webpage
    Then User validates the title 'Key - Etsy' from Etsy

  Scenario: Validation Title of Etsy Search for Hat
    Given User navigates to 'https://www.etsy.com/'
    When User searches for 'Pin' in Etsy Webpage
    Then User validates the title 'Pin - Etsy' from Etsy