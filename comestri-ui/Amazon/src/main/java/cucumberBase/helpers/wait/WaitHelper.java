package cucumberBase.helpers.wait;


import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class WaitHelper {
    public static WebDriverWait wait;
    public static int SCREENHEIGHT = 1080;
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WaitHelper.class);

    /**
     * This is a constructor for this class
     *
     * @param driver
     */
    public WaitHelper(WebDriver driver) {

        this.driver = driver;
        log.info("Wait Helper object has been created....");
    }


    /**
     * Wait For Text To Appear
     *
     * @param element
     * @param textToAppear
     */
    public void waitForTextToAppear(WebElement element, String textToAppear) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        log.info("Waiting for text to appear....");
        wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
    }

    /**
     * Wait for text to be present
     *
     * @param locator
     * @param timeOutInSeconds
     * @param text
     */
    public void waitForTextMatches(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(text)));
        log.info("The text has been matched " + driver.findElement(locator).getText());
    }

    public void waitForTextToBePresentInElementLocated(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

    }

    public void waitForInvisibilityOfElementWithText(By locator, int timeOutInSeconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
    }

    public void waitForInvisibilityofElment(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    /**
     * Wait for element to be CLICKABLE by Element
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementClickable(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be clickable...." + timeOutInSeconds + "seconds");
        //  log.info("Waiting for Element to be clickable....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        // log.info("Element is clickable now .... ");
    }


    /**
     * Waiting for element to be VISIBLE
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForElementVisible(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be Visible ...." + timeOutInSeconds + "seconds");
        //log.info("Waiting for Element to be Visible....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        //log.info("Element is Visible now .... ");
    }

    /**
     * Waiting for ALL element to be VISIBLE
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void waitForAllElementVisible(WebElement element, int timeOutInSeconds) {
        // log.info("Waiting for :" + element.toString() + " for : " + timeOutInSeconds + "seconds");
        // log.info("Waiting for element to be Visible ...." + timeOutInSeconds + "seconds");
        //  log.info("Waiting for All Element to be Visible....");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        // log.info("Element is Visible now .... ");
    }


    /**
     * This method will be used for Ajax item to load on page
     *
     * @throws InterruptedException
     */
    public void waitForAjax() throws InterruptedException {
        while (true) {
            String docIsReady = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
            if (docIsReady.equals("complete")) {
                log.info("document is ready. ");
                break;
            }
            log.info("document is NOT ready. ");
            Thread.sleep(150);
        }
    }

    /**
     * Implicit wait: This method can be used for setting ImplicitWait
     *
     * @param timeout
     * @param unit
     */
    public void SetImplicitWait(long timeout, TimeUnit unit) {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    public Boolean waitForJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                try {
                    log.info("try jQuery");
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null)&&(jQuery.active==0)");
                } catch (Exception e) {
                    // no jQuery present
                    log.error("no jQuery.");
                    return true;
                }
            }
        };

        return wait.until(jQueryLoad);
    }

}

