package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.UUID;

import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;

public class Magento1AdminPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(Magento1AdminPage.class);
    By usernameField = By.id("username");
    By passwordField = By.id("login");
    By loginBtn = By.xpath("//input[@value='Login']");
    By incomingMsgHeader = By.xpath("//h2");
    By descField = By.id("description");
    By saveBtn = By.xpath("//div[@id='content']/div/div[2]/div/p/button[6]");
    By saveMessageBanner = By.xpath("//div[@id='messages']/ul/li/ul/li/span");
    By priceTab = By.xpath("//a[@id='product_info_tabs_group_8']/span");
    By priceField = By.id("price");
    @FindBy(id = "sku")
    private WebElement skuField;

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public Magento1AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public String login(String usn, String pwd) {
        WebElement username = getWhenVisible(usernameField);
        username.clear();
        username.sendKeys(usn);
        WebElement password = getWhenVisible(passwordField);
        password.clear();
        password.sendKeys(pwd);

        clickWhenReady(loginBtn);
        String incomingMessage = getWhenVisible(incomingMsgHeader).getText();
        log.info("Click to log in. Incoming message is " + incomingMessage);

        return incomingMessage;
    }

    public void gotoProductPage(String prodURL) {
        driver.get(prodURL);
        waitHelper.waitForElementClickable(skuField, 90);
    }

    public String[] updateProductDescription() {

        String[] result = new String[2];

        WebElement magento1Description = getWhenVisible(descField);
        magento1Description.clear();
        result[0] = UUID.randomUUID().toString();
        magento1Description.sendKeys(result[0]);
        log.info("New description is random UUID: " + result[0]);

        clickWhenReady(saveBtn);
        log.info("Click to save.");


        waitHelper.waitForTextToBePresentInElementLocated(saveMessageBanner, 120, "ed.");
        result[1] = getWhenVisible(saveMessageBanner).getText();

        return result;
    }

    public String[] updateProductPrice() {

        String[] result = new String[2];

        clickWhenReady(priceTab);
        log.info("Go to the 'Prices' tab.");

        WebElement magento1Price = getWhenVisible(priceField);
        String oldM1Price = magento1Price.getAttribute("value");
        log.info("Existing price is " + oldM1Price);

        Random rand1 = new Random();
        int oldM1Value = Integer.parseInt(oldM1Price.substring(0, oldM1Price.length() - 3));
        int newM1Price = 0;
        do {
            newM1Price = rand1.nextInt(400) + 101;
            log.info("Generate new price.");
        } while (newM1Price == oldM1Value);
        magento1Price.clear();
        magento1Price.sendKeys(Integer.toString(newM1Price));
        log.info("New price is " + newM1Price);

        clickWhenReady(saveBtn);
        log.info("Click to save.");
        waitHelper.waitForTextToBePresentInElementLocated(saveMessageBanner, 120, "ed.");

        result[0] = Integer.toString(newM1Price);
        result[1] = getWhenVisible(saveMessageBanner).getText();

        return result;
    }
}
