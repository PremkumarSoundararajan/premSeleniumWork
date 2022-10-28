Feature: Find Trellis page when searching for "natural gas accounting software"

  Scenario: Search for natural gas accounting software in Google and see if Trellis Energy shows up
    Given The user opens the Google search page
    When The user types "natural gas accounting software"
    And The user clicks the search button
    Then The search result shows "https://trellisenergy.com"
