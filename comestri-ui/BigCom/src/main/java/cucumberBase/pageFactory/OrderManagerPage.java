package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;

public class OrderManagerPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(OrderManagerPage.class);
    //By ordersMenu = By.xpath("//nav/ul/li[5]/a");
    @FindBy(xpath = "//nav/ul/li[5]/a")
    WebElement ordersMenu;
    //By manageJobs = By.linkText("Manage Jobs");
    @FindBy(linkText = "Manage Jobs")
    WebElement manageJobs;
    @FindBy(css = "#api_jobs > tfoot > tr > td > div > div:nth-child(1) > div")
    WebElement manageJobsDisplaying;
    By submittedAt = By.xpath("//td[2]");
    By importResultField = By.xpath("//td[10]/div");
    //By manageOrders = By.xpath("//li[5]/ul/li/a/span");
    @FindBy(xpath = "//li[5]/ul/li/a/span")
    WebElement manageOrders;
    By orderTotalFooter = By.cssSelector(".dataTables_info");
    //Following items are on the Manage Orders screen
    By orderIDHeader = By.xpath("//th");
    By firstOrderID = By.xpath("//td/a");
    //By orderSourceID = By.xpath("//td[3]");
    @FindBy(xpath = "//td[3]")
    List<WebElement> orderSourceIDs;

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public OrderManagerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void gotoOrdersMenu() {
        //clickWhenReady(ordersMenu);
        waitHelper.waitForElementVisible(ordersMenu, 60);
        ordersMenu.click();
        waitHelper.waitForTextToAppear(manageOrders, "Manage Orders");
        log.info("Check ordersMenu success.");
    }

    public void gotoManageJobs() {
        //clickWhenReady(manageJobs);
        waitHelper.waitForElementVisible(manageJobs, 60);
        manageJobs.click();
        waitHelper.waitForTextToAppear(manageJobsDisplaying, "api jobs");
        log.info("Check Manage Order Jobs success.");
    }

    public void gotoManageOrdersScreen() {
        waitHelper.waitForElementVisible(manageOrders, 60);
        manageOrders.click();
        waitHelper.waitForTextToBePresentInElementLocated(orderTotalFooter, 120, "Displaying");
        log.info("Click 'Manage Orders' menu to get order source ID.");
    }

    public String[] checkOrderImportJobResult(String importFinishedAtCM, String expectedOrderId) throws InterruptedException {
        gotoOrdersMenu();
        gotoManageJobs();

        String[] importResult = new String[3];
        //Refresh to get the latest import job status
        int refreshImportCount = 0;
        importResult[1] = getWhenVisible(importResultField).getText();
        importResult[2] = getWhenVisible(submittedAt).getText();
        while (!(importResult[2].startsWith(importFinishedAtCM) && importResult[1].equals("Success"))) {
            Thread.sleep(ORDERIMPORTREFRESHINT);
            driver.navigate().refresh();
            refreshImportCount++;
            log.info("Refresh number " + refreshImportCount);
            importResult[1] = getWhenVisible(importResultField).getText();
            importResult[2] = getWhenVisible(submittedAt).getText();
            if (refreshImportCount >= IMPORTREFRESHTRIES) break;
        }

        //get order import result and order ID.
        if ((importResult[2].startsWith(importFinishedAtCM)) && (importResult[1].equals("Success"))) {
            gotoManageOrdersScreen();
            //List<WebElement> importedOders = orderSourceIDs;
            try {
                for (WebElement element : orderSourceIDs) {
                    //Check if the expected order in the order manager table
                    if (element.getText().equals(expectedOrderId)) {
                        importResult[0] = element.getText();
                    }
                }
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                List<WebElement> orders = driver.findElements(By.xpath("//td[3]"));
                for (WebElement element : orders) {
                    //Check if the expected order in the order manager table
                    if (element.getText().equals(expectedOrderId)) {
                        importResult[0] = element.getText();
                    }
                }
            }

        }
        log.info("Import of order " + importResult[0] + " at " + importResult[2] + " is " + importResult[1]);
        return importResult;
    }
}

