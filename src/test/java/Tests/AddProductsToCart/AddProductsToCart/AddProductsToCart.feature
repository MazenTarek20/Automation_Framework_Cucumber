Feature: Add Multiple products to cart
  Scenario Outline: Add multiple headphones to cart
    Given open the noon website
    When type headphones in search field
    And add "<ITEM_1>" and "<ITEM_2>" and "<ITEM_3>"
    And go to cart page
    Then verify added items in cart with details

    Examples:
      |ITEM_1|ITEM_2|ITEM_3|
      |ITEM_1|ITEM_2|ITEM_3|

