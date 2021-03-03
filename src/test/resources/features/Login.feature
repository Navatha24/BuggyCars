Feature: Login
  As a Buggy Cars Rating existing user
  I want to login
  so that I can view buggy ratings

  @logout
  Scenario Outline: Successful login
    Given am on BuggyRates loginpage
    And I enter username "<username>" and password
    When I login
    Then am logged in successfully
    Examples:
      | username |
      | admin    |
      | admin2   |

  @ignore
  Scenario Outline: UnSuccessful login
    Given am on BuggyRates loginpage
    And I enter invalid username "<username>" or password "<password>"
    When I attempt to login
    Then am not logged in successfully
    #And I can view the error message "<errormessage>"
    Examples:
      | username | password   | errormessage              |
      | admin    | Navatha    | invalid username/password |
      | adminx   | Navatha24$ | invalid username/password |
