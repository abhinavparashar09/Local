package CucumberTest.testRunners.V5;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        glue = {"CucumberTest/stepDefinitions"},
        features = {"src/test/features/V5"},
        plugin = {"pretty",
                "json:src/test/resources/reports/cucumberReports/jsonReport/json",
                "html:src/test/resources/reports/cucumberReports/htmlReport/"
        },
        tags = {"@Magento1"},
        monochrome = true
)
public class V5ChannelMagento1Runner {
}
