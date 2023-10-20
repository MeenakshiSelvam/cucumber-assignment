package test_runners;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@failed_scenario.txt",
        glue = "stepdefinitions",


        snippets = CucumberOptions.SnippetType.CAMELCASE


)
public class Rerunners {
}
