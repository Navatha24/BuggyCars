Feature: Register
  As a Buggy Cars Rating new user
  I want to register
  so that I can login to view buggy ratings

  Scenario: Successful registration
    Given am on BuggyRates registration page
    And I enter registration details
      | Fields          | Values        |
      | Login           | administrator |
      | FirstName       | John          |
      | Lastname        | Kennedy       |
      | Password        | Testing123$   |
      | ConfirmPassword | Testing123$   |
    When I register
    Then am registered successfully with confirmation message "Registration is successful"

