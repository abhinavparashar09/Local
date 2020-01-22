package CucumberTest.testRunners.V5cm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = {"CucumberTest/stepDefinitions"},
        features = {"src/test/features/V5cm"},
        plugin = {"pretty",
                "json:src/test/resources/reports/cucumberReports/jsonReport/json",
                "html:src/test/resources/reports/cucumberReports/htmlReport/"
        },

        tags = {"@NetSuite"},
        monochrome = true
)
public class ChannelNetSuiteRunner {
}
