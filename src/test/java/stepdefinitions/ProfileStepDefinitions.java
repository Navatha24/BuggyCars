package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixture.BaseFixture;
import pages.BRHomePage;
import pages.BRLoginPage;
import pages.BRProfilePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfileStepDefinitions extends BaseFixture {

    private BRLoginPage brLoginPage;
    private BRHomePage brHomePage;
    private BRProfilePage brProfilePage;

    @Given("^am logged in as BuggyRates user$")
    public void am_logged_in_as_BuggyRates_user() throws Throwable {
        brLoginPage=navigateToBRLoginPage();
        brLoginPage.enterLoginDetails("admin","Navatha24$");
    }

    @And("^profile additional info hobby is updated to \"([^\"]*)\"$")
    public void profile_additional_info_hobby_is_updated_to(String updatedHobby) throws Throwable {
        brHomePage=brLoginPage.clickLogin();
        brProfilePage=brHomePage.clickProfile();
        assertThat(brProfilePage.isAdditionalInfoDisplayed(), is(true));

        brProfilePage.updateHobby(updatedHobby);
    }

    @When("^update is saved$")
    public void update_is_saved() throws Throwable {
        brProfilePage.clickSave();
    }

    @Then("^changes are saved with confirmation message \"([^\"]*)\"$")
    public void changes_are_saved_with_confirmation_message(String message) throws Throwable {
        assertThat(brProfilePage.getConfirmationMessage(),is(message));

        brLoginPage=brHomePage.clickLogout();
        assertThat(brLoginPage.isLogInButtonDisplayed(), is(true));
    }

    @Given("^I relogin as BuggyRates user$")
    public void i_relogin_as_BuggyRates_user() throws Throwable {
        brLoginPage=navigateToBRLoginPage();
        brLoginPage.enterLoginDetails("admin","Navatha24$");
        brHomePage=brLoginPage.clickLogin();
    }

    @When("^I view updated profile hobby info$")
    public void i_view_updated_profile_hobby_info() throws Throwable {
        brProfilePage=brHomePage.clickProfile();
        String message=brProfilePage.getDefaultHobbyDisplay();
    }

    @Then("^hobby is displayed as \"([^\"]*)\" by default$")
    public void hobby_is_displayed_as_by_default(String message) throws Throwable {
        assertThat(brProfilePage.getDefaultHobbyDisplay(),is(message));
    }

    @After("@default")
    public void defaultSetUp(){
        brProfilePage.updateHobby("Hiking");
        brProfilePage.clickSave();
        brLoginPage=brHomePage.clickLogout();
    }

}
