package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintWriter;
import java.io.StringWriter;

import static cucumberBase.helpers.wait.WaitHelper.SCREENHEIGHT;
import static cucumberBase.pageFactory.CommonMethods.*;

public class Magento2AdminPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(Magento2AdminPage.class);
    By shippingMethodLink = By.linkText("Get shipping methods and rates");
    By usernameField = By.id("username");
    By passwordField = By.id("login");
    By loginBtn = By.xpath("//button");
    By createNewOrderBtn = By.id("add");
    By customerLink = By.xpath("//tr[3]/td[2]");
    By storeViewRadioBtn = By.xpath("//div[3]/div/div/div/label");
    By popupSpinner = By.cssSelector(".popup");
    By addProductsBtn = By.xpath("//section/div/div/button");
    By productSearchField = By.id("sales_order_create_search_grid_filter_name");
    By pinkShirtMedium = By.id("id_155");
    By pinkShirtSmall = By.id("id_154");
    By addToOrderBtn = By.xpath("//div[@id='order-search']/div/div/button");
    By orderFormField = By.id("edit_form");
    By shippingRadioBtn = By.id("s_method_flatrate_flatrate");
    By changeShippingLink = By.xpath("//div[@id='order-shipping-method-info']/a/span");
    By paymentMethod = By.id("p_method_fusion_payment");
    By submitTopBtn = By.id("submit_order_top_button");
    By orderConfirmation = By.xpath("//div/span/span");
    By orderHeader = By.cssSelector("h1.page-title");
    By invoiceLink = By.id("order_invoice");
    By submitInvoiceBtn = By.xpath("//div[@id='invoice_totals']/div[2]/div[3]/button");
    By invoiceMessage = By.xpath("//div[@id='messages']/div/div/div");

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public Magento2AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void login(String usn, String pwd) {
        WebElement username = getWhenVisible(usernameField);
        username.clear();
        username.sendKeys(usn);
        WebElement password = getWhenVisible(passwordField);
        password.clear();
        password.sendKeys(pwd);

        clickWhenReady(loginBtn);
        log.info("Click to log in.");
    }

    public void gotoOrderPage() {
        driver.get(Magento2OrderURL);
    }

    public String createNewOrder() {
        gotoOrderPage();

        clickWhenReady(createNewOrderBtn);
        log.info("Click 'Create New Order' button.");

        clickWhenReady(customerLink);
        log.info("Select Iggy Azalea as customer.");

        clickWhenReady(storeViewRadioBtn);
        log.info("Check the 'default store view' radio button.");

        waitHelper.waitForInvisibilityofElment(popupSpinner, 90);

        clickWhenReady(addProductsBtn);
        log.info("Click 'Add Products'.");

        WebElement productSearch = getWhenVisible(productSearchField);
        productSearch.clear();
        productSearch.sendKeys("pink");
        productSearch.sendKeys(Keys.ENTER);
        waitHelper.waitForJQueryToLoad();

        clickWhenReady(pinkShirtMedium);
        log.info("Tick 1st product: 'Pink Scotch Plaid Shirt-M'");

        clickWhenReady(pinkShirtSmall);
        log.info("Tick 2nd product: 'Pink Scotch Plaid Shirt-S'");

        clickWhenReady(addToOrderBtn);
        log.info("Add selected product to order.");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0, %s)", 1 * SCREENHEIGHT));

        //Element <a href="#" onclick="order.loadShippingRates();return false" class="action-default">...</a> is not clickable at point (1364, 173).
        //Other element would receive the click: <div class="loading-mask" data-role="loader" style="display: block;">...</div>

        waitHelper.waitForInvisibilityofElment(By.xpath("/html/body/div[1]"), 90);
        getWhenClickable(shippingMethodLink).click();
        log.info("Get shipping method.");

        clickWhenReady(shippingRadioBtn);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popupSpinner));
        log.info("Payment is now selected and saved.");

        //Test payment gateway is removed
        clickWhenReady(paymentMethod);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popupSpinner));
        log.info("Fusion Factory Payment is now selected and saved.");

        clickWhenReady(submitTopBtn);
        log.info("Submit Order.");

        String orderMessage = "";
        String orderSourceID = "";
        try {
            //wait till order is successfully placed
            WebDriverWait PSOrderWait = new WebDriverWait(driver, ORDERGENERATIONWAIT);
            PSOrderWait.until(ExpectedConditions.textToBePresentInElementLocated(orderConfirmation, "The order confirmation email was sent"));
            //First letter of this field is '#'
            orderSourceID = getWhenVisible(orderHeader).getText().substring(1);
            log.info("Order is successfully placed. " + orderMessage + ".");
        } catch (TimeoutException ex) {
            StringWriter waitErrorMsg = new StringWriter();
            ex.printStackTrace(new PrintWriter(waitErrorMsg));
            log.info("Magento2 order is not generated in 6 minutes. Timeout." + waitErrorMsg);
        }

        //invoice the order to move order status to be "Processing"
        clickWhenReady(invoiceLink);
        log.info("Click 'Invoice' to invoice the order.");

        //need to scroll to the bottom after upgrading to Selenium 3
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        clickWhenReady(submitInvoiceBtn);
        log.info("Click 'Submit Invoice'.");

        try {
            //wait till invoice being created
            WebDriverWait PSOrderWait = new WebDriverWait(driver, ORDERGENERATIONWAIT);
            PSOrderWait.until(ExpectedConditions.textToBePresentInElementLocated(invoiceMessage, "The invoice has been created"));
            orderMessage = getWhenVisible(invoiceMessage).getText();
            log.info("Order is invoiced. " + orderMessage + ".");
        } catch (TimeoutException ex) {
            StringWriter waitErrorMsg = new StringWriter();
            ex.printStackTrace(new PrintWriter(waitErrorMsg));
            log.info("Magento2 invoice is not generated in 6 minutes. Timeout." + waitErrorMsg);
        }

        return orderSourceID;
    }

}