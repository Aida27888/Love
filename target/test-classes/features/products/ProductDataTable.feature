@regression

Feature: Validation of Product with Data Table

  Scenario: Validation of New Product Creation
    Given User navigates to product homepage and click order Button
    When User enters the product information product and quantity
    |product |MyMoney|
    |quantity| 4     |
    And User enters the address information name, street, city, zip
    |name  |  Ahmet      |
    |street| Green street|
    |city  | Miami       |
    |zip   |33045        |
    And User enters the payment information cardType, ardNumber, expireDate and click process button
    |cardType  | Visa      |
    |cardNumber|64654654654|
    |expireDate| 12/27     |
    Then User validates the message message
    | New order has been successfully added. |


