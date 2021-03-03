package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixture.BaseFixture;
import org.openqa.selenium.support.ui.Wait;
import pages.BRHomePage;
import pages.BRLoginPage;
import pages.BRRegistrationPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationStepDefinitions extends BaseFixture {

    private BRLoginPage brLoginPage;
    private BRRegistrationPage brRegistrationPage;

    @Given("^am on BuggyRates registration page$")
    public void am_on_BuggyRates_registration_page() throws Throwable {
        brLoginPage=navigateToBRLoginPage();
        brRegistrationPage=brLoginPage.clickRegister();
        brRegistrationPage.isRegistrationpageDisplayed();
    }

    @Given("^I enter registration details$")
    public void i_enter_registration_details(DataTable registrationDetails) throws Throwable {
        brRegistrationPage.isRegistrationpageDisplayed();
        brRegistrationPage.enterRegistrationDetails(registrationDetails);
    }

    @When("^I register$")
    public void i_register() throws Throwable {
        brRegistrationPage=brRegistrationPage.clickRegister();

    }

    @Then("^am registered successfully with confirmation message \"([^\"]*)\"$")
    public void am_registered_successfully_with_confirmation_message(String message) throws Throwable {
        assertThat(message, is(brRegistrationPage.displaySuccessMessage()));
    }


}
