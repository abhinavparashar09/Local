package CucumberTest.stepDefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumberBase.driverFactory.managers.FileReaderManager;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.picoHelper.TestContext;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hooks {
    TestContext testContext;
    private Logger log = LoggerHelper.getLogger(Hooks.class);

    public Hooks(TestContext context) {

        testContext = context;
    }

    @Before("@Start")
    public void beforeScenario(Scenario scenario) {
        testContext.getDriverFactoryManager().getDriver().navigate().to(FileReaderManager.getFileReaderManager().getConfigReader().getApplicationUrl());
        testContext.getDriverFactoryManager().getDriver().manage().timeouts().implicitlyWait(FileReaderManager.getFileReaderManager().getConfigReader().getImplicitWait(), TimeUnit.SECONDS);
        testContext.getDriverFactoryManager().getDriver().manage().window().maximize();
        // Reporter.assignAuthor("Nikhil Kumar....");
        //scenario.getId() returns value like: src/test/java/cucumber/resources/SFCCChannel.feature:24
        Pattern pattern = Pattern.compile("/(\\w+)\\.feature:.*$");
        Matcher matcher = pattern.matcher(scenario.getId());
        while (matcher.find()) {
            log = Logger.getLogger(matcher.group(1));
            log.info("****************************************************************************************");
            log.info("$$$$$$$$$$$$$$$$$$$$$$$$              " + matcher.group(1) + "         $$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            log.info("****************************************************************************************");
        }


    }

    @After("@last")
    public void closeDriver() {
        testContext.getDriverFactoryManager().closeDriver();
        log.info("After Hook has closed browser.... ");
    }
}

