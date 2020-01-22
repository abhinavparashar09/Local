package cucumberBase.pageFactory;


import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AdvanceSearchPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(AdvanceSearchPage.class);
    @FindBy(xpath = ".//*[@id='product-list-page']/table/thead/tr/th")
    List<WebElement> tableCol;
    @FindBy(xpath = ".//*[@id='product-list-page']/table/tbody/tr/td[3]")
    List<WebElement> tableRows;

    @FindBy(xpath = " //*[@id=\"open_tree\"]")
    private WebElement lnkAdvanceSearchLink;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Refine By')]") // this one change
    private WebElement lnkAdvSrhDropdown;
    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement btnSearchSubmit;
    @FindBy(xpath = "//div[contains(@class,'dataTables_info')]")
    private WebElement searchResultFooter;
    /**
     * These are all locator for Advance search
     */

    @FindBy(xpath = "(//label[contains(.,'ID')])[4]")
    private WebElement lstItemId;
    @FindBy(xpath = "//input[contains(@id,'filter_data_id')]")
    private WebElement searchTxtBoxID;
    @FindBy(xpath = "//label[@class='checkbox'][contains(.,'Name')]")
    private WebElement lstItemName;
    @FindBy(xpath = "//*[@id=\"filter_data_name\"]")
    private WebElement searchTxtBoxName;
    @FindBy(xpath = "(//label[@class='checkbox'][contains(.,'Code')])[1]")
    private WebElement lstItemCode;
    @FindBy(xpath = "//input[contains(@id,'filter_data_code')]")
    private WebElement searchTxtBoxCode;
    @FindBy(id = "filter_data_name_op")
    private WebElement compareDropdownName;
    @FindBy(id = "filter_data_code_op")
    private WebElement compareDropdownCode;

    /**
     * This is constructor
     *
     * @param driver
     */
    public AdvanceSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    /**
     * These are Action method for Advance Search Page
     */
    // This method will be used to click at advance search link for searching products
    public void clickAdvancedSearchLink() {
        waitHelper.waitForElementClickable(lnkAdvanceSearchLink, 120);
        lnkAdvanceSearchLink.click();
        log.info("Advance filter link has been clicked....");
        // jsHelper.scrollToElement(searchResultFooter);
        //  waitHelper.waitForTextToAppear(searchResultFooter, "Displaying");
        //  jsHelper.scrollByScreenHeightUp();

    }


    // This method will be used to open advance search dropdown for selecting search criteria
    public void clickAdvSearchDropdown() {
        waitHelper.waitForElementVisible(lnkAdvSrhDropdown, 120);
        lnkAdvSrhDropdown.click();
        log.info("Advance Search filter refine by button has been clicked.... ");
    }


    /**
     * These are Action method for Search By ID
     */
    // Search BY Attribute ID : This method will be used to click at Advance Search Dropdown to select search criteria
    public void clickLstItemId() {

        waitHelper.waitForElementClickable(lstItemId, 90);
        lstItemId.click();
    }


    // Search BY ID text: This method is to enter the search text phrase
    public void enterSearchTextId(String searchtext) {
        waitHelper.waitForElementClickable(searchTxtBoxID, 90);
        searchTxtBoxID.sendKeys(searchtext);

    }

    /**
     * These are Action method for Search By Name
     */
    // Search BY Attribute Name : This method will be used to click at Advance Search Dropdown to select search criteria
    public void clickLstItemName() {
        waitHelper.waitForElementClickable(lstItemName, 90);
        lstItemName.click();
    }

    // Search BY Name text: This method is to enter the search text phrase
    public void enterSearchTextName(String searchTxtName) {
        waitHelper.waitForElementClickable(searchTxtBoxName, 90);
        searchTxtBoxName.sendKeys(searchTxtName);


    }


    // This method will be used to select search comparitor i.e. equal, contains,black, is not blank
    public Select selectComparitorName() {
        waitHelper.waitForAllElementVisible(compareDropdownName, 90);
        return new Select(compareDropdownName);

    }

    /**
     * These are Action method for Search By Code
     */
    // Selecting search by Code
    public void clickLstItemCode() {
        waitHelper.waitForElementClickable(lstItemCode, 90);
        lstItemCode.click();
    }


    // Entering text for searching product
    public void enterSearchTextCode(String searchTxtCode) {
        waitHelper.waitForElementClickable(searchTxtBoxCode, 90);
        searchTxtBoxCode.clear();
        searchTxtBoxCode.sendKeys(searchTxtCode);


    }


    // This method will be used to select search comparitor i.e. equal, contains,black, is not blank
    public Select selectComparitorCode() {
        waitHelper.waitForAllElementVisible(compareDropdownCode, 90);
        return new Select(compareDropdownCode);

    }


    // This method will be used to submit search requests
    public void clickSubmitSearchButton() {
        waitHelper.waitForElementClickable(btnSearchSubmit, 90);
        btnSearchSubmit.click();
        //WebDriverWait wait = new WebDriverWait(ldriver, 30);
        //wait.until(ExpectedConditions.textMatches(searchResultFooter, Pattern.compile("Displaying .+ products?")));
    }



/* EXAMPLE TO USE SELECT DROPDOWN IN PAGE OBJECT
    public Select clickLstItemId(){
        waitH.WaitForElementVisible(lstItemId, 30);
        return new Select(lstItemId);
    }

 */


}
