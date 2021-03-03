package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixture.BaseFixture;
import pages.BRHomePage;
import pages.BRLoginPage;

import java.util.*;

public class RankingStepDefinitions extends BaseFixture {

    private BRHomePage brHomePage;
    private BRLoginPage brLoginPage;
    HashMap<String, String> array =new HashMap<>();
    int[][] modifiedArray ;

    ArrayList<String> modifiedList =new ArrayList<>();

    @Given("^am on BuggyRates homepage$")
    public void am_on_BuggyRates_homepage() throws Throwable {
        brLoginPage=navigateToBRLoginPage();
        brLoginPage.enterLoginDetails("admin","Navatha24$");
        brHomePage=brLoginPage.clickLogin();
    }

    @When("^I view the list of all registered models$")
    public void i_view_the_list_of_all_registered_models() throws Throwable {
        brHomePage.clickListOfRegisteredUsers();
        array=brHomePage.listOfallElements();

    }
    @Then("^the registered models are displayed in descending order of the rank$")
    public void the_registered_models_are_displayed_in_descending_order_of_the_rank() throws Throwable {

        for(int i=0;i< array.size();i++) {

            String[] array2=array.get(i+1+"").split(";;");

            String[][] shades = new String[5][2];

            for (int r=0; r<array.size(); r++) {
                for (int c=0; c<shades[r].length; c++) {
                    shades[r][c]=array2[3];
                    shades[r+1][c+1]=array2[4];
                }
            }
            System.out.println(shades);

        }

    }

    @And("^the registered model with maximum votes gets a rank of '(\\d+)'$")
    public void the_registered_model_with_maximum_votes_gets_a_rank_of(int rank) throws Throwable {

        //array.get()

    }

}
