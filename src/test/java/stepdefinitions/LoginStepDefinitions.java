package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixture.BaseFixture;
import pages.BRHomePage;
import pages.BRLoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinitions extends BaseFixture {

    private BRHomePage brHomePage;
    private BRLoginPage brLoginPage;
    private String errorMessage;

    @Given("^am on BuggyRates loginpage$")
    public void amOnBuggyRatesLoginpage() throws Throwable {
        brLoginPage = navigateToBRLoginPage();
    }

    @Given("^I enter username \"([^\"]*)\" and password$")
    public void iEnterUsernameAndPassword(String username) throws Throwable {
        brLoginPage.enterLoginDetails(username, "Navatha24$");
    }

    @When("^I login$")
    public void iLogin() throws Throwable {
        brHomePage = brLoginPage.clickLogin();
    }

    @When("^I attempt to login$")
    public void iAttemptToLogin() throws Throwable {
        brLoginPage.clickErrorLogin();
    }

    @Then("^am logged in successfully$")
    public void amLoggedInSuccessfuly() throws Throwable {
        assertThat(brHomePage.isLogOutButtonDisplayed(), is(true));
    }

    @Given("^I enter invalid username \"([^\"]*)\" or password \"([^\"]*)\"$")
    public void i_enter_invalid_username_or(String username, String password) throws Throwable {
        brLoginPage.enterLoginDetails(username, password);
    }

    @Then("^am not logged in successfully$")
    public void am_not_logged_in_successfully() throws Throwable {
        errorMessage = brLoginPage.getErrorMessageForInvalidLogin();
    }

    @And("^I can view the error message \"([^\"]*)\"$")
    public void i_can_view_the_error_message(String errormessage) throws Throwable {
        assertThat(errorMessage, is(errormessage));
    }

    @After("@logout")
    public void testEnd() {
        brLoginPage = brHomePage.clickLogout();
        assertThat(brLoginPage.isLogInButtonDisplayed(), is(true));
    }


}
