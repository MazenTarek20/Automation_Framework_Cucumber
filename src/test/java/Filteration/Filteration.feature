Feature: Filtering the results by price and recommendations
  Scenario Outline: Using filtering functions
    Given open noon website home page
    When move to category option and choose samsung
    And get filter by price and provide "<maximumValue>" and "<minimumValue>"
    Then select filter by most recommended

    Examples:
      | maximumValue | minimumValue |
      | maximumValue | minimumValue |

