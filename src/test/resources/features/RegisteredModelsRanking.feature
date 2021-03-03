Feature: Registered Models Ranking
  As a Buggy Cars Rating existing user
  I want to view the Rank of all registered models
  so that I can buy number 1 registered model


  Scenario: Ranking of registered models
    Given am on BuggyRates homepage
    When I view the list of all registered models
    Then the registered model with maximum votes gets a rank of '1'
    And the registered models are displayed in descending order of the rank
