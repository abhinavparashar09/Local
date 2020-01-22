package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;

public class EbayBuyingPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(EbayBuyingPage.class);
    By signInLink = By.linkText("Sign in");
    By usernameField = By.id("userid");
    By passwordField = By.id("pass");
    By loginBtn = By.id("sgnBt");
    By colorDropdown = By.id("msku-sel-1");
    By sizeDropdown = By.id("msku-sel-2");
    By buyItNowBtn = By.id("binBtn_btn");
    By addToCartBtn = By.id("atcRedesignId_btn");
    By viewCartBtn = By.id("vi-viewInCartBtn");
    By goToCartBtn = By.linkText("Go to cart");
    By checkCartBtn = By.id("gh-cart-i");
    By goToCheckoutBtn = By.xpath("//div/div/button");        //this xpath keeps changing, sometimes it's in div[4]
    By confirmAndPayBtn = By.id("cta-btn");
    By orderResultMsg = By.xpath("//div[@id='success-order-summary']/div/div");
    By paymentFailMsg = By.xpath("//div[@id='alert-page']/div/p/span");
    By orderSourceID = By.cssSelector("span.bold");

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public EbayBuyingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public boolean isElementPresent(By locator) {
        try {
            String buttonName = driver.findElement(locator).getText();
            if (!buttonName.isEmpty()) {
                log.info("'" + buttonName.substring(0, 9) + "'" + " button exists.");
                return true;
            }
            log.info("Button doesn't exist.");
            return false;
        } catch (NoSuchElementException e) {
            log.error("No such Element exception.");
            return false;
        }
    }

    public void login(String usn, String pwd) throws InterruptedException {

        clickWhenReady(signInLink);
        WebElement username = getWhenVisible(usernameField);
        username.clear();
        username.sendKeys(usn);
        WebElement password = getWhenVisible(passwordField);
        password.clear();
        password.sendKeys(pwd);

        clickWhenReady(loginBtn);
        log.info("Click to log in.");
    }

    public void gotoListing(String listingURL) throws InterruptedException {
        driver.get(listingURL);
    }

    public String makeAPurchase() throws IOException {
        String orderID = "";

        new Select(getWhenVisible(colorDropdown)).selectByVisibleText("Lime");
        log.info("Selected Lime colour.");
        new Select(getWhenVisible(sizeDropdown)).selectByVisibleText("small");
        log.info("Selected small size.");
        clickWhenReady(buyItNowBtn);

        //After clicking 'Proceed to checkout', next page takes longer to load.
        //First time clicking 'Confirm and Pay' always fail, need to find out why
        Boolean paymentIsFailed = false;
        do {
            clickWhenReady(confirmAndPayBtn);
            log.info("Click 'Confirm and pay'.");
            try {
                //after clicking 'Confirm and pay', it takes around 10 seconds to get the result page load
                waitHelper.waitForTextToBePresentInElementLocated(orderResultMsg, 90, "Your order was placed.");
                log.info("First payment succeeded. Ebay order for item 112524331663 was placed.");
                paymentIsFailed = false;
            } catch (TimeoutException e) {
                if (isElementPresent(paymentFailMsg)) {
                    log.info("WebDriverWait is generated. Waiting for payment failure message.");
                    waitHelper.waitForTextToBePresentInElementLocated(paymentFailMsg, 90, "Unfortunately");
                    log.info("First payment failed.");
                    paymentIsFailed = true;
                } else {
                    paymentIsFailed = false;
                }

                StringWriter waitErrorMsg = new StringWriter();
                e.printStackTrace(new PrintWriter(waitErrorMsg));
                log.info("ebay order wasn't generated. " + waitErrorMsg);
                try {
                    Calendar instance = Calendar.getInstance();
                    //String orderDate = new SimpleDateFormat("dd_MM_YYYY'T'HH_mm_ss").format(instance.getTime());
                    String orderDate = new SimpleDateFormat("YYYY_MM_dd'T'HH_mm_ss").format(instance.getTime());

                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    // Code to copy the screenshot in the desired location
                    FileUtils.copyFile(scrFile, new File("C:\\CaptureScreenshot\\ebayOrderFailedAt_" + orderDate + ".jpg"));
                } catch (IOException eio) {
                    StringWriter screenErrorMsg = new StringWriter();
                    eio.printStackTrace(new PrintWriter(screenErrorMsg));
                    log.info("screenshot file was not created. " + screenErrorMsg);
                }
            } catch (Exception e) {
                log.info("Exception while doing payment.");
                paymentIsFailed = true;
            }
        } while (paymentIsFailed);

        return orderID;
    }

}