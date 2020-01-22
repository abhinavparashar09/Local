package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static cucumberBase.pageFactory.CommonMethods.*;

public class ChannelManagerPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(ChannelManagerPage.class);
    @FindBy(id = "channel_items")
    public WebElement infoTable;
    @FindBy(id = "channel_item_of_external_code")
    WebElement externalCodeField1;
    @FindBy(linkText = "Export Items")
    WebElement exportItemsTab;
    By channelTypeField = By.id("channel_of_type");
    //these variables are dynamic, their values are decided by function parameter
    By jobType;
    By lastJobType;
    By startedAt;
    By totalItem;
    By failedItem;
    By jobStatus;
    By firstItemID = By.xpath("//tr[1]/td/a");
    //following fields are for non-simple export channels, Export Items tab, filter section
    By displayNameField = By.id("channel_item_of_display_name");
    By externalCodeField = By.id("channel_item_of_external_code");
    By itemTypeField = By.id("channel_item_of_item_type");
    By codeField = By.id("channel_item_of_code");
    By exportItemFilterBtn = By.name("commit");
    By exportItemClearBtn = By.name("button");
    By fourthColumnHead = By.xpath("//th[4]");
    By importJobsTab = By.xpath("//a[contains(text(),'Import Jobs')]");//By.linkText("Import Jobs");
    By manualImportBtn = By.xpath("//a[contains(text(),'Manual Import')]");//By.linkText("Manual Import");
    By ordersTab = By.xpath("//a[contains(text(),'Orders')]");
    By export = By.linkText("Export");
    By exportItemID = By.xpath("//td/a");
    By jsonProdSKU1 = By.xpath("//span[48]/span[2]");
    By jsonProdSKU2 = By.xpath("//span[64]/span[2]");
    By importPopup = By.id("new_scheduled_import_job");
    By importLabel = By.cssSelector("h4");
    By importJobID = By.id("scheduled_import_job_job_id");
    By importJobFrom = By.id("scheduled_import_job_from");
    By importJobTo = By.id("scheduled_import_job_to");
    By importPopupSaveBtn = By.xpath("//button[2]");
    By externalOrderID = By.xpath("//td[3]");
    By importUpdatedAt = By.xpath("//td[7]");
    By orderImportStatus = By.xpath("//td[4]");
    By importItemsHeader = By.xpath("//h3[contains(.,'Import Jobs')]");
    //By importJobType = By.id("scheduled_import_job_job_type");
    @FindBy(id = "scheduled_import_job_job_type")
    private WebElement importJobType;
    //By importStartedAt = By.xpath("//td[3]");
    @FindBy(xpath = "//td[3]")
    private WebElement importStartedAt;
    //By importFinishedAt = By.xpath("//td[4]");
    @FindBy(xpath = "//td[4]")
    private WebElement importFinishedAt;
    //By importStatus = By.xpath("//td[8]");
    @FindBy(xpath = "//td[8]")
    private WebElement importStatus;
    @FindBy(linkText = "Channels")
    private WebElement channels;
    @FindBy(linkText = "Manage Channels")
    private WebElement manageChannels;
    //@FindBy(linkText = "Configuration")
    @FindBy(xpath = "//a[text()='Configuration']")
    private WebElement configTab;
    @FindBy(xpath = "(//input[@name='commit'])[2]")
    private WebElement saveSettingsBtn;
    @FindBy(linkText = "Export Scheduler")
    private WebElement exportScheduler;
    @FindBy(linkText = "Trigger now")
    private WebElement triggerBtn;
    @FindBy(xpath = "//table[@id='export_jobs']/thead/tr/th[5]")
    private WebElement frequencyHeader;
    @FindBy(linkText = "Export Jobs")
    private WebElement exportJobsTab;
    @FindBy(xpath = "//h3[contains(.,'Export Jobs')]")
    private WebElement exportJobsHeader;
    @FindBy(xpath = "//button")
    private WebElement topCog;
    private By topCog1 = By.xpath("//button");
    @FindBy(linkText = "View error")
    private WebElement viewErrorMenu;
    @FindBy(xpath = "//p[3]/span[2]")
    private WebElement errorMsg;
    @FindBy(css = "button.close")
    private WebElement closeBtn;
    @FindBy(linkText = "Stage")
    private WebElement stageMenu;
    @FindBy(xpath = "//input[contains(@name,'commit')]")
    private WebElement filterBtn;
    @FindBy(id = "channel_of_type")
    private WebElement channelTypeField1;
    @FindBy(xpath = "//div[@class='main-header']/h2")
    private WebElement channelTitle;

    private By channelTypeFilterResultFooter = By.cssSelector(".dataTables_info");
    // By progressBar = By.id("nprogress");
    //  By channels = By.linkText("Channels");
    //  By manageChannels = By.linkText("Manage Channels");
    private By progressBar = By.id("inprogress");
    private By externalCode = By.xpath("//td[5]");
    private By exportItemtype = By.xpath("//td[6]");
    private By exportItemStatus = By.xpath("//td[7]");
    private By externalStatus = By.xpath("//td[8]");
    private By exportStatus = By.xpath("//td[9]");
    private By updatedAt = By.xpath("//td[10]");
    private By exportItemFilterResultFooter = By.cssSelector(".dataTables_info");
    private By displayName = By.xpath("//td[2]");
    private By exportItemCode = By.xpath("//td[3]");
    //following fields are for simple export channel and its inherited channels
    //such as Borderfree, Google Feed etc
    private By exportCHDisplayNameFilter = By.id("item_of_display_name");
    private By exportCHCodeFilter = By.id("item_of_code");
    private By exportCHTypeFilter = By.id("item_of_item_type");
    private By exportCHCodeField = By.xpath("//td[3]");
    private By exportCHTypeField = By.xpath("//td[4]");
    private By exportCHStatusField = By.xpath("//td[6]");
    private By exportCHUpdatedField = By.xpath("//td[9]");
    private By viewDataMenu = By.linkText("View data");
    private By closeButton = By.xpath("//*[@id=\"cc-popup\"]/div[2]/div/div[3]/button");
    private By jsonPayload = By.xpath("//*[@id=\"cc-popup\"]/div[2]/div/div[2]/div/div/pre");

    /**
     * This is constructor
     *
     * @param driver
     */
    public ChannelManagerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    // This method used to navigate to Channel Manager section
    public void clickChannels() {
        waitHelper.waitForElementClickable(channels, 120);
        channels.click();
    }

    // This method will be used to click at manage Channel tab
    public void gotoManageChannels() throws InterruptedException {
        waitHelper.waitForElementClickable(manageChannels, 120);
        manageChannels.click();
        log.info("User has navigated to Manage Channel tab.... ");
        //Sometimes wait for staleness will just time out, unreliable
        //wait.until(ExpectedConditions.stalenessOf(getWhenVisible(channelTypeField)));
        Thread.sleep(3000);
    }

    // This method will be used to redirect to export item tab
    public void gotoExportItemsTab() throws InterruptedException {
        waitHelper.waitForElementClickable(exportItemsTab, 120);
        exportItemsTab.click();
        log.info("User has navigated to export item tab....");
        //waitHelper.waitForInvisibilityofElment(progressBar, 120);
        Thread.sleep(2000);
        //It does need some certain delay here to allow channel item's export status
        //to change from 'Export Ready' to 'Exported'. If less than 4 seconds, sometimes the status change won't be completed fully.

    }

    // This method will be used to select channel with just channel name
    public void selectTestChannel(String channelName) {
        clickWhenReady(By.linkText(channelName));
    }

    // This method will be used to select channel by selecting type and name of channel
    public void selectTestChannel(String channelType, String channelName) {

        selectHelper.selectUsingVisibleText(channelTypeField1, channelType);
        log.info("User is waiting for visiblity of channel type field....");
        waitHelper.waitForElementClickable(filterBtn, 120);
        filterBtn.click();
        log.info("user has clicked Filter button for channel manager.....");
        log.info("Filter " + channelType + " channel.");
        int attempts = 0;
        while (attempts < 5) {
            try {
                waitHelper.waitForTextMatches(channelTypeFilterResultFooter, 120, "Displaying( all)* [0-9]+ channels?");
                //System.out.println(channelTypeFilterResultFooter);
                log.info("Now user will select channel by name ....");
                WebElement element = driver.findElement(By.linkText(channelName));
                waitHelper.waitForElementClickable(element, 120);
                element.click();
                waitHelper.waitForTextToAppear(channelTitle, channelName);
                log.info("Go to " + channelName + " channel.");
                break;
            } catch (Exception e) {
                log.error("Channel filter result is not ready: " + e.getMessage());
            }
            attempts++;
        }
    }


    // This method will be used to redirect to configuration tab
    public void gotoConfigurationTab() {
        log.info("User trying to redirect to configuration tab...");
        try {
            waitHelper.waitForElementClickable(configTab, 120);
        } catch (NoSuchElementException ex) {
            waitHelper.waitForElementClickable(configTab, 120);
        }
        //waitHelper.waitForElementClickable(configTab, 120);
        configTab.click();

        try {
            waitHelper.waitForElementClickable(saveSettingsBtn, 120);
        } catch (NoSuchElementException ex) {
            waitHelper.waitForElementClickable(saveSettingsBtn, 120);
        }
        log.info("Configuration page is visible now...");

    }


    // This method will be used to navigate to export Job tab
    public void gotoExportJobsTab() {
        waitHelper.waitForElementClickable(exportJobsTab, 120);
        exportJobsTab.click();
        waitHelper.waitForElementClickable(exportJobsHeader, 120);

    }

    // This will be used to wait For Export Item Filter results to appear.
    public void waitForExportItemFilterResult(String filterField, String filterValue) {

        waitHelper.waitForInvisibilityofElment(progressBar, 120);
        // waitHelper.waitForTextMatches(exportItemFilterResultFooter, 120, ("Displaying"));

        if (filterField.equals("External code")) {
            waitHelper.waitForTextToBePresentInElementLocated(externalCode, 120, filterValue);
        } else if (filterField.equals("Code")) {

            waitHelper.waitForTextToBePresentInElementLocated(exportItemCode, 120, filterValue);
        } else if (filterField.equals("Display name")) {

            waitHelper.waitForTextToBePresentInElementLocated(displayName, 120, filterValue);
        }
    }

    // This will be used to navigate to export export scheduler and click at it.
    public void gotoExportScheduler() {
        log.info("User is trying to click at export scheduler now/../....");
        waitHelper.waitForElementClickable(exportScheduler, 120);
        exportScheduler.click();
        log.info("Export job scheduler has been clicked....");
        jsHelper.scrollByScreenHeightUp();
    }

    //FredHopper channel has a different menu name for this
    public void gotoExport() {
        clickWhenReady(export);
    }


    // This method trigger's export job by ID
    public String triggerExport(String jobID) {

        //clickWhenReady(By.xpath("//tr[@id='job_" + jobID + "']/td[7]/div/button"));
        WebElement triggerJobCog = driver.findElement(By.xpath("//tr[@id='job_" + jobID + "']/td[7]/div/button"));
        try {
            waitHelper.waitForElementClickable(triggerJobCog, 120);
            triggerJobCog.click();
            waitHelper.waitForElementClickable(triggerBtn, 120);
            triggerBtn.click();
            log.info("Export job was attempted.");
        } catch (NoSuchElementException e) {
            gotoExportScheduler();
            waitHelper.waitForElementClickable(triggerJobCog, 120);
            triggerJobCog.click();
            waitHelper.waitForElementClickable(triggerBtn, 120);
            triggerBtn.click();
            log.info("Export job was attempted again.");
        }

        //get current timestamp to varify export job
        Calendar calendarInstance = Calendar.getInstance();
        ccDateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        String triggeredTime = ccDateFormat.format(calendarInstance.getTime());

        log.info("Job is triggered at " + triggeredTime);
        //need to click somewhere else to reveal the other cogs
        waitHelper.waitForElementClickable(frequencyHeader, 120);
        frequencyHeader.click();

        return triggeredTime;
    }

    // Wait Method: To wait till the export job items complete....
    public String[] waitTillExportComplets(String str1, int numberofJobs, int timeoutSeconds) throws InterruptedException, ParseException {
        gotoExportJobsTab();

        if (numberofJobs == 1) {
            jobType = By.xpath("//td");
            startedAt = By.xpath("//td[3]");
            totalItem = By.xpath("//td[5]");
            failedItem = By.xpath("//td[6]");
            jobStatus = By.xpath("//td[8]");
        } else {
            jobType = By.xpath("//tr[" + numberofJobs + "]/td");
            startedAt = By.xpath("//tr[" + numberofJobs + "]/td[3]");
            totalItem = By.xpath("//tr[" + numberofJobs + "]/td[5]");
            failedItem = By.xpath("//tr[" + numberofJobs + "]/td[6]");
            //This is for BigcommerceV3 channel. Only when the last job finishes, then we can say the whole job completed
            lastJobType = By.xpath("//td");
            jobStatus = By.xpath("//td[8]");
        }


        int refreshExportCount = 0;
        String strStartedAt = getWhenVisible(startedAt).getText();
        String[] jobDetails = new String[5];

        log.info("Waiting for export job to finish...");
        //BigcommerceV3 channel is different from all other channels.
        //It generates some temporary jobs which show for a few seconds then disappear
        //For above reasons, this part is only for BigcommerceV3 channel to deal with the temporary jobs problem
        if (numberofJobs == 4) {
            refreshExportCount = 0;
            jobDetails[0] = getWhenVisible(jobType).getText();
            String shadowAfterAWhile = "";
            while (!jobDetails[0].equals("product") || !shadowAfterAWhile.equals("product") || ccDateFormat.parse(strStartedAt).before(ccDateFormat.parse(str1))) {
                Thread.sleep(5000);
                driver.navigate().refresh();
                refreshExportCount++;
                log.info("Refresh number " + refreshExportCount);
                if (refreshExportCount > EXPORTREFRESHTRIES) {
                    log.error("Has reached maximum retry!");
                    break;
                }
                jobDetails[0] = getWhenVisible(jobType).getText();
                //following is to make sure that it's not a temporary job which will disappear after a few seconds
                //job type and its shadow have to be BOTH "product", then we can say export job finished.
                Thread.sleep(10000);
                shadowAfterAWhile = getWhenVisible(jobType).getText();
                strStartedAt = getWhenVisible(startedAt).getText();
            }
        }

        while (ccDateFormat.parse(strStartedAt).before(ccDateFormat.parse(str1))) {
            Thread.sleep(EXPORTREFRESHINTERVAL);
            driver.navigate().refresh();
            refreshExportCount++;
            log.info("Refresh number " + refreshExportCount);
            if (refreshExportCount > EXPORTREFRESHTRIES) {
                log.error("Has reached maximum retry!");
                break;
            }
            strStartedAt = getWhenVisible(startedAt).getText();
        }

        try {
            //wait till export job to finish. Right now the time out is 6 minutes.
            WebDriverWait PSexportWait = new WebDriverWait(driver, timeoutSeconds);
            PSexportWait.until(ExpectedConditions.textToBePresentInElementLocated(jobStatus, "ed"));
            jobDetails[0] = getWhenVisible(jobType).getText();
            jobDetails[1] = getWhenVisible(startedAt).getText();
            jobDetails[2] = getWhenVisible(failedItem).getText();
            jobDetails[3] = getWhenVisible(totalItem).getText();
            jobDetails[4] = getWhenVisible(jobStatus).getText();
            log.info(jobDetails[0] + " export job triggered at " + jobDetails[1] + " is " + jobDetails[4] + ": " + jobDetails[2] + " failed in " + jobDetails[3] + " items.");
        } catch (TimeoutException ex) {
            StringWriter waitErrorMsg = new StringWriter();
            ex.printStackTrace(new PrintWriter(waitErrorMsg));
            log.info("Export didn't finish. Timeout." + waitErrorMsg);
        }

        return jobDetails;
    }

    // Error Message: View and report error message
    public String checkErrorMessage() {
        String errorMessageTitle;
        waitHelper.waitForElementClickable(topCog, 120);
        topCog.click();
        waitHelper.waitForElementClickable(viewErrorMenu, 120);
        viewErrorMenu.click();
        waitHelper.waitForElementVisible(errorMsg, 120);
        errorMessageTitle = errorMsg.getText().substring(0, 8);
        waitHelper.waitForElementClickable(closeBtn, 120);
        closeBtn.click();
        log.info("Error message starts with: " + errorMessageTitle);

        return errorMessageTitle;
    }

    // Failed Item: Restage failed item...
    public void restageFailedItems() throws InterruptedException {
        gotoExportItemsTab();

        waitHelper.waitForElementClickable(topCog, 120);
        topCog.click();
        waitHelper.waitForElementClickable(stageMenu, 120);
        stageMenu.click();
        log.info("Failed items are restaged.");
    }


    //Collect Export items information for Simple Export channel and its inherited channels
    //such as Borderfree, Facebook etc
    public String[][] collectSimpleExportItems(String filterBy, String filterBy2, String[] filterValue, int numberOfResult) throws InterruptedException {

        gotoExportItemsTab();
        WebElement filter = null;
        String prodCode = "";
        String prodStatus = "";
        String prodUpdatedAt = "";
        String prodType = "";

        String[][] exportItems = new String[numberOfResult][4];
        int index = 0;
        if (filterBy.equals("Display name")) {
            filter = getWhenVisible(exportCHDisplayNameFilter);
        } else if (filterBy.equals("Code")) {
            filter = getWhenVisible(exportCHCodeFilter);
        }
        Select itemType = new Select(getWhenVisible(exportCHTypeFilter));
        itemType.selectByVisibleText(filterBy2);
        log.info("Item type selected is: " + filterBy2);

        for (int i = 0; i < numberOfResult; i++) {
            filter.clear();
            filter.sendKeys(filterValue[i]);
            filter.sendKeys(Keys.ENTER);
            waitForExportItemFilterResult(filterBy, filterValue[i]);

            prodCode = getWhenVisible(exportCHCodeField).getText();
            prodType = getWhenVisible(exportCHTypeField).getText();
            prodStatus = getWhenVisible(exportCHStatusField).getText();
            prodUpdatedAt = getWhenVisible(exportCHUpdatedField).getText();

            exportItems[index][0] = prodStatus;            //this has to be validation status
            exportItems[index][1] = prodCode;            //spare field
            exportItems[index][2] = prodUpdatedAt;        //this has to be validation time
            exportItems[index][3] = prodStatus;            //spare field

            log.info(String.format("%-10s: %-8s is %s as at %s.", prodType, prodCode, prodStatus, prodUpdatedAt));

            index++;
        }
        return exportItems;
    }


    //Fetch item content by Filter
    public String fetchItemContent(String filterBy, String filterValue) throws InterruptedException {

        WebElement filterItem = null;
        String itemContent = "";

        if (!driver.getCurrentUrl().contains("items")) {
            gotoExportItemsTab();
        }

        if (filterBy.equals("Code")) {
            filterItem = getWhenVisible(exportCHCodeFilter);
        } else if (filterBy.equals("Display name")) {
            filterItem = getWhenVisible(exportCHDisplayNameFilter);
        } else if (filterBy.equals("External code")) {
            filterItem = getWhenVisible(externalCodeField);
        }
        filterItem.clear();
        filterItem.sendKeys(filterValue);
        filterItem.sendKeys(Keys.ENTER);
        waitHelper.waitForInvisibilityofElment(progressBar, 90);
        //Sometimes when progress bar finishes, it doesn't guarantee that the screen is ready
        Thread.sleep(2000);

        clickWhenReady(topCog1);
        clickWhenReady(viewDataMenu);

        itemContent = getWhenVisible(jsonPayload).getText();

        clickWhenReady(closeButton);

        return itemContent;
    }


    //Fetch first item content by type, 'Type' field is using dropdown list
    //this function can be extended in the future to deal with dropdown list filtering
    public String fetchFirstItemContentByType(String type) throws InterruptedException {
        WebElement ItemCode = null;
        String itmeContent = "";
        if (!driver.getCurrentUrl().contains("items")) {
            gotoExportItemsTab();
        }
        ItemCode = getWhenVisible(externalCodeField);
        ItemCode.clear();
        Select itemType = new Select(getWhenVisible(itemTypeField));
        itemType.selectByVisibleText(type);
        log.info("Item type selected is: " + type);
        clickWhenReady(exportItemFilterBtn);
        waitHelper.waitForInvisibilityofElment(progressBar, 90);
        //Sometimes when progress bar finishes, it doesn't guarantee that the screen is ready
        Thread.sleep(2000);

        clickWhenReady(firstItemID);

        itmeContent = getWhenVisible(jsonPayload).getText();

        clickWhenReady(closeButton);

        return itmeContent;
    }


    // Method to consolidate and collect all result details....
    public String[][] collectExportResult(Boolean hasCommon, String filterBy, String filterBy2, String[] filterValue, int numberOfResult) throws InterruptedException {

        gotoExportItemsTab();

        WebElement filter = null;
        String prodExternalCode = "";
        String prodExportStatus = "";
        String prodExportTime = "";
        String prodType = "";
        String prodExternalStatus = "";
        String[][] exportInfo = new String[numberOfResult][4];
        String prodStatus = "";

        try {

            if (hasCommon) {
                String localFilterValue = "";
                if (filterBy.equals("Display name")) { //This is used by ebay channel
                    filter = getWhenVisible(displayNameField);
                    filter.clear();
                    //This is to make sure every branch is able to send this value when calling waitForExportItemFilterResult below
                    localFilterValue = filterValue[1];
                    filter.sendKeys(filterValue[1]);
                } else if (filterBy.equals("External code")) { //This is used by Magento2, Iconic V3, Market channel
                    filter = getWhenVisible(externalCodeField);
                    filter.clear();
                    filter.sendKeys(filterValue[0]);
                    localFilterValue = filterValue[0];
                    log.info("External code set: " + filterValue[0]);

                    Select itemType = new Select(getWhenVisible(itemTypeField));
                    if (!filterBy2.equals("blank")) {
                        itemType.selectByVisibleText(filterBy2);
                    }
                    log.info("Item type selected is: " + filterBy2);
                } else if (filterBy.equals("Code")) { //This is used by Google, BigCommerce, Facebook channel
                    filter = getWhenVisible(codeField);
                    filter.clear();
                    filter.sendKeys(filterValue[0]);
                    localFilterValue = filterValue[0];
                }
                clickWhenReady(exportItemFilterBtn);
                waitForExportItemFilterResult(filterBy, localFilterValue.replaceAll("%", ""));        //IconicV3 and Magento2 use '%' to filter channel items

                //for this test product, it has 1 Variation master and 6 Simple products
                for (int j = 0; j < numberOfResult; j++) {
                    if (j == 0) {
                        prodType = getWhenVisible(exportItemtype).getText();
                        prodExternalCode = getWhenVisible(externalCode).getText();
                        prodExportStatus = getWhenVisible(exportStatus).getText();
                        prodExportTime = getWhenVisible(updatedAt).getText();
                        prodExternalStatus = getWhenVisible(externalStatus).getText();
                        prodStatus = getWhenVisible(exportItemStatus).getText();
                    } else {
                        prodType = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[6]")).getText();
                        prodExternalCode = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[5]")).getText();
                        prodExportStatus = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[9]")).getText();
                        prodExportTime = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[10]")).getText();
                        prodExternalStatus = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[8]")).getText();
                        prodStatus = getWhenVisible(By.xpath("//tr[" + (j + 1) + "]/td[7]")).getText();

                    }

                    exportInfo[j][0] = prodExportStatus;
                    exportInfo[j][1] = prodExternalStatus;
                    exportInfo[j][2] = prodExportTime;
                    exportInfo[j][3] = prodStatus;

                    log.info(String.format("%-20s: %-51s is %s, %s and %s at %s.", prodType, prodExternalCode, prodStatus, prodExternalStatus, prodExportStatus, prodExportTime));
                }
            } else {

                Select itemType = new Select(getWhenVisible(itemTypeField));
                itemType.selectByVisibleText(filterBy2);
                log.info("Channel Item type selected is: " + filterBy2);

                if (filterBy.equals("External code")) {
                    filter = getWhenVisible(externalCodeField);
                } else if (filterBy.equals("Code")) {
                    filter = getWhenVisible(codeField);
                }
                int index = 0;
                for (String i : filterValue) {

                    filter.clear();
                    filter.sendKeys(i);
                    filter.sendKeys(Keys.ENTER);
                    waitForExportItemFilterResult(filterBy, i);

                    prodType = getWhenVisible(exportItemtype).getText();
                    prodExternalCode = getWhenVisible(externalCode).getText();
                    prodStatus = getWhenVisible(exportItemStatus).getText();
                    prodExternalStatus = getWhenVisible(externalStatus).getText();
                    prodExportStatus = getWhenVisible(exportStatus).getText();
                    prodExportTime = getWhenVisible(updatedAt).getText();

                    exportInfo[index][0] = prodExportStatus;
                    exportInfo[index][1] = prodExternalStatus;
                    exportInfo[index][2] = prodExportTime;

                    log.info(String.format("%-20s: %-51s is %s, %s and %s at %s.", prodType, prodExternalCode, prodStatus, prodExternalStatus, prodExportStatus, prodExportTime));
                    index++;
                }
            }
        } catch (Exception e) {

            Calendar instance = Calendar.getInstance();
            String orderDate = new SimpleDateFormat("YYYY_MM_dd'T'HH_mm_ss").format(instance.getTime());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File tgtFile = new File("C:\\CaptureScreenshot\\ExportFailedAt_" + orderDate + ".jpg");
            try {
                FileUtils.copyFile(scrFile, tgtFile);
            } catch (Exception ioe) {
                log.info("Cannot save screenshot.");
            }
            e.printStackTrace();
            log.error("Exception! Product: " + filterValue[0] + " is NOT in this export.");
        }
        return exportInfo;
    }

    public boolean CustomFieldsExistingInChannelItem(String expectedCustomFields, String itemCode) {
        boolean result = false;

        return result;
    }

    public void gotoImportJobsTab() {
        clickWhenReady(importJobsTab);
        wait.until(ExpectedConditions.elementToBeClickable(importItemsHeader));
    }


    public String importSome(String jobType) {
        gotoImportJobsTab();
        clickWhenReady(manualImportBtn);

        //set the from date and to date
        Calendar calendarInstance = Calendar.getInstance();
        ccDateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        calendarInstance.add(Calendar.DATE, -1);
        String fromDate = ccDateFormat.format(calendarInstance.getTime());
        calendarInstance.add(Calendar.DATE, 2);
        String toDate = ccDateFormat.format(calendarInstance.getTime());

        WebElement importForm = getWhenVisible(importPopup);
        log.info("Found popup window for import job.");

        Select jobTypeDropdown = new Select(importJobType);
        jobTypeDropdown.selectByValue(jobType);

        if (jobType.equals("product") && isElementPresent(importJobID)) {
            Select jobDropdown = new Select(importForm.findElement(importJobID));
            jobDropdown.selectByVisibleText("Import Product");
            log.info("Select 'Import Product' job.");
        }

        if (jobType.equals("ocapi_order") && isElementPresent(importJobID)) {
            Select jobDropdown = new Select(importForm.findElement(importJobID));
            jobDropdown.selectByVisibleText(jobType);
            log.info("Select 'Ocapi order' job.");
        }

        if (jobType.equals("order") && isElementPresent(importJobID)) {
            Select jobDropdown = new Select(importForm.findElement(importJobID));
            jobDropdown.selectByVisibleText(jobType);
            log.info("Select 'order V5' job.");
        }

        WebElement updatedFrom = importForm.findElement(importJobFrom);
        updatedFrom.click();
        updatedFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        updatedFrom.sendKeys(fromDate);
        log.info("Set 'from date' as " + fromDate + ".");

        WebElement updatedTo = importForm.findElement(importJobTo);
        updatedTo.click();
        updatedTo.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        updatedTo.sendKeys(toDate);
        log.info("Set 'to date' as " + toDate + ".");

        clickWhenReady(importPopupSaveBtn);
        log.info("Clicked to import " + jobType);

        //get the order import time. It's often 1 minute late than current time.
        calendarInstance = Calendar.getInstance();
        String importTime = ccDateFormat.format(calendarInstance.getTime());
        log.info(jobType + " import job was triggered at " + importTime);

        return importTime;
    }

    public boolean isElementPresent(By locator) {
        try {
            String fieldName = driver.findElement(locator).getAttribute("name");
            if (!fieldName.isEmpty()) {
                //SFCC and NetSuite has this 'Job' field
                log.info("'Job' field exists.");
                return true;
            }
            log.info("'Job' field doesn't exist.");
            return false;
        } catch (NoSuchElementException e) {
            log.error("No such Element exception.");
            return false;
        }
    }

    public String[] waitTillImportComplete(String importTriggeredTime) throws InterruptedException, ParseException {
        //Refresh to get the latest import job status
        int refreshImportCount = 0;
        driver.navigate().refresh();
        //String startedAt = getWhenVisible(importStartedAt).getText();
        waitHelper.waitForElementVisible(importStartedAt, 60);
        String startedAt = importStartedAt.getText();
        while (ccDateFormat.parse(startedAt).before(ccDateFormat.parse(importTriggeredTime))) {
            Thread.sleep(ORDERIMPORTREFRESHINTERVAL);
            driver.navigate().refresh();
            refreshImportCount++;
            log.info("Refresh number " + refreshImportCount);
            if (refreshImportCount >= IMPORTREFRESHTRIES) break;
            //startedAt = getWhenVisible(importStartedAt).getText();
            waitHelper.waitForElementVisible(importStartedAt, 60);
            startedAt = importStartedAt.getText();
        }

        String[] importJobResult = new String[2];
        try {
            WebDriverWait OrderImportWait = new WebDriverWait(driver, ORDERIMPORTWAIT);
            //OrderImportWait.until(ExpectedConditions.textToBePresentInElementLocated(importStatus, "ed"));
            waitHelper.waitForTextToAppear(importStatus, "ed");
            importJobResult[0] = importFinishedAt.getText();
            importJobResult[1] = importStatus.getText();
            log.info("Import job is " + importJobResult[1] + " at " + importJobResult[0]);
        } catch (TimeoutException te) {
            StringWriter exceptionMsg = new StringWriter();
            te.printStackTrace(new PrintWriter(exceptionMsg));
            log.info("Import timed out. Check the background jobs." + exceptionMsg.toString());
        }

        return importJobResult;
    }


    // Exported Item Validation Method .....
    public boolean[] validateExport(boolean isSimpleExport, String[][] exportInfo, Date triggeredTime, int numberOfItem, String externalStatus) {
        boolean[] channelItemsActual = new boolean[numberOfItem];

        Date itemExportTime = new Date();
        for (int i = 0; i < numberOfItem; i++) {
            try {
                itemExportTime = ccDateFormat.parse(exportInfo[i][2]);
                log.info("validateExport -> itemExportTime: " + itemExportTime.toString() + " validateExport -> triggeredTime: " + triggeredTime.toString());
                log.info("!(itemExportTime.before(triggeredTime)): " + !(itemExportTime.before(triggeredTime)));
                log.info("validateExport -> exportInfo[i][0]: " + exportInfo[i][0] + " exportInfo[i][0].contains(\"Exported\"): " + exportInfo[i][0].contains("Exported"));
                log.info("validateExport -> exportInfo[i][1]: " + exportInfo[i][1] + " exportInfo[i][1].equals(externalStatus): " + exportInfo[i][1].equals(externalStatus));
            } catch (Exception e) {
                log.info(e.getMessage());
            }

            if (!isSimpleExport) {
                channelItemsActual[i] = exportInfo[i][0].contains("Exported") && !(itemExportTime.before(triggeredTime)) && exportInfo[i][1].equals(externalStatus);
            } else {
                channelItemsActual[i] = exportInfo[i][0].equals(externalStatus) && !(itemExportTime.before(triggeredTime));
            }
        }
        return channelItemsActual;
    }


    public void scrollToPageItem() {
        jsHelper.scrollDownByPixel();
        log.info("Scrolling to page item by 1080....");
    }


}
