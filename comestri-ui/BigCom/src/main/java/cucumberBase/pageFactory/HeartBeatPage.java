package cucumberBase.pageFactory;


import cucumberBase.driverFactory.managers.FileReaderManager;
import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;


public class HeartBeatPage extends PageBase {

    private final Logger log = LoggerHelper.getLogger(HeartBeatPage.class);
    /**
     * THese are all locator for HeartBeat section
     */

    @FindBy(xpath = "//p[8]/span[2]")
    private WebElement heartbeatAt;
    @FindBy(linkText = "Heartbeat now")
    private WebElement HeartbeatNowBtn;

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public HeartBeatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    //Common Methods:
    public void navigateToHeartBeatPage() {
        //  driver.get("https://staging-product.commerceconnect.co/tenants/heartbeat");
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getHeartBeatUrl());
        log.info("User has navigated to heartbeat page.... ");
    }

    // This Action method will be used to trigger heartbeat
    public String triggerHeartbeat(int stageTime) throws InterruptedException, ParseException {
        waitHelper.waitForElementClickable(HeartbeatNowBtn, 120);
        HeartbeatNowBtn.click();
        log.info("Clicked 'Heartbeat now' button.");

        //'Heartbeat at' time stamp is updated right after clicking 'Heartbeat Now' button. It doesn't
        // mean the processing is finished. 'Indexed at' is related to Elastic search re-indexing.
        //Discussed with Charlie, he confirmed that we cannot rely on any of the timestamp to indicate
        //that the heartbeat process has finished. He advised to use the 'dash board' screen in Channel Manager
        Thread.sleep(stageTime * 1000);
        log.info("Thread sleep for 90 sec...");
        driver.navigate().refresh();
        driver.navigate().refresh();
        waitHelper.waitForElementVisible(heartbeatAt, 120);
        String newHeartbeatAt = heartbeatAt.getText();
        // String newHeartbeatAt = waitHelper.getWhenVisible(heartbeatAt).getText();
        log.info("New heartbeat at: " + newHeartbeatAt);

        return newHeartbeatAt;
    }


}




