package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixture.BaseFixture;
import pages.BRHomePage;
import pages.BRLoginPage;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

public class RankingStepDefinitions extends BaseFixture {

    private BRHomePage brHomePage;
    private BRLoginPage brLoginPage;
    private String username = "admin";
    private String password = "Navatha24$";

    HashMap<String, String> carsMap = new HashMap<>();

    @Given("^am on BuggyRates homepage$")
    public void am_on_BuggyRates_homepage() throws Throwable {
        brLoginPage = navigateToBRLoginPage();
        brLoginPage.enterLoginDetails(username, password);
        brHomePage = brLoginPage.clickLogin();
    }

    @When("^I view the list of all registered models$")
    public void i_view_the_list_of_all_registered_models() throws Throwable {
        brHomePage.clickListOfRegisteredUsers();
        carsMap = brHomePage.getListOfCars();
    }

    @Then("^the buggy cars registered models are displayed in descending order of the rank$")
    public void the_registered_models_are_displayed_in_descending_order_of_the_rank() throws Throwable {

        String[] carDataFirstRow = carsMap.get("1").split(";;");
        String[] carDataSecondRow = carsMap.get("2").split(";;");
        String[] carDataThirdRow = carsMap.get("3").split(";;");

        int rankOneCarVotes = Integer.parseInt(carDataFirstRow[4]);
        int rankSecondCarVotes = Integer.parseInt(carDataSecondRow[4]);
        int rankThirdCarVotes = Integer.parseInt(carDataThirdRow[4]);

        assertThat(rankOneCarVotes, greaterThan(rankSecondCarVotes));
        assertThat(rankSecondCarVotes, greaterThan(rankThirdCarVotes));
    }

    @Then("^the registered model with maximum votes gets a rank of '(\\d+)'$")
    public void the_registered_model_with_maximum_votes_gets_a_rank_of(int rank) throws Throwable {
        String[] carDataFirstRow = carsMap.get("1").split(";;");
        int rowOneCarRank = Integer.parseInt(carDataFirstRow[3]);

        assertEquals(rowOneCarRank, rank);
    }

}
