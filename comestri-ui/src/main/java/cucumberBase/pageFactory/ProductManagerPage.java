package cucumberBase.pageFactory;


import cucumberBase.driverFactory.managers.FileReaderManager;
import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static cucumberBase.pageFactory.CommonMethods.*;


public class ProductManagerPage extends PageBase {


    private final Logger log = LoggerHelper.getLogger(ProductManagerPage.class);
    By uploadResult1 = By.xpath("//td[10]/div");
    By productHeader = By.xpath("//h2");
    By prdID = By.xpath("//*[@id=\"product_id\"]");
    private AdvanceSearchPage objAdvSrh;

    /**
     * THese are all locator for Product PIM section
     */
    @FindBy(xpath = "//a[@class='js-sub-menu-toggle'][contains(.,'Products')]")
    private WebElement lnkProductsMenu;
    @FindBy(xpath = "//span[@class='text'][contains(.,'Manage Products')]")
    private WebElement lnkManageProducts;
    @FindBy(xpath = "//*[@id=\"open_tree\"]") // this one changed
    private WebElement lnkAdvanceSearchLink;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Refine By')]") // this one changed
    private WebElement lnkAdvSrhDropdown;
    //  @FindBy(xpath = "//h2")
    //  private WebElement productHeader;
    @FindBy(id = "flash")
    private WebElement alert;
    private By productIDTextBox = By.id("product_id");
    @FindBy(linkText = "Manage Jobs")

    private WebElement manageJobs;
    @FindBy(linkText = "Upload Files")
    private WebElement uploadBtn;
    @FindBy(id = "import_file_upload_file")
    private WebElement browseBtn;
    @FindBy(xpath = "//button[2]")
    private WebElement saveBtn;
    @FindBy(xpath = "//td[10]/div")
    private WebElement uploadResult;
    //private By generalTab = By.xpath("//h3[contains(.,'Basic')]");                //This is used to decide whether a product page is fulled loaded
    @FindBy(xpath = "//a[contains(.,'General')]")  // THIS HAS BEEN UPDATED
    private WebElement generalTab;
    @FindBy(linkText = "Custom Attributes")
    private WebElement customAttributesTab;
    @FindBy(xpath = "//a[contains(text(),'Categories')]")
    private WebElement categoriesTab;
    @FindBy(name = "commit")
    private WebElement updProdBtn;
    @FindBy(linkText = "New Category")
    private WebElement newCategoryBtn;
    //Page Object model element locator By locator
    private By codeElement = By.xpath("//span[2]/a");
    private By nameElement = By.xpath("//td[3]");
    private By codeElementV5 = By.xpath("//span[2]/a");
    private By filterButton1 = By.xpath("//button[@type='button']");
    private By codeCheckBox1 = By.xpath("//li[4]/a/label");
    private By codeField1 = By.xpath("//input[contains(@name,'product[of_code]')]");
    //private By codeFieldV51 = By.id("filter_data_code");
    @FindBy(id = "filter_data_code")
    private WebElement codeFieldV51;
    private By saleAttributeOff = By.cssSelector("div.has-switch.switch-off > div > label");
    private By saleAttributeOn = By.cssSelector("div.has-switch.switch-on > div > label");
    //private By searchResultFooter1 = By.cssSelector(".dataTables_info");
    @FindBy(xpath = "//*[@id=\"products\"]/tfoot/tr/td/div/div[1]/div/b[2]")
    private WebElement searchResultFooter1;
    //@FindBy(xpath = "//*[@id=\"products\"]/tfoot/tr/td/div/div[1]/div/b")
    //private WebElement advSearchResultFooter;
    @FindBy(xpath = "//*[@id=\"products\"]/tfoot/tr/td/div/div[1]/div")
    private WebElement advSearchResultFooter;
    private By productHeader1 = By.xpath("//h2");
    private By descField = By.xpath("//div[2]/div[6]");
    private By alertSpan = By.xpath("//*[@id=\"flash\"]/div/span");//By.cssSelector(".alert > span");
    private By variationTab = By.linkText("Variations");
    private By variationTabV5 = By.linkText("Associated Products");

    @FindBy(xpath = "//a[@data-href='show_prices'][contains(.,'Prices')]")
    private WebElement pricesTab;
    @FindBy(id = "all_prices")
    private WebElement pricesTable;

    @FindBy(linkText = "Inventory")
    private WebElement inventoryTab;
    @FindBy(id = "inventories")
    private WebElement inventoriesTable;
    private By firstPriceBook = By.xpath("//tr[1]/td[2]/a");
    private By firstPriceItem = By.xpath("//td/a");
    private By secondPriceItem = By.xpath("//tr[2]/td/a");
    private By thirdPriceItem = By.xpath("//tr[3]/td[8]/div/button/i");
    private By priceAmtPopup = By.id("price_item_amount");
    private By priceToDate = By.id("price_item_to");
    private By popupSaveBtn = By.xpath("//div[@id='cc-popup']/div[2]/div/div[3]/button[2]");
    //private By firstInventoryItem = By.xpath("//tr[1]/td[2]/a");//By.xpath("//tr/td[2]/a");
    @FindBy(xpath = "//tr[1]/td[2]/a")  // THIS HAS BEEN UPDATED
    private WebElement firstInventoryItem;
    private By inventoryQtyPopup = By.id("inventory_qty");
    private By deleteBtn = By.linkText("Delete Product");
    private By progressBar = By.cssSelector("#nprogress .bar");
    private By rootLevelProdInTab = By.xpath("//span/a");
    private By brandField = By.id("product_brand_id");
    private By firstPriceItemCog = By.xpath("//td[8]/div/button/i");
    private By secondPriceItemCog = By.xpath("//tr[2]/td[8]/div/button/i");
    private By plusSign = By.xpath("//a[contains(text(),'+')]");
    private By scheduledJobsMenu = By.linkText("Scheduled Jobs");
    private By firstPriceItemFrom = By.xpath("//td[3]");
    private By firstPriceItemTo = By.xpath("//td[4]");
    private By priceItemRows = By.xpath("//*[@id='price_items']/tbody/tr");
    private By scheduledJobsFilterBtn = By.name("commit");
    private By scheduledJobCreatedAt = By.xpath("//td[5]");
    private By firstJobStatus = By.xpath("//td[8]");
    private By productConfigMenu = By.linkText("Product Configurations");
    private By manageProducts = By.linkText("Manage Products");
    private By priceRulesMenu = By.linkText("Price Rules");
    private By skipProdRulesCheckbox = By.id("rule_skip_product_rules");
    private By startButton = By.xpath("//button[2]");
    private By configAttributes = By.linkText("Attributes");
    private By configAttributeSets = By.linkText("Attribute Sets");
    private By configCategories = By.linkText("Categories");
    private By configCategorySets = By.linkText("Category Sets");
    private By configBrands = By.linkText("Brands");
    private By configPriceBooks = By.linkText("Price Books");
    private By configCatalogs = By.linkText("Catalogs");
    private By configInventorySrcs = By.linkText("Inventory Sources");
    private By configStoreLocations = By.linkText("Store Locations");
    private By configShippingZones = By.linkText("Shipping Zones");
    private By configCarriers = By.linkText("Carriers");
    private By configDataSets = By.linkText("Data Sets");
    private By configLookup = By.linkText("Lookup Tables");
    private By configPunchout = By.linkText("Punchout");
    private By productsMenu = By.linkText("Products");
    private By simpleSearchField = By.name("query");
    private By searchResultItemLink = By.cssSelector("span.break-word-normal > a");
    private By firstColorSKUName = By.xpath("//tr[2]/td[3]");
    private By secondColorSKUName = By.xpath("//tr[5]/td[3]");
    private By magnifierBtn = By.cssSelector("i.btn.btn-primary");
    private By advancedSearchLink = By.linkText("Advanced Search");
    private By searchResultFooter = By.cssSelector(".dataTables_info");
    private By filterButton = By.xpath("//button[@type='button'][contains(.,'Refine By')]");
    ////*[@id="filter_data_form"]/div[142]/div/div/button
    private By codeCheckBox = By.xpath("//li[4]/a/label");
    private By codeField = By.id("product_of_code");
    private By codeFieldV5 = By.id("filter_data_code");
    private By emailName = By.xpath("//div[2]/div/a/span");
    private By mediaTab = By.linkText("Media");
    private By secondColumn = By.xpath("//td[2]/a");
    private By secondInventoryItem = By.xpath("//tr[2]/td[2]/a");
    private By importJobSubmittedAt = By.xpath("//td[2]");
    private By importJobResult = By.xpath("//td[10]/div");
    private By customDescField = By.id("product_product_attributes__description_raw");
    private By htmlDescField = By.xpath("//div[@id='html_attr_description']/div[2]/div[2]/div[6]");
    private By xButton = By.xpath("//div[@id='cc-popup']/div[2]/div/div/button");
    private By imageItemCog = By.xpath("//td[7]/div/button/i");

    @FindBy(xpath = "//table[@id=\"products\"]//td[1]/span/a")
    private WebElement variantsTable;

    @FindBy(id = "product_code")
    private WebElement productCode;

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public ProductManagerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        objAdvSrh = new AdvanceSearchPage(driver);
    }
    //for deleting the specific product

    /**
     * Below are the  Action method for PIM:
     */


////////////////////

    // This method will be used to click at Product section of Product Manager's menu
    public void clickProductsMenu() {
        System.out.println("You are on Homepage of comestri ....");
        waitHelper.waitForElementClickable(lnkProductsMenu, 120);
        lnkProductsMenu.click();
        log.info("Product Menu from PIM has been clicked .... ");

    }

    // This method will be used to click at manage product section of Product Manager
    public void clickManageProducts() {
        waitHelper.waitForElementClickable(lnkManageProducts, 120);
        lnkManageProducts.click();
        log.info("Manage product link has been clicked now .... ");
        jsHelper.scrollDownByPixel();
        //waitHelper.waitForTextToBePresentInElementLocated(searchResultFooter1, 120, "Displaying ");
        waitHelper.waitForElementVisible(searchResultFooter1, 120);
        log.info("Total value of results " + searchResultFooter1.getText());


    }

    //This is to click the product code link in the search result
    public void gotoProduct(String prodcode) {
        //clickWhenReady(By.linkText(prodcode));
        try {
            WebElement productCodeLink = driver.findElement(By.linkText(prodcode));
            waitHelper.waitForElementClickable(productCodeLink, 120);
            productCodeLink.click();
        } catch (StaleElementReferenceException ex) {
            WebElement productCodeLink = driver.findElement(By.linkText(prodcode));
            waitHelper.waitForElementClickable(productCodeLink, 120);
            productCodeLink.click();
        }
        waitHelper.waitForTextToBePresentInElementLocated(productHeader1, 120, prodcode);
        log.info("User has navigated to product....");

    }

    // Navigating to VariantTab
    public void clickVariantTab(boolean isVersion5) {
        if (!isVersion5) {
            clickWhenReady(variationTab);
            log.info("clicked Variation Tab OF v3");
        } else {
            clickWhenReady(variationTabV5);
            log.info("clicked 'Associated Products' Tab");
        }
    }


    // This method will be used to click at Manage Jobs section of Product Manager
    private void clickManageJobs() {
        waitHelper.waitForElementClickable(manageJobs, 120);
        manageJobs.click();
    }


    public void expandProduct() {
        clickWhenReady(plusSign);
    }


    public void clickCustomAttributesTab() {
        waitHelper.waitForElementClickable(customAttributesTab, 120);
        customAttributesTab.click();
    }


    public void gotoCategoriesTab() {

        waitHelper.waitForElementClickable(categoriesTab, 120);
        categoriesTab.click();
        waitHelper.waitForElementClickable(newCategoryBtn, 120);
        log.info("clicked 'Categories' Tab");
    }

    public void gotoPricesTab() {
        waitHelper.waitForElementClickable(pricesTab, 120);
        pricesTab.click();
    }


    //This method will be used to upload CSV for product
    public String uploadProdCSV(String CSVFilePath) throws InterruptedException {
        //creat a new product via CSV upload
        clickManageJobs();
        waitHelper.waitForElementClickable(uploadBtn, 120);
        uploadBtn.click();
        //clickWhenReady(browseBtn);

        //WebElement ccPopup = driver.findElement(By.id("new_import_file_upload"));

        waitHelper.waitForElementVisible(browseBtn, 120);
        browseBtn.sendKeys(CSVFilePath);

        //This method is skipped because Robot class won't work when this script
        //is running on remote server. This method works fine if running on local machine.
		/*try {
			Keyboard keyboard = new Keyboard();
			keyboard.type(CSVFilePath);

			Robot rb = new Robot();
			//'Enter' key cannot be entered with the other keys at the same time
			Thread.sleep(2000);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			StringWriter robotErrorMsg = new StringWriter();
			e.printStackTrace(new PrintWriter(robotErrorMsg));
		}*/

        waitHelper.waitForElementVisible(saveBtn, 120);
        saveBtn.click();


        //Refresh to get the latest import job status
        String result = "";
        do {
            Thread.sleep(CSVREFRESHINTERVAL);
            driver.navigate().refresh();
            waitHelper.waitForElementVisible(uploadResult, 120);
            result = uploadResult.getText();

        } while (result.equals("Pending"));
        WebDriverWait CSVwait = new WebDriverWait(driver, CSVUPLOADTIMEOUT);
        CSVwait.until(ExpectedConditions.invisibilityOfElementWithText(uploadResult1, "Pending"));

        return result;

    }

    //Method to perform AdvanceSearch to find uploaded product
    public void advancedSearchProduct(String prodCode, Boolean isVersion5) {

        clickManageProducts();
        objAdvSrh.clickAdvancedSearchLink();
        log.info("Now user will try to locate version of comestri....");
        WebElement codeFieldElement;
        if (!isVersion5) {
            log.info("Test if it is here in V3");
            codeFieldElement = getWhenVisible(codeField1);
            log.info("User tying to locate field of version3");
        } else {
            log.info("Test if it is here in V5");
            clickWhenReady(filterButton);
            log.info("User tying to locate field of version5");
            clickWhenReady(codeCheckBox);
            codeFieldElement = getWhenVisible(codeFieldV5);
        }
        codeFieldElement.clear();
        codeFieldElement.sendKeys(prodCode);
        log.info("User tying to click send the searchable keyword");
        codeFieldElement.sendKeys(Keys.ENTER);
        // waitHelper.waitForTextMatches(searchResultFooter1, 120, "Displaying .+ products?");
    }


    //Search product by product Code
    public void simpleSearchProduct(String prodCode) {

        WebElement searchText = getWhenVisible(simpleSearchField);
        searchText.clear();
        searchText.sendKeys(prodCode);
        clickWhenReady(magnifierBtn);
        waitHelper.waitForElementVisible(advSearchResultFooter, 120);
        log.info("Simple search results as " + advSearchResultFooter.getText());
    }

    //Get Product ID in CommerceConnect through Advanced Search
    public String[] getProductCodeAndName(Boolean isVersion5) {

        if (!isVersion5) {
            codeAndName = new String[]{getWhenVisible(codeElement).getText(), getWhenVisible(nameElement).getText()};
        } else {
            codeAndName = new String[]{getWhenVisible(codeElementV5).getText(), getWhenVisible(nameElement).getText()};
        }
        log.info("Search product is visible now.... " + codeElementV5);
        return codeAndName;

    }


    //Get Product ID in CommerceConnect through Advanced Search
    public String getProductID(String searchKeyword) {
        String productID = "";
        boolean searchResult2 = getWhenVisible(By.linkText(searchKeyword)).isDisplayed();

        //get product ID for later use
        if (searchResult2) {
            // codeElementV5.click();
            clickWhenReady(By.linkText(searchKeyword));
            waitHelper.waitForElementClickable(generalTab, 120);
            String strProductID = driver.findElement(prdID).getAttribute("value");
            log.info("Value is : " + strProductID);
            log.info("New product " + searchKeyword + " can be searched in PIM. Product ID is " + strProductID);
            productID = strProductID;
        }
        return productID;
    }


    public void updateProductDescription(Boolean isVersion5) {
        //update description
        WebElement productDescription;
        if (isVersion5) {
            waitHelper.waitForElementClickable(customAttributesTab, 90);
            customAttributesTab.click();
            productDescription = getWhenVisible(descField);
        } else {
            productDescription = getWhenVisible(descField);
        }
        log.info("Old description is: " + productDescription.getText());
        productDescription.clear();
        String uid = UUID.randomUUID().toString();
        productDescription.sendKeys(uid);
        log.info("New description is random UUID: " + uid);
        waitHelper.waitForElementClickable(updProdBtn, 120);
        updProdBtn.click();
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 120, "Product was successfully updated");
    }

//  waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 120, "Price was successfully updated");


    public void updateProductPrice(Boolean isVersion5, String prodCode) throws InterruptedException {
        Thread.sleep(1000);
        clickVariantTab(isVersion5);
        waitHelper.waitForTextToAppear(variantsTable, prodCode);
        //       Thread.sleep(2000);
        By str = By.linkText(prodCode + "_red");
        //'Associated Products' tab sometimes doesn't load at all
        try {
            log.info("Now user will try to click...test...");
            //log.info("value of productcode is : " + prodCode);
            log.info("value of productcode red is : " + str);

            clickWhenReady(str);
            log.info("clicked color level product." + str);
        } catch (TimeoutException toe) {
            log.error("unable to click the product with color red,..,.");
            String url = driver.getCurrentUrl();
//            log.info("Page URL not loading: " + url);
            //JIRA bug CCD-2844, once 'Variation' tab's stuck, refresh page will redirect to Dashboard page.
            driver.navigate().refresh();
            log.info("Refresh the page");
            driver.get(url);
            log.info("Retry this URL");
            clickWhenReady(By.linkText(prodCode + "_red"));
            log.info("clicked color level product again." + str);
        }
        //waitHelper.waitForElementVisible(productCode,120);
        //Wait on general page for getting ready for Price tab page
        Thread.sleep(2000);
        log.info("Trying to click Prices tab---");
        waitHelper.waitForElementClickable(pricesTab, 120);
        pricesTab.click();
        log.info("clicked Prices tab");
        Thread.sleep(3000);
        //waitHelper.waitForElementVisible(pricesTable, 120);
        if (!getWhenVisible(firstPriceBook).getText().startsWith("default")) {
            clickWhenReady(firstPriceItem);
            log.info("clicked first price amount.");
        } else {
            clickWhenReady(secondPriceItem);
            log.info("clicked second price amount.");
        }

        WebElement price = getWhenVisible(priceAmtPopup);
        log.info("Got the popup window web element.");
        String[] oldPrice = price.getAttribute("value").split("\\.");
        log.info("old price is " + oldPrice[0]);
        price.clear();

        Random rand = new Random();
        int oldPriceValue = Integer.parseInt(oldPrice[0]);
        int newPrice = 0;
        do {
            newPrice = rand.nextInt(38) + 1;
        } while (newPrice == oldPriceValue);
        price.sendKeys(Integer.toString(newPrice));
        log.info("New price is " + newPrice);
        clickWhenReady(popupSaveBtn);
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 120, "Price was successfully updated");
        log.info("New price is saved.");
    }


    //Update product with 3 price items, V3 Product CSV template has 4 price items for grey colour
    public void updateProductPrices(Boolean isVersion5, String prodCode) {
        clickVariantTab(isVersion5);
        log.info("clicked Variation Tab");
        //'Associated Products' tab sometimes doesn't load at all
        try {
            log.info("clicked color level product.");
        } catch (TimeoutException toe) {
            log.error("'Associated Products' tab not loading...");
            String url = driver.getCurrentUrl();
            log.info("Page URL not loading: " + url);
            //JIRA bug CCD-2844, once 'Variation' tab's stuck, refresh page will redirect to Dashboard page.
            driver.navigate().refresh();
            log.info("Refresh the page");
            driver.get(url);
            log.info("Retry this URL");
            clickWhenReady(By.linkText(prodCode + "-grey"));
            log.info("clicked color level product.");
        }

        waitHelper.waitForTextToBePresentInElementLocated(productHeader1, 120, prodCode + "-grey");
        waitHelper.waitForElementClickable(pricesTab, 120);
        pricesTab.click();
        log.info("clicked Prices tab");

        //Update first price item
        clickWhenReady(firstPriceItem);
        log.info("Update first price item as disable");
        clickWhenReady(priceToDate);
        WebElement firstPriceItemToItem = driver.findElement(priceToDate);
        firstPriceItemToItem.clear();
        firstPriceItemToItem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        firstPriceItemToItem.sendKeys("24/10/2019 19:29");
        firstPriceItemToItem.sendKeys(Keys.ENTER);
        clickWhenReady(popupSaveBtn);

        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 120, "Price was successfully updated");

        //Update second price item
        clickWhenReady(secondPriceItem);
        log.info("Update second price item amount to 33");

        WebElement price = getWhenVisible(priceAmtPopup);
        log.info("Got the popup window web element.");
        String[] oldPrice = price.getAttribute("value").split("\\.");
        log.info("old price is " + oldPrice[0]);
        price.clear();

        int newPrice = 33;
        price.sendKeys(Integer.toString(newPrice));
        log.info("New price is " + newPrice);
        clickWhenReady(popupSaveBtn);
        log.info("New price is saved.");
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 90, "Price was successfully updated");

        //Delete third price item
        clickWhenReady(thirdPriceItem);
        clickWhenReady(deleteBtn);
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();

            // alert handling
            log.info("Alert detected: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
        }
        waitHelper.waitForInvisibilityofElment(By.xpath("//tr[4]/td"), 120);
    }

    public void updateProductInventory(Boolean isVersion5, String prodCode, String size) {
        clickVariantTab(isVersion5);
        waitHelper.waitForTextToAppear(variantsTable, prodCode);
        log.info("clicked Variation Tab");

        clickWhenReady(By.linkText(prodCode + "_red_" + size));
        waitHelper.waitForElementVisible(productCode, 120);
        log.info("Clicked on product color red size " + size);
        waitHelper.waitForElementClickable(inventoryTab, 120);
        inventoryTab.click();
        waitHelper.waitForElementVisible(inventoriesTable, 120);
        log.info("Clicked on Inventory tab.");
        waitHelper.waitForElementClickable(firstInventoryItem, 120);
        firstInventoryItem.click();
        //clickWhenReady(firstInventoryItem);
        log.info("Clicked on Inventory quantity.");

        WebElement quantity = getWhenVisible(inventoryQtyPopup);
        String oldQty = quantity.getAttribute("value");
        log.info("Old quantity is " + oldQty);
        quantity.clear();

        int newQty = 23;
        log.info("New quantity is " + newQty);
        quantity.sendKeys(Integer.toString(newQty));
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollBy(0, %s)", 300));
        clickWhenReady(popupSaveBtn);
        log.info("Click to save quantity of red " + size);
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 120, "Inventory was successfully updated");
    }


    public void updateAttribute(String attributeValue) throws InterruptedException {
        if (attributeValue.equals("on")) {
            clickWhenReady(saleAttributeOff);
            log.info("turned Sale on.");
        } else {
            clickWhenReady(saleAttributeOn);
            log.info("turned Sale off.");
        }
        waitHelper.waitForElementClickable(updProdBtn, 90);
        updProdBtn.click();


        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 90, "Product was successfully updated");
        waitHelper.waitForAjax();
    }


    public void updatePriceDate(int offsetDays) {
        if (!getWhenVisible(firstPriceBook).getText().startsWith("default")) {
            clickWhenReady(firstPriceItem);
            log.info("clicked first price amount.");
        } else {
            clickWhenReady(secondPriceItem);
            log.info("clicked second price amount.");
        }

        WebElement priceTo = getWhenVisible(priceToDate);
        log.info("Got the popup window price to element.");

        //set new price 'To' date based on offset days provided
        Calendar calendarInstance = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        calendarInstance.add(Calendar.DATE, offsetDays);
        String toDate = formatter.format(calendarInstance.getTime());

        priceTo.click();
        priceTo.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        priceTo.sendKeys(toDate);
        log.info("special price ends on " + toDate);
        //This step is to active popup window so it's clickable.
        clickWhenReady(priceAmtPopup);
        clickWhenReady(popupSaveBtn);
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 90, "Product was successfully updated");
        //sometimes popup windown doesn't close after clicking 'Save'
        //driver.navigate().refresh();
    }


    public void changeProductBrand(Boolean isVersion5, String prodcode, String newBrand) {
        //PIM remained in Inventory screen
        clickVariantTab(isVersion5);
        log.info("Clicked on 'Variation' tab again to go to root level product.");

        if (!isVersion5) {
            clickWhenReady(rootLevelProdInTab);
            log.info("Clicked on root level product: " + prodcode);
        } else {
            clickWhenReady(By.linkText(prodcode));
        }

        waitHelper.waitForElementVisible(generalTab, 90);

        Select brand = new Select(getWhenVisible(brandField));
        brand.selectByVisibleText(newBrand);
        log.info("Change the brand to be " + newBrand + " to trigger product deletion in channel.");
        waitHelper.waitForElementClickable(updProdBtn, 90);
        updProdBtn.click();
        log.info("Save the product brand change.");

        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 90, "Product was successfully updated");
    }


    public void changeSimpleProductBrand(String prodcode, String newBrand) {
        Select brand = new Select(getWhenVisible(brandField));
        brand.selectByVisibleText(newBrand);
        log.info("Change the brand to be " + newBrand + " to trigger product deletion in channel.");

        waitHelper.waitForElementClickable(updProdBtn, 90);
        updProdBtn.click();
        log.info("Save the product brand change.");
        waitHelper.waitForTextToBePresentInElementLocated(alertSpan, 90, "Product was successfully updated");
    }

    /**
     * Delete/Remove Methods: Thease Below Method are for Deleting or Removing product and related Details....
     */

    //Delete product by product number
    public void deleteProductByID(Boolean isVersion5, String productID) {
        //PIM remained in Inventory screen
        clickManageProducts();
        simpleSearchProduct(productID);
        log.info("Find the product to be deleted.");

        if (isVersion5) {
            //*[@id="product_10494"]/td[8]/div/button/i
            clickWhenReady(By.xpath("//*[@id=\"product_" + productID + "\"]/td[8]/div/button/i"));
        } else {
            //*[@id="product_65086"]/td[7]/div/button/i
            clickWhenReady(By.xpath("//*[@id=\"product_" + productID + "\"]/td[7]/div/button/i"));
        }
        clickWhenReady(deleteBtn);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        log.info("Alert Text: " + alertText);
        alert.accept();
        log.info("Delete the Product " + productID);
        waitHelper.waitForInvisibilityofElment(progressBar, 90);
    }


    //Remove all the prices of child red
    public void removeProductPrice(Boolean isVersion5, String prodCode) {

        clickVariantTab(isVersion5);
        //loading tab takes longer than before after Lazyloading was implemented
        log.info("clicked Variation Tab");
        try {
            clickWhenReady(By.linkText(prodCode + "_red"));
            //in V3 Borderfree channel test, previous screen is Style level product
            //in V5 Catch channel test, previous screen is Size level product

            waitHelper.waitForInvisibilityOfElementWithText(productHeader1, 90, prodCode + "_red_");
            waitHelper.waitForTextToBePresentInElementLocated(productHeader1, 90, prodCode + "_red");
            log.info("clicked color level product.");
        } catch (TimeoutException toe) {
            log.error("'Associated Products' tab not loading...");
            String url = driver.getCurrentUrl();
            log.info("Page URL not loading: " + url);
            //JIRA bug CCD-2844, once 'Variation' tab's stuck, refresh page will redirect to Dashboard page.
            driver.navigate().refresh();
            log.info("Refresh the page");
            driver.get(url);
            log.info("Retry this URL");
            clickWhenReady(By.linkText(prodCode + "_red"));
            log.info("clicked color level product.");
        }
        waitHelper.waitForInvisibilityofElment(progressBar, 90);
        waitHelper.waitForElementClickable(pricesTab, 120);
        pricesTab.click();
        log.info("clicked Prices tab");

        //delete first price item
        clickWhenReady(firstPriceItemCog);
        log.info("Delete first price item");
        clickWhenReady(deleteBtn);
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();
            // alert handling
            log.info("Alert detected: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
        }
        //wait till second row is gone
        waitHelper.waitForInvisibilityofElment(secondPriceItemCog, 90);
        //Delete second price item
        clickWhenReady(firstPriceItemCog);
        log.info("Delete second price item");
        clickWhenReady(deleteBtn);
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();

            // alert handling
            log.info("Alert detected: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
        }
        //wait till the only one row is gone
        waitHelper.waitForInvisibilityofElment(firstPriceItemCog, 90);
    }

    public void removeProductImage(Boolean isVersion5, String prodCode) {

        clickVariantTab(isVersion5);
        //loading tab takes longer than before after Lazyloading was implemented
        log.info("clicked Variation Tab");
        try {
            clickWhenReady(By.linkText(prodCode + "_red"));
            log.info("clicked color level product.");
        } catch (TimeoutException toe) {
            log.error("'Associated Products' tab not loading...");
            String url = driver.getCurrentUrl();
            log.info("Page URL not loading: " + url);
            //JIRA bug CCD-2844, once 'Variation' tab's stuck, refresh page will redirect to Dashboard page.
            driver.navigate().refresh();
            log.info("Refresh the page");
            driver.get(url);
            log.info("Retry this URL");
            clickWhenReady(By.linkText(prodCode + "_red"));
            log.info("clicked color level product.");
        }
        waitHelper.waitForTextToBePresentInElementLocated(productHeader1, 120, prodCode + "_red");
        clickWhenReady(mediaTab);
        log.info("clicked Media tab");

        //delete image item
        clickWhenReady(imageItemCog);
        log.info("Delete image item");
        clickWhenReady(deleteBtn);
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();
            // alert handling
            log.info("Alert detected: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[2]")));
    }


    public void gotoScheduledJobsScreen() {
        clickWhenReady(scheduledJobsMenu);
        log.info("Open up Scheduled Jobs screen");
    }


    public String[] getPriceItemValues() {
        String[] priceItemValues = new String[3];

        priceItemValues[0] = getWhenVisible(firstPriceBook).getText();
        priceItemValues[1] = getWhenVisible(firstPriceItemFrom).getText();
        priceItemValues[2] = getWhenVisible(firstPriceItemTo).getText();

        return priceItemValues;
    }


    public int searchForPriceBook(String pricebookName) {
        int rowIndex = 1;

        List<WebElement> allPriceItemRows = getAllWhenVisible(priceItemRows);
        log.info("It has " + allPriceItemRows.size() + " price items");
        for (; rowIndex <= allPriceItemRows.size(); rowIndex++) {
            WebElement row = allPriceItemRows.get(rowIndex - 1);
            String priceBookInPIM = row.findElement(By.xpath("//tr[" + rowIndex + "]/td[2]/a")).getText();
            log.info("Price book " + priceBookInPIM);
            if (priceBookInPIM.equals(pricebookName)) {
                log.info(pricebookName + " price item index is " + rowIndex);
                break;
            }
        }

        if (!(rowIndex <= allPriceItemRows.size())) {
            rowIndex = 0;
        }

        return rowIndex;
    }


    public String checkScheduledJobStatus() throws InterruptedException {
        String createdAt;
        String result1;
        String result2;
        boolean isSameTime;
        int refreshTimes = 0;
        do {
            Thread.sleep(15000);
            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(scheduledJobsFilterBtn));
            createdAt = getWhenVisible(scheduledJobCreatedAt).getText();
            isSameTime = createdAt.equals(triggeredTime[0]) || createdAt.equals(triggeredTime[1]);
            result1 = getWhenVisible(firstJobStatus).getText();

            //This repeated part is because sometimes Progress bar goes to 100% and complete but restart from 0% again.
            Thread.sleep(5000);
            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(scheduledJobsFilterBtn));
            result2 = getWhenVisible(firstJobStatus).getText();
            refreshTimes++;
            log.info("Scheduled Job created at " + createdAt + " is " + result2);
        } while (!result1.equals("Completed") && !result2.equals("Completed") && refreshTimes < PRICERULEJOBREFRESH && isSameTime);

        return result2;
    }


    public void clickProductConfigMenu() {
        clickWhenReady(productConfigMenu);
    }

    public void gotoPriceRulesScreen() {
        clickWhenReady(priceRulesMenu);
        log.info("Open up Price Rules screen");
    }


    public void triggerPriceRule(String ruleID, String action) {
        clickWhenReady(By.xpath("//tr[@id='price_rule_" + ruleID + "']/td[4]/div/button"));
        clickWhenReady(By.linkText(action));
        log.info("Click Price Rule's blue cog to " + action);
        clickWhenReady(skipProdRulesCheckbox);
        log.info("Click to skip Product Rules.");
        clickWhenReady(startButton);
        log.info("Click to start price rule.");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(alertSpan, "is running in background. It may take a while"));

        //get current timestamp to varify export job
        Calendar calendarInstance = Calendar.getInstance();
        ccDateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
        triggeredTime[0] = ccDateFormat.format(calendarInstance.getTime());
        calendarInstance.add(Calendar.MINUTE, 1);
        triggeredTime[1] = ccDateFormat.format(calendarInstance.getTime());
        log.info("Price Rule job is triggered between " + triggeredTime[0] + " and " + triggeredTime[1]);
    }


    public String[] getSKUProductName() {
        String[] skuNames = new String[2];
        clickWhenReady(plusSign);

        skuNames[0] = getWhenVisible(firstColorSKUName).getText();
        skuNames[1] = getWhenVisible(secondColorSKUName).getText();

        return skuNames;
    }


    public boolean[] checkProductConfigItems() {
        boolean[] itemIsDisplayed = new boolean[14];

        itemIsDisplayed[0] = getWhenVisible(configAttributes).isDisplayed();
        itemIsDisplayed[1] = getWhenVisible(configAttributeSets).isDisplayed();
        itemIsDisplayed[2] = getWhenVisible(configCategories).isDisplayed();
        itemIsDisplayed[3] = getWhenVisible(configCategorySets).isDisplayed();
        itemIsDisplayed[4] = getWhenVisible(configBrands).isDisplayed();
        itemIsDisplayed[5] = getWhenVisible(configPriceBooks).isDisplayed();
        itemIsDisplayed[6] = getWhenVisible(configCatalogs).isDisplayed();
        itemIsDisplayed[7] = getWhenVisible(configInventorySrcs).isDisplayed();
        itemIsDisplayed[8] = getWhenVisible(configStoreLocations).isDisplayed();
        itemIsDisplayed[9] = getWhenVisible(configShippingZones).isDisplayed();
        itemIsDisplayed[10] = getWhenVisible(configCarriers).isDisplayed();
        itemIsDisplayed[11] = getWhenVisible(configDataSets).isDisplayed();
        itemIsDisplayed[12] = getWhenVisible(configLookup).isDisplayed();
        itemIsDisplayed[13] = getWhenVisible(configPunchout).isDisplayed();

        return itemIsDisplayed;
    }


    public String[] checkImportedProducts(boolean isVersion5, String[] productURLs) {

        String[] result = new String[2];

        driver.get(productURLs[0]);
        waitHelper.waitForElementClickable(customAttributesTab, 90);
        customAttributesTab.click();

        if (isVersion5) {
            result[0] = getWhenVisible(htmlDescField).getText();
        } else {
            result[0] = getWhenVisible(customDescField).getText();
        }
        log.info("Configurable product's description in CC is: " + result[0]);

        //check whether simple product's updated price has been imported
        driver.get(productURLs[1]);
        wait.until(ExpectedConditions.elementToBeClickable(updProdBtn));

        int rowNumber = searchForPriceBook("default (AUD)");

        if (rowNumber == 1) {
            result[1] = getWhenVisible(firstPriceItem).getText();
        } else {
            result[1] = getWhenVisible(By.xpath("//tr[" + rowNumber + "]/td/a")).getText();
        }

        log.info("Simple product's price in CC is: " + result[1]);

        return result;
    }


    public void navigateToManageJobUrl() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getManageJob());
    }

    public String[] waitTillImportJobCompletes(String triggeredTime) throws InterruptedException, ParseException {
        navigateToManageJobUrl();

        //Refresh to get the latest import job status
        int refreshImportCount = 0;
        boolean timeIsCorrect;
        boolean jobNotFinished;
        String[] importResult = new String[2];
        do {
            Thread.sleep(SEARCHRESULTWAIT);
            driver.navigate().refresh();
            refreshImportCount++;
            log.info("Refresh number " + refreshImportCount);
            importResult[0] = getWhenVisible(importJobSubmittedAt).getText();
            importResult[1] = getWhenVisible(importJobResult).getText();
            timeIsCorrect = !ccDateFormat.parse(importResult[0]).before(ccDateFormat.parse(triggeredTime));
            jobNotFinished = importResult[1].contains("ing");
            if (refreshImportCount >= IMPORTJOBREFRESHTRIES) break;
        } while (!(timeIsCorrect && (!jobNotFinished)));

        return importResult;
    }

    public String getTenantEmail() {
        return getWhenVisible(emailName).getText();
    }


    public void clickAdvancedSearch() {
        clickWhenReady(advancedSearchLink);
    }


}

