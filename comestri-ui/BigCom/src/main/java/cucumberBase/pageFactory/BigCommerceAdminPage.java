package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static cucumberBase.helpers.wait.WaitHelper.SCREENHEIGHT;
import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;

public class BigCommerceAdminPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(BigCommerceAdminPage.class);
    By usernameField = By.id("user_email");
    By passwordField = By.id("user_password");
    By loginBtn = By.name("commit");
    By viewStoreLink = By.cssSelector("#nav-viewStore");
    By previewCodeField = By.id("guestTkn");
    By submitButton = By.xpath("//input[@value='Submit']");
    By categoryLink = By.linkText("Long Sleeve Shirts");
    By prodDetailForm = By.xpath("//section[3]/div");
    By colorDropdown = By.id("attribute_select_1182");
    By addToCartBtn = By.id("form-action-addToCart");
    By modalContainer = By.id("previewModal");
    By viewOrEditCart = By.linkText("View or edit your cart");
    By cartForm = By.xpath("//main");
    By CheckoutBtn = By.linkText("Check out");
    By CheckoutAsExistingCustomer = By.id("checkout-customer-login");
    By buyerUsername = By.id("login_email");
    By buyerPassword = By.id("login_pass");
    By buyerLoginBtn = By.id("LoginButton");
    By billAndShipBtn = By.xpath("//div[3]/input");
    By continueBtn = By.xpath("//form/input");
    By paymentRadioBtn = By.xpath("//div[@id='provider_list']/label[2]");
    By orderConfirmForm = By.id("OrderConfirmationForm");
    By paymentBtn = By.id("bottom_payment_button");
    By paymentGateway = By.xpath("//*[@id=\"checkout-app\"]/div/div/div/div[1]/ol/li[4]/div[2]/div/div/form/fieldset[1]/div/ul/li[3]/div[1]/div/label/span");
    By creditCardForm = By.xpath("//div[6]/div[2]");
    By creditCardType = By.id("creditcard_cctype");
    By creditCardName = By.id("creditcard_name");
    By creditCardNo = By.id("creditcard_ccno");
    By expireMonth = By.id("creditcard_ccexpm");
    By expireYear = By.id("creditcard_ccexpy");
    By expireDate = By.id("ccExpiry");
    By cardCVV = By.id("ccCvv");
    By payBtn = By.xpath("//div[2]/form/div/p/input");
    By orderMsg = By.xpath("//p/span");
    By orderID = By.xpath("//p/a");
    By loadingIndicator = By.xpath("//*[@id=\"checkout-app\"]/div/div/div/div/div/div/span");

    By bigCv3ColorDropdown = By.id("attribute_select_1641");
    By bigCv3SizeDropdown = By.id("attribute_select_1642");

    /**
     * This is constructor
     *
     * @param driver
     */
    public BigCommerceAdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public boolean isElementPresent(By locator) {
        try {
            String buttonName = driver.findElement(locator).getAttribute("name");
            if (!buttonName.isEmpty()) {
                log.info("'" + buttonName.substring(0, 6) + "'" + " element exists.");
                return true;
            }
            log.info("Don't need token this time.");
            return false;
        } catch (NoSuchElementException e) {
            log.error("NoSuchElement exception.");
            return false;
        }
    }

    public void waitLoadingIndicator() throws InterruptedException {

        WebElement lI = null;
        try {
            lI = driver.findElement(loadingIndicator);
        } catch (Exception e) {
            log.info("No loading bar...");
        }
        if (lI != null) {
            log.info("Page loading...");
            WebDriverWait wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
        }
    }

    public void reset() {
        buyerUsername = By.id("email");
        buyerPassword = By.id("password");
        buyerLoginBtn = By.id("checkout-customer-continue");
        continueBtn = By.id("checkout-shipping-continue");
        creditCardName = By.id("ccName");
        creditCardNo = By.id("ccNumber");
        payBtn = By.id("checkout-payment-continue");
        orderMsg = By.xpath("//p[1]/span");
        orderID = By.xpath("//p[1]/span/strong");

        BIGUSERNAME = "marketplaces.qa@fusionfactory.com";
        BIGPWD = "bgzvc9@Kr,WK5W*C775a";            //expire every 3 months, last updated on 08Jun/06Sep/06Mar
        STORETOKEN = "2xvxp4ksy8";
        BIGSTORE = "http://comstriqa.mybigcommerce.com/";
        BUYTHISPRODUCT = "skyler-shirt2019_25102019";
        BIGBUYER = "comestriqa@fusionfactory.com";
        BIGBUYERPWD = "Fusion123";

    }

    public void login() throws InterruptedException {

        WebElement username = getWhenVisible(usernameField);
        username.clear();
        username.sendKeys(BIGUSERNAME);
        WebElement password = getWhenVisible(passwordField);
        password.clear();
        password.sendKeys(BIGPWD);

        clickWhenReady(loginBtn);
        log.info("Click to log in.");
    }

    public void storeLogin(String previewCode) throws InterruptedException {
        log.info("BigCommerce store.");

        WebElement preview = getWhenVisible(previewCodeField);
        preview.clear();
        preview.sendKeys(previewCode);
        clickWhenReady(submitButton);
        log.info("Submit preview code.");
    }

    public String makeAPurchase() throws InterruptedException {

        driver.get(BIGSTORE + BUYTHISPRODUCT);
        log.info("Go to the product page.");

        //Starting from mid April, Bigcommerce asks for preview code again, sometimes
        if (isElementPresent(previewCodeField)) {
            WebElement preview = getWhenVisible(previewCodeField);
            preview.clear();
            preview.sendKeys(STORETOKEN);
            clickWhenReady(submitButton);
            log.info("Submit preview code again.");
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", 0.3 * SCREENHEIGHT));
        log.info("Scroll down to reveal 'ADD TO CART' button.");

        clickWhenReady(addToCartBtn);
        log.info("Clicked on 'ADD TO CART'.");

        clickWhenReady(viewOrEditCart);
        log.info("clicked 'VIEW OR EDIT YOUR CART' button.");

        jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", 0.5 * SCREENHEIGHT));
        log.info("Scroll down 540 pixels.");

        clickWhenReady(CheckoutBtn);
        log.info("Click 'Check out' button.");

        getWhenVisible(buyerUsername).sendKeys(BIGBUYER);
        log.info("buyer username is entered.");

        getWhenVisible(buyerPassword).sendKeys(BIGBUYERPWD);
        log.info("buyer password is entered.");

        jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", 0.5 * SCREENHEIGHT));
        log.info("Scroll down 540 pixels.");


        clickWhenReady(buyerLoginBtn);
        log.info("Click 'CONTINUE' button.");

        waitHelper.waitForJQueryToLoad();
        Thread.sleep(2000);        //This is giving time for the UI to expend
        clickWhenReady(billAndShipBtn);
        log.info("Click 'BILL&SHIP TO THIS ADDRESS'.");

        waitHelper.waitForJQueryToLoad();
        clickWhenReady(continueBtn);
        log.info("Click 'CONTINUE' for shipping method.");

        waitHelper.waitForJQueryToLoad();
        Thread.sleep(2500);        //This is giving time for the UI to expend
        getWhenVisible(paymentRadioBtn).click();
        log.info("Select Test Payment Gateway radio button.");

        waitHelper.waitForJQueryToLoad();
        jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", SCREENHEIGHT));
        log.info("Scroll down 540 pixels.");

        clickWhenReady(paymentBtn);
        log.info("Click 'PROCEED TO PAYMENT'.");

        WebElement creditcardForm = getWhenVisible(creditCardForm);
        WebElement creditcardType = creditcardForm.findElement(creditCardType);
        log.info("Found creditcard dropdown.");
        waitHelper.waitForJQueryToLoad();
        Thread.sleep(2500);        //This is giving time for the UI to expend
        Select cardTypeDropdown = new Select(creditcardType);
        cardTypeDropdown.selectByIndex(3);
        log.info("Select VISA because card number is starting with '4'.");

        getWhenVisible(creditCardName).sendKeys("Ashton Kutcher");
        log.info("Entered cardholder's name.");

        getWhenVisible(creditCardNo).sendKeys(CREDITCARDNO);
        log.info("Creditcard number is entered.");

        WebElement expireM = creditcardForm.findElement(expireMonth);
        Select month = new Select(expireM);
        month.selectByIndex(7);
        log.info("Select expire month.");

        WebElement expireY = creditcardForm.findElement(expireYear);
        Select year = new Select(expireY);
        year.selectByIndex(3);
        log.info("Select expire year.");

        clickWhenReady(payBtn);
        log.info("Click 'PAY FOR ORDER'.");

        WebDriverWait bigCommerceOrderWait = new WebDriverWait(driver, 120);
        bigCommerceOrderWait.until(ExpectedConditions.textToBePresentInElementLocated(orderMsg, "Your order number is:"));
        String orderSourceID = getWhenVisible(orderID).getText();

        return orderSourceID;
    }

    public String makeAPurchaseV3() throws InterruptedException {
        String orderSourceID = "";
        try {
            driver.get(BIGSTORE + BUYTHISPRODUCT);
            log.info("Go to the product page.");

            //Starting from mid April, Bigcommerce asks for preview code again, sometimes
            if (isElementPresent(previewCodeField)) {
                WebElement preview = getWhenVisible(previewCodeField);
                preview.clear();
                preview.sendKeys(STORETOKEN);
                clickWhenReady(submitButton);
                log.info("Submit preview code again.");
            }

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(String.format("window.scrollBy(0,%s)", 0.3 * SCREENHEIGHT));
            log.info("Scroll down to reveal 'ADD TO CART' button.");

            //Select color / size first
            getWhenVisible(By.xpath("/html/body/div[2]/div[1]/div/div[1]/section[3]/div[1]/form[1]/div[1]/div/label[4]")).click();

            clickWhenReady(addToCartBtn);
            log.info("Clicked on 'ADD TO CART'.");
            Thread.sleep(2000);
            clickWhenReady(viewOrEditCart);
            log.info("clicked 'VIEW OR EDIT YOUR CART' button.");

            waitLoadingIndicator();
            jse = (JavascriptExecutor) driver;
            jse.executeScript(String.format("window.scrollBy(0,%s)", 0.5 * SCREENHEIGHT));
            log.info("Scroll down 540 pixels.");

            clickWhenReady(CheckoutBtn);
            log.info("Click 'Check out' button.");

            //Login as existing customer
            getWhenVisible(CheckoutAsExistingCustomer).click();
            log.info("Sign in as existing customer.");

            getWhenVisible(buyerUsername).sendKeys(BIGBUYER);
            log.info("buyer username is entered.");

            getWhenVisible(buyerPassword).sendKeys(BIGBUYERPWD);
            log.info("buyer password is entered.");

            clickWhenReady(buyerLoginBtn);
            log.info("Click 'Sign In' button.");

            waitLoadingIndicator();
            Thread.sleep(2000);
            jse = (JavascriptExecutor) driver;
            jse.executeScript(String.format("window.scrollBy(0,%s)", 0.5 * SCREENHEIGHT));
            log.info("Scroll down 540 pixels.");
            Thread.sleep(2000);
            getWhenVisible(continueBtn).click();
            log.info("Click 'CONTINUE' for shipping method.");

            waitLoadingIndicator();
            log.info("Skip billing.");

            jse = (JavascriptExecutor) driver;
            jse.executeScript(String.format("window.scrollBy(0,%s)", 0.5 * SCREENHEIGHT));
            log.info("Scroll down 540 pixels.");
            Thread.sleep(2000);
            getWhenVisible(paymentGateway).click();
            log.info("Select TestGateway and Visa by default.");

            waitLoadingIndicator();
            getWhenVisible(creditCardNo).sendKeys(CREDITCARDNO);
            log.info("Creditcard number is entered.");
            getWhenVisible(creditCardName).sendKeys("Ashton Kutcher");
            log.info("Entered cardholder's name.");

            getWhenVisible(expireDate).sendKeys("01/25");
            log.info("Select expire date.");

            getWhenVisible(cardCVV).sendKeys("888");
            log.info("Click 'CVV'.");

            clickWhenReady(payBtn);
            log.info("Click 'PAY FOR ORDER'.");

            WebDriverWait bigCommerceOrderWait = new WebDriverWait(driver, 120);
            bigCommerceOrderWait.until(ExpectedConditions.textToBePresentInElementLocated(orderMsg, "Your order number is"));
            orderSourceID = getWhenVisible(orderID).getText();

        } catch (Exception e) {
            Calendar instance = Calendar.getInstance();
            String orderDate = new SimpleDateFormat("YYYY_MM_dd'T'HH_mm_ss").format(instance.getTime());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File tgtFile = new File("C:\\CaptureScreenshot\\BigCommerceOrderV3FailedAt_" + orderDate + ".jpg");
            try {
                FileUtils.copyFile(scrFile, tgtFile);
            } catch (Exception ioe) {
                log.info("Cannot save screenshot.");
            }
            e.printStackTrace();
            log.error("Order generating fail...");
        }
        return orderSourceID;
    }
}