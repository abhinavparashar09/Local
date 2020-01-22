package CucumberTest.stepDefinitions;


import cucumber.api.java.en.Given;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.CommonMethods;
import cucumberBase.pageFactory.HeartBeatPage;
import cucumberBase.pageFactory.LoginPage;
import cucumberBase.picoHelper.TestContext;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Date;

import static cucumberBase.pageFactory.CommonMethods.ccDateFormat;


public class HeartBeatStepDef {

    static Date productHeartbeatTriggeredTime = new Date();
    private TestContext testContext;
    private Logger log = LoggerHelper.getLogger(HeartBeatStepDef.class);
    private LoginPage lp;
    private HeartBeatPage objHB;
    private CommonMethods objCommonMethod;


    public HeartBeatStepDef(TestContext context) {
        this.testContext = context;
        lp = testContext.getPageObjectManager().getLP();
        objHB = testContext.getPageObjectManager().getHeartBeatPage();
        objCommonMethod = testContext.getPageObjectManager().getCommonMethods();

    }


    @Given("^Product Heartbeat is triggered and wait (\\d+) seconds$")
    public void triggerHeartbeat(int seconds) throws InterruptedException, ParseException {
        //switch to Heartbeat page
        lp.executeScript1();

        productHeartbeatTriggeredTime = ccDateFormat.parse(objHB.triggerHeartbeat(seconds));
        //objHB.triggerHeartbeat(seconds);
        log.info("Heartbeat for brand change/delete is triggered at " + productHeartbeatTriggeredTime);
        //switch back to Channel Manager tab
        lp.executeScript2();
    }


    @Given("^Order Heartbeat is triggered and wait (\\d+) seconds$")
    public void triggerOrderHeartbeat(int stagingTime) throws InterruptedException, ParseException {
        lp.executeScript3();
        // driver.get(OMHBURL);
        lp.navigateToOrderManagerHB();

        //Enable this line when running Magento1 test alone
        //objHB = new HeartBeatPage(driver);
        log.info("Open Order Manager Heartbeat page.");
        productHeartbeatTriggeredTime = ccDateFormat.parse(objHB.triggerHeartbeat(stagingTime));

//        tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(2));
        lp.executeScript2();
        log.info("Go back to Channel Manager page.");
    }
}
