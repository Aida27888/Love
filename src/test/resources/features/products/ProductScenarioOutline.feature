
@regression1

Feature: Validation of Product

  Scenario Outline: Validation of New Product Creation
    Given User navigates to product homepage and click order Button
    When User enters the product information '<product>' and '<quantity>'
    And User enters the address information '<name>','<street>','<city>','<zip>'
    And User enters the payment information '<cardType>', '<cardNumber>', '<expireDate>' and click process button
    Then User validates the message '<message>'
    And User clicks view All orders button and validates '<name>', '<product>', '<quantity>', '<street>', '<city>', '<zip>', '<cardType>', '<cardNumber>', '<expireDate>'


    Examples:
      | product     | quantity | name  | street       | city  | zip   | cardType         | cardNumber   | expireDate | message                                |
      | MyMoney     | 4        | Ahmet | Green street | Miami | 33045 | Visa             | 128932132132 | 06/21      | New order has been successfully added. |
      | FamilyAlbum | 2        | Ahmet | Green street | Miami | 33045 | MasterCard       | 125132985132 | 06/26      | New order has been successfully added. |
      | ScreenSaver | 6        | Ahmet | Green street | Miami | 33045 | American Express | 123132992132 | 06/25      | New order has been successfully added. |



























#      | name        | product     | date       | quantity     | street       | city  | zip              | cardType         | cardNumber   | expireDate                             |
#      | Ahmet       | MyMoney     | 12/28/2022 | 4            | Green street | Miami | 33045            | Visa             | 128932132132 | 06/21                                  |
#      | Ahmet       | FamilyAlbum | 12/28/2022 | 2            | Green street | Miami | 33045            | MasterCard       | 125132985132 | 06/26                                  |
#      | Ahmet       | ScreenSaver | 12/28/2022 | 6            | Green street | Miami | 33045            | American Express | 123132992132 | 06/25                                  |





#  name, product,  quantity,  date,  street,  city,
#  zip,  card,  cardnumber,  expdate









