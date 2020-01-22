package CucumberTest.stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberBase.helpers.dataReader.CSVReader;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.*;
import cucumberBase.picoHelper.MySharedData;
import cucumberBase.picoHelper.TestContext;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;

import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;


public class ProductManagerStepDef {
    static String searchKeyword = "";
    static String[] updateResult1 = new String[2];
    static String[] updateResult2 = new String[2];
    static String mainWindowHandle = "";
    final String Magento1ProdURLPrefix = "http://magento1.aws.fusionfactory.com/index.php/admin/catalog_product/edit/id/";
    // Global variables
    String CSVFILEPATH = "";
    Boolean isVersion5 = false;
    // Object of various other classes and pageObjects
    private TestContext testContext;
    private Logger log = LoggerHelper.getLogger(ProductManagerStepDef.class);
    private LoginPage lp;
    private ProductManagerPage objPM;
    private CommonMethods objCommonMethod;
    private OrderManagerPage objOM;
    private Magento1AdminPage objM1;
    private Magento2AdminPage objM2;
    private EbayBuyingPage objEB;
    private BigCommerceAdminPage objBigComA;
    private NetSuiteAdminPage objNetSuite;
    private DWBusinessManagerPage objDWBusM;
    private String[] prodCodeName = new String[2];
    private String[] productIDs;
    private String[] productIDss;

    public ProductManagerStepDef(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLP();
        objPM = testContext.getPageObjectManager().getProductManagerPage();
        objM1 = testContext.getPageObjectManager().getMagento1AdminPage();
        objNetSuite = testContext.getPageObjectManager().getNetSuiteAdminPage();
        objCommonMethod = testContext.getPageObjectManager().getCommonMethods();
        productIDss = MySharedData.getInstance().PRODUCTIDs;


    }

    @Given("^product \"(\\w+)\"$")
    public void gotoProduct(String productCode) {
        objPM.clickProductsMenu();
        objPM.advancedSearchProduct(productCode, false);
        objPM.expandProduct();
        clickWhenReady(By.linkText(productCode));
        log.info("Testing product: " + productCode);

    }

    @Given("^on its Custom Attributes tab$")
    public void gotoCustomAttributesTab() {

        objPM.clickCustomAttributesTab();
    }

    @When("^its Sale is (\\w+)$")
    public void changeAttribute(String attributeValue) throws InterruptedException {
        objPM.updateAttribute(attributeValue);
        log.info("updated its boolean Sale attribute");
    }

    @Given("user is in Product Manager")
    public void gotoProductManagerStep() {
        lp.navigateToProductManager();
        objPM.clickProductsMenu();
    }

    @Given("user is in Price Rules screen")
    public void gotoPriceRulesScreenStep() {
        objPM.gotoPriceRulesScreen();
    }

    // Calling Method to click at Product Menu section of PM
    @When("User click at Product manager")
    public void user_click_at_Product_manager() {
        objPM.clickProductsMenu();
    }

    // Calling Method to click at Manager Product section of PM
    @When("Click at the Manage product link")
    public void click_at_the_Manage_product_link() {
        objPM.clickManageProducts();
    }

    @Given("^user is in Product Manager page$")
    public void gotoProductManager() {

        log.info("User is on Product Manager page.");
    }

    @When("^expand Product Configurations menu$")
    public void expandProductConfigurations() {
        objPM.clickProductConfigMenu();
    }

    @When("^product CSV file is uploaded$")
    public void uploadProductCSV() throws InterruptedException {
        //User is in PM now
        objPM.clickProductsMenu();
        String uploadResult = objPM.uploadProdCSV(CSVFILEPATH);
        log.info(" CSV upload result is: " + uploadResult);
        Assert.assertTrue(uploadResult.equals("Success"));
        log.info("CSV has been uploaded properly.... ");
    }

    @Given("^product CSV for Model (.*) is prepared$")
    public void generateProductCSVByModel(String csvFileName) throws IOException {
        log.info("Generating CSV..... ");
        CSVFILEPATH = objCommonMethod.generateProductCSV(csvFileName);
        CSVReader csv = new CSVReader();

        searchKeyword = csv.readString(CSVFILEPATH);
        log.info(csvFileName + " input file is opened. Keyword is " + searchKeyword);
    }

    @Given("^product CSV for (.*) channel is prepared$")
    public void generateProductCSV(String csvFileName) throws IOException {
        CSVFILEPATH = objCommonMethod.generateProductCSV(csvFileName);
        CSVReader csv = new CSVReader();
        searchKeyword = csv.readString(CSVFILEPATH);
        log.info(csvFileName + " input file is opened. Keyword is " + searchKeyword);
    }


    @Then("^user should be able to search this product in \"(.*)\" mode$")
    public void advancedSearchProduct(String version) {
        log.info("User is trying to search product that has been uploaded.... ");
        if (version.equals("V5")) {
            isVersion5 = true;
            log.info("Version is  " + version);
        }
        objPM.advancedSearchProduct(searchKeyword, isVersion5);
        log.info("Advance search passed....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        prodCodeName = objPM.getProductCodeAndName(isVersion5);
        log.info("Code of newly uploaded product is: " + prodCodeName[0] + ". Its name is " + prodCodeName[1]);

        //use product code/name to filter Channel's export items by default
        //  queryIDs = prodCodeName;
        // Creating shared data between ProductManager and ChannelManager
        log.info("Setting values for shared data...");
        MySharedData.getInstance().QUERYIDs = prodCodeName;
        MySharedData.getInstance().PRODUCTCODENAME = prodCodeName;
        log.info("Set values for shared data...");
    }

    @Then("^get Product IDs$")
    public void getProductIDs() {

        String rootProductID = objPM.getProductID(searchKeyword);
        log.info("coming back to step def....");
        log.info("Value in step def is : " + rootProductID);
        productIDs = new String[9];
        int prodIDInt = Integer.parseInt(rootProductID);
        for (int i = 0; i < 9; i++) {
            productIDs[i] = Integer.toString(prodIDInt + i);

        }
        // Creating shared data.
        log.info("Creating shared data...");
        MySharedData.getInstance().PRODUCTIDs = productIDs;


    }


    @Given("^V5 product \"(\\w+)\"$")
    public void gotoProductV5(String productCode) throws InterruptedException {
        objPM.clickProductsMenu();
        objPM.advancedSearchProduct(productCode, true);
        clickWhenReady(By.linkText(productCode));
        log.info("Testing product: " + productCode);
    }

    @Given("^its Prices tab$")
    public void gotoPricesTabV5() throws InterruptedException {
        objPM.gotoPricesTab();
    }

    @Given("product template brand is set as (.*)")
    public void set_product_template_brand(String brandName) {
        // Write code here that turns the phrase above into concrete actions
        log.info("Updating brand details to TestBrand.... ");
        objCommonMethod.setBrand(CSVFILEPATH, "TestBrand", brandName);
    }


    @Given("^(.*) product is updated (.*) description$")
    public void updateProductInPIM(String version, String withOrWithout) throws InterruptedException {
        if (version.equals("V5")) {
            isVersion5 = true;
        }

        //switch back to PIM tab

        lp.executeScript0();
        //log.info("value of productcode0 is : " + prodCodeName[0]);
        log.info("value of searchKeyword is : " + searchKeyword);
        //if product IDs are retrieved, the product page is already opened.
        //so this step should be skipped
        if (!ArrayUtils.isNotEmpty(productIDss)) {
            objPM.gotoProduct(searchKeyword);
        }

        if (withOrWithout.equals("including")) {
            objPM.updateProductDescription(isVersion5);
        }
        log.info("value of searchKeyword is : " + searchKeyword);
        Thread.sleep(2000);
        objPM.updateProductPrice(isVersion5, searchKeyword);
        objPM.updateProductInventory(isVersion5, searchKeyword, "small");
        Thread.sleep(2000);
        objPM.updateProductInventory(isVersion5, searchKeyword, "medium");

    }

    /**
     * Update Product: These all are step defs for Updating products.
     */

    @Given("^(.*) product brand is changed to (.*)$")
    public void updateProductBrand(String version, String newBrand) throws InterruptedException {
        //switch back to PIM tab

        //        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0));
        // lp.windowHandle();
        lp.executeScript0();

        if (version.equals("style")) {
            isVersion5 = true;
            //This is for changing style level product brand which works for V3 and V5-contextual
            //objPM.changeProductBrand(isVersion5, prodCodeName[0], newBrand);
            objPM.changeProductBrand(isVersion5, searchKeyword, newBrand);
        } else if (version.equals("colour")) {
            //This is for Iconic V5 non-contextual, so it can not control filter by using Style level attribute
            isVersion5 = true;

            objPM.changeProductBrand(isVersion5, searchKeyword + "-grey", newBrand);
            objPM.changeProductBrand(isVersion5, searchKeyword + "_red", newBrand);
        } else if (version.equals("each")) {
            //This is changing brands for V5 products across 3 classes. This is for V5 SFCC channel test.
            objCommonMethod.setBrand(CSVFILEPATH, "Con", newBrand);
            String uploadResult = objPM.uploadProdCSV(CSVFILEPATH);
            log.info("Upload CSV to change all products' brand. Result is: " + uploadResult);
        } else if (version.equals("V5googlefeed")) {
            isVersion5 = true;
            //objPM.changeProductBrand(isVersion5, searchKeyword+"-grey-l", newBrand);
            objPM.changeProductBrand(isVersion5, searchKeyword + "-grey-m", newBrand);
            objPM.changeProductBrand(isVersion5, searchKeyword + "-grey-s", newBrand);
            //objPM.changeProductBrand(isVersion5, searchKeyword+"_red_large", newBrand);
            //objPM.changeProductBrand(isVersion5, searchKeyword+"_red_medium", newBrand);
            //objPM.changeProductBrand(isVersion5, searchKeyword+"_red_small", newBrand);
        } else if (version.equals("SimpleProduct")) {
            objPM.changeSimpleProductBrand(prodCodeName[0], newBrand);
        }

        log.info("Product brand change is saved.");
    }


    @Given("^(.*) product is updated (.*) level desc$")
    public void updateProductDescriptionAccordingLevel(String version, String level) throws InterruptedException {

        //switch back to PIM tab
        //   ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // driver.switchTo().window(tabs.get(0));
        lp.executeScript0();
        if (version.equals("V5")) {
            isVersion5 = true;
        }
        if (level.equals("Style")) {
            objPM.updateProductDescription(isVersion5);
        } else if (level.equals("Sku")) {
            //move to sku level
            objPM.clickVariantTab(isVersion5);
            objPM.gotoProduct(searchKeyword + "-grey-m");
            objPM.updateProductDescription(isVersion5);
        }

    }


    @Given("^(.*) product Prices are updated")
    public void v_product_content_is_updated(String version) throws InterruptedException {
        if (version.contains("V5")) {
            isVersion5 = true;
        }
        //switch back to PIM tab
        //  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // driver.switchTo().window(tabs.get(0));
        lp.executeScript0();

        objPM.updateProductPrices(isVersion5, searchKeyword);
    }


    @Given("^(.*) product Inventory is updated")
    public void v_product_inventory_is_updated(String version) throws InterruptedException {
        if (version.contains("V5")) {
            isVersion5 = true;
        }
        //switch back to PIM tab
        // ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // driver.switchTo().window(tabs.get(0));
        lp.executeScript0();
        objPM.updateProductInventory(isVersion5, searchKeyword, "small");
    }

    /**
     * These methods iwll be used to delete products
     */
    //Delete by product number
    @Given("^(.*) product with index of (\\d+) is deleted from PIM")
    public void v_product_is_delete_from_PIM(String version, int index) throws InterruptedException {
        //  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //  driver.switchTo().window(tabs.get(0));
        lp.executeScript0();

        //objPM.deleteProductByCode(isVersion5, searchKeyword+"-grey-m");
        if (version.equals("V5")) {
            isVersion5 = true;
        } else if (version.equals("V3")) {
            isVersion5 = false;
        }
        objPM.deleteProductByID(isVersion5, productIDss[index]);
        log.info(String.format("Product %s was deleted.", productIDss[index]));
        //Back to product detail page for next case use
        objPM.advancedSearchProduct(searchKeyword, isVersion5);
        objPM.gotoProduct(searchKeyword);
    }

    @Given("^(.*) product Price is removed")
    public void v_product_Price_is_removed(String version) throws InterruptedException {
        if (version.contains("V5")) {
            isVersion5 = true;
        }
        //switch back to PIM tab
        lp.executeScript0();

        objPM.removeProductPrice(isVersion5, searchKeyword);
    }

    @Given("^(.*) product image is removed")
    public void v_product_image_is_removed(String version) throws InterruptedException {
        if (version.contains("V5")) {
            isVersion5 = true;
        }
        //switch back to PIM tab
        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // driver.switchTo().window(tabs.get(0));
        lp.executeScript0();
        log.info("user is trying to remove the image....");
        objPM.removeProductImage(isVersion5, searchKeyword);
    }


    @Then("category \"Sale > Spring\" assigned is (\\w+)")
    public void checkCategory(String expectedResult) throws InterruptedException {
        objPM.gotoCategoriesTab();
        String actualResult;

        lp.scrollByHeight();
        Thread.sleep(4000);

        if (expectedResult.equals("true")) {
            actualResult = getWhenVisible(By.id("5")).getAttribute("aria-selected");
        } else {
            clickWhenReady(By.xpath("//li[@id='4']/i"));
            actualResult = getWhenVisible(By.id("5")).getAttribute("aria-selected");
        }
        Assert.assertEquals("product rule result is incorrect.", expectedResult, actualResult);
    }


    @When("^its special price ends in (-?\\d+) days$")
    public void changeSpecialPriceToDate(int offsetDays) {
        objPM.updatePriceDate(offsetDays);
        log.info("updated its special price 'To' date.");
    }


    @Then("^V5 Sale category with ID (\\d+) assigned is (\\w+)")
    public void checkCategoryV5(int catID, String expectedResult) throws InterruptedException {
        objPM.gotoCategoriesTab();
        lp.pageRefresh();
        Thread.sleep(6000);
        String actualResult;

        //default: Sale category ID is 6
        try {
            actualResult = getWhenVisible(By.id(Integer.toString(catID))).getAttribute("aria-selected");
        } catch (Exception e) {
            //Sometiems category collapse, category invisible
            log.info("Exception for: " + e.getMessage());
            actualResult = "false";
        }

        Assert.assertEquals("product rule result is incorrect.", expectedResult, actualResult);
    }


    @When("click Price Rule (.*)'s cog sign to '(.*)'")
    public void triggerPriceRule(String ruleID, String action) throws InterruptedException {
        objPM.triggerPriceRule(ruleID, action);
    }

    @When("wait till Scheduled Jobs is Completed")
    public void waitScheduledJobsToComplete() throws InterruptedException {
        objPM.gotoScheduledJobsScreen();
        objPM.checkScheduledJobStatus();
    }

    @Then("product (\\d+)'s '(.*)' price should be generated, From date is '(.*)' and To date is '(.*)'")
    public void verifyPriceRuleResult(int productID, String priceBook, String fromDate, String toDate) {

        lp.loadUrl("https://sandbox2-product.commerceconnect.co/products/" + (productID) + "/edit");
        log.info("Open up product " + productID + "'s edit page.");
        objPM.gotoPricesTab();

        String[] expectedValues = {priceBook, fromDate, toDate};
        String[] priceItemValues = objPM.getPriceItemValues();

        Assert.assertArrayEquals("Price rule failed.", expectedValues, priceItemValues);
    }

    @Then("product (\\d+)'s '(.*)' price shouldn't exist")
    public void verifyPriceRuleResultNegative(int productID, String pricebookName) {
        lp.loadUrl("https://sandbox2-product.commerceconnect.co/products/" + (productID) + "/edit");
        log.info("Open up product " + (productID) + "'s edit page.");
        objPM.gotoPricesTab();

        int rowIndex = objPM.searchForPriceBook(pricebookName);

        Assert.assertEquals(pricebookName + " price item shouldn't be displayed here.", 0, rowIndex);

    }


    @Then("^all sub menus should be listed and viewable to user$")
    public void checkSubMenuList() {
        lp.scrollByScreenHeight3x();
        log.info("Scroll down 540 pixels.");
        boolean[] expectedResult = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        boolean[] actualResult = objPM.checkProductConfigItems();
        Assert.assertArrayEquals("Product Configurations items are incomplete.", expectedResult, actualResult);
    }


    @When("^(.*) product (.*) and (.*) are updated$")
    public void updateProducts(String target, String productID1, String productID2) throws InterruptedException {
        if (target.equals("Magento1")) {
            objM1.gotoProductPage(Magento1ProdURLPrefix + productID1);
            log.info("Go to Configurable product page.");
            updateResult1 = objM1.updateProductDescription();

            objM1.gotoProductPage(Magento1ProdURLPrefix + productID2);
            updateResult2 = objM1.updateProductPrice();

        } else if (target.equals("NetSuite")) {
            objNetSuite.gotoProductPage(productID1);
            log.info("Go to NetSuite product " + productID1);
            updateResult1 = objNetSuite.updateProductDescription();

            objNetSuite.gotoProductPage(productID2);
            log.info("Go to NetSuite product " + productID2);
            updateResult2 = objNetSuite.updateProductPrice();
        }

        MySharedData.getInstance().UPDATERESULT1 = updateResult1;
        MySharedData.getInstance().UPDATERESULT2 = updateResult2;

        //switch back to channel manager

        lp.windowHandle();

        lp.closeWindow();

        lp.executeScript_2();
    }


}
