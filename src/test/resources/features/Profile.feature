Feature: Profile Updates
  As a Buggy Cars Rating user
  I want to update Profile info


  Scenario: Save Profile
    Given am logged in as BuggyRates user
    And profile additional info hobby is updated to "Drawing"
    When update is saved
    Then changes are saved with confirmation message "The profile has been saved successful"

  @default
  Scenario: Relogin to view updated changes to Profile
    Given I relogin as BuggyRates user
    When I view updated profile hobby info
    Then hobby is displayed as "Drawing" by default


