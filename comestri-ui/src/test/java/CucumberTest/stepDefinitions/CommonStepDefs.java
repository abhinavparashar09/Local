package CucumberTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.ChannelManagerPage;
import cucumberBase.pageFactory.LoginPage;
import cucumberBase.picoHelper.TestContext;
import org.apache.log4j.Logger;

public class CommonStepDefs {

    private TestContext testContext;
    private Logger log = LoggerHelper.getLogger(LoginStepDef.class);
    private LoginPage lp;
    private ChannelManagerPage objCM;

    public CommonStepDefs(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLP();
        objCM = testContext.getPageObjectManager().getChannelManagerPage();

    }

    /*
        @Given("^wait (\\d+) seconds to proceed$")
        public void waitSometime(int seconds) throws InterruptedException {
            //MySale product export need to wait sku export finish and need some time to prepare product export
             log.info("Wait " + seconds + " seconds for next step.");
            Thread.sleep(seconds * 1000);

        }

     */
    @Given("^wait (\\d+) seconds to proceed$")
    public void waitSometimeAndRefresh(int seconds) throws InterruptedException {
        //MySale product export need to wait sku export finish and need some time to prepare product export
        log.info("Waiting " + seconds + " seconds for next step.");
        Thread.sleep(seconds * 1000);

        lp.pageRefresh();
        lp.pageRefresh();

    }
}
