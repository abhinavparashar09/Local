package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;
import java.util.UUID;

import static cucumberBase.helpers.wait.WaitHelper.SCREENHEIGHT;
import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;

public class NetSuiteAdminPage extends PageBase {

    private final Logger log = LoggerHelper.getLogger(NetSuiteAdminPage.class);

    By emailAddress = By.name("email");
    By passwordField = By.name("password");
    By loginBtn = By.id("Submit");
    By securityQuestionField = By.xpath("//*/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]");
    By securityAnswer1 = By.name("answer");
    By submitButton = By.name("submitter");
    By pricingTab = By.id("pricingtxt");
    By priceForm = By.id("price1_form");
    By listPriceField = By.id("price_1_1_formattedValue");
    By saveButton = By.id("btn_secondarymultibutton_submitter");
    By editButton = By.id("edit");
    By webStoreTab = By.id("storetxt");
    By descriptionField = By.id("ext-gen346");
    By saveResult = By.xpath("//div[@id='div__alert']/div/div[2]/div[2]");

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public NetSuiteAdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void login(String usn, String pwd) {
        WebElement username = getWhenVisible(emailAddress);
        username.clear();
        username.sendKeys(usn);
        WebElement password = getWhenVisible(passwordField);
        password.clear();
        password.sendKeys(pwd);

        clickWhenReady(loginBtn);
        log.info("Click to log in.");

        //NetSuite has this extra authentication process
        String securityQuestion = getWhenVisible(securityQuestionField).getText();
        WebElement securityAnswer = getWhenVisible(securityAnswer1);
        securityAnswer.clear();
        if (securityQuestion.equals("What was your childhood nickname?")) {
            securityAnswer.sendKeys("CommerceConnect1");
        } else if (securityQuestion.endsWith("What is your maternal grandmother's maiden name?")) {
            securityAnswer.sendKeys("CommerceConnect3");
        } else {
            securityAnswer.sendKeys("CommerceConnect2");
        }

        clickWhenReady(submitButton);
        log.info("Click to authenticate.");
    }

    public void gotoProductPage(String prodID) {
        driver.get(String.format(NSPRODURL, prodID));
    }

    public void gotoTab(String tabName) {
        if (tabName.equals("Pricing")) {
            clickWhenReady(pricingTab);
        } else if (tabName.equals("WebStore")) {
            clickWhenReady(webStoreTab);
        }
    }

    public String[] updateProductPrice() {
        String[] result = new String[2];

        String js = String.format("window.scrollBy(0,%s)", SCREENHEIGHT * 0.2);
        ((JavascriptExecutor) driver).executeScript(js);
        gotoTab("Pricing");
        js = String.format("window.scrollBy(0,%s)", SCREENHEIGHT * 0.4);
        ((JavascriptExecutor) driver).executeScript(js);

        WebElement priceFormElement = getWhenVisible(priceForm);
        WebElement priceElement = priceFormElement.findElement(listPriceField);
        String listPrice = priceElement.getAttribute("value");
        log.info("old list price is: " + listPrice);

        Random rand1 = new Random();
        int oldListPrice = Integer.parseInt(listPrice.substring(0, listPrice.length() - 3));
        int newListPrice = 0;
        do {
            newListPrice = rand1.nextInt(200);
            log.info("Generate new price.");
        } while (newListPrice == oldListPrice);
        priceElement.clear();
        priceElement.sendKeys(Integer.toString(newListPrice));
        log.info("New price is " + newListPrice);

        clickWhenReady(saveButton);
        log.info("Click to save.");

        waitHelper.waitForTextToBePresentInElementLocated(saveResult, 120, "ed");
        result[0] = Integer.toString(newListPrice);
        result[1] = getWhenVisible(saveResult).getText();
        log.info(result[1]);

        return result;
    }

    public String[] updateProductDescription() {
        String[] result = new String[2];

        String js = String.format("window.scrollBy(0,%s)", SCREENHEIGHT * 0.2);
        ((JavascriptExecutor) driver).executeScript(js);
        gotoTab("WebStore");
        //after clicking WebStore, the page scrolls to a bottom position. So need to scroll up again to see detailed description
        js = String.format("window.scrollBy(0,-%s)", SCREENHEIGHT * 0.7);
        ((JavascriptExecutor) driver).executeScript(js);

        //detailed description is in an iframe, this step is to switch to that iframe by name
        driver.switchTo().frame(frameName);
        WebElement descriptionElement = getWhenVisible(descriptionField);

        String detailedDescription = descriptionElement.getText();
        log.info("old description is: " + detailedDescription);

        result[0] = UUID.randomUUID().toString();
        //this field is not 'input' type or textarea
        descriptionElement.clear();
        //descriptionElement.sendKeys(Keys.CONTROL+"a");
        //descriptionElement.sendKeys(Keys.BACK_SPACE);
        descriptionElement.sendKeys(result[0]);
        log.info("New description is random UUID: " + result[0]);
        driver.switchTo().defaultContent();

        clickWhenReady(saveButton);
        log.info("Click to save.");


        waitHelper.waitForTextToBePresentInElementLocated(saveResult, 120, "ed");
        result[1] = getWhenVisible(saveResult).getText();
        log.info(result[1]);

        return result;
    }
}
