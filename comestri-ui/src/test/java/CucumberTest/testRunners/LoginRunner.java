package CucumberTest.testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = {"CucumberTest/stepDefinitions"},
        features = {"src/test/features"},
        plugin = {"pretty",
                "json:src/test/resources/reports/cucumberReports/jsonReport/json",
                "html:src/test/resources/reports/cucumberReports/htmlReport/"
        },

        tags = {"@Login"},
        monochrome = true
)
public class LoginRunner {
}
