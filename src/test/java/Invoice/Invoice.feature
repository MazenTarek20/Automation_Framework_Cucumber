Feature: Verify that the invoice updated after removing item from the cart
  Scenario Outline: Verification of updating the invoice
    Given noon website opened
    When user is searching for product
    And user added some items to cart "<ITEM_1>" "<ITEM_2>" "<ITEM_3>"
    And user navigate cart page
    And user removed "<removedItem>"
    Then verify that the invoice updated
    Examples:
      |ITEM_1|ITEM_2|ITEM_3||removedItem|
      |ITEM_1|ITEM_2|ITEM_3||removedItem|

