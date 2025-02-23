package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/orangeHRM.feature", // Path to feature files
        glue = "stepDefinitions", // Path to step definition package
        plugin = {"pretty", "html:target/cucumber-reports.html"}// Reports

)
public class TestRunnners {
}
