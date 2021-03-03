package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import fixture.BaseFixture;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"~@ignore"},
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/Cucumber", "json:target/cucumber.json"}
)
public class RunCukeTest extends BaseFixture {
}
