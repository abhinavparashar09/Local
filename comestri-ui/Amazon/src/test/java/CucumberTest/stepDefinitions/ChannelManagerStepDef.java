package CucumberTest.stepDefinitions;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.*;
import cucumberBase.picoHelper.MySharedData;
import cucumberBase.picoHelper.TestContext;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import io.cucumber.datatable.DataTable;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static cucumberBase.pageFactory.CommonMethods.ccDateFormat;

public class ChannelManagerStepDef {
    static SoftAssertions softAssertions;
    static String triggeredTimeString = "";
    static Date jobTriggeredTimeDate = new Date();
    static String[] updateResult1 = new String[2];
    static String[] updateResult2 = new String[2];
    static String[] importJobDetails = new String[3];
    static String orderSourceID = ""; //need to pass this order ID between Magento2 and Magento1
    static Boolean isVersion5 = false;
    static SimpleDateFormat createdAtFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
    //Constant time
    final int DWNEWSTAGETIME = 120;        //stage time(seconds) for new products
    final int EXPORTJOBTIMEOUT = 2400;    //set the export job time out to be 40min
    //URls:
    final String CCProdURLPrefix = "https://sandbox2-product.commerceconnect.co/products/";
    final String EBAYLISTING = "http://www.ebay.com.au/itm/Test-Listing-Business-Shirt-/112524331663?ssPageName=STRK:MESE:IT";
    final String HEADERAUTH1 = "Token token=kGbDe11xvggpwJAaxps-,email=comestri.qav5cm@fusionfactory.com";
    final String HEADERCONT = "application/json";
    String[] exportjobDetails = new String[5];
    String[][] exportInfo;
    String[] expectedResult = new String[]{"true", "Completed"};
    private Logger log = LoggerHelper.getLogger(ChannelManagerStepDef.class);
    private TestContext testContext;
    private LoginPage lp;
    private ProductManagerPage objPM;
    private CommonMethods objCommonMethod;
    private HeartBeatPage objHB;
    private ChannelManagerPage objCM;
    private OrderManagerPage objOM;
    private Magento1AdminPage objM1;
    private Magento2AdminPage objM2;
    private EbayBuyingPage objEB;
    private BigCommerceAdminPage objBigComA;
    private NetSuiteAdminPage objNetSuite;
    private DWBusinessManagerPage objDWBusM;
    private String[] productIDs;
    private String[] queryIDs;
    //String ORDERAPI = ;
    private String[] prodCodeName = new String[2];
    private Date productHeartbeatTriggeredTime = new Date();


    public ChannelManagerStepDef(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLP();
        objPM = testContext.getPageObjectManager().getProductManagerPage();
        objCM = testContext.getPageObjectManager().getChannelManagerPage();
        objCommonMethod = testContext.getPageObjectManager().getCommonMethods();
        objHB = testContext.getPageObjectManager().getHeartBeatPage();
        objNetSuite = testContext.pageObjectManager.getNetSuiteAdminPage();
        objBigComA = testContext.pageObjectManager.getBigComAdminPage();
        objOM = testContext.pageObjectManager.getOrderManager();
        softAssertions = new SoftAssertions();
        queryIDs = MySharedData.getInstance().QUERYIDs;

        productIDs = MySharedData.getInstance().PRODUCTIDs;
        prodCodeName = MySharedData.getInstance().PRODUCTCODENAME;
    }

    @Given("^CommerceConnect (.*) channel '(.*)'$")
    public void gotoChannel(String channelType, String channelName) throws InterruptedException, ParseException {
        lp.executeScript1();
        objHB.navigateToHeartBeatPage();
        //import channel doesn't need product heartbeat
        if (!channelType.equals("NetSuite")) {
            productHeartbeatTriggeredTime = ccDateFormat.parse(objHB.triggerHeartbeat(DWNEWSTAGETIME));
        } else {
            objHB.triggerHeartbeat(3);    //wait 3 seconds
            log.info("Heartbeat job has been triggered..... ");
        }
        //create Channel Manager tab
        lp.executeScript2();
        lp.navigateToComestri();
        objCM.gotoManageChannels();
        //   Thread.sleep(2000);

        if (StringUtils.isEmpty(channelType)) {
            objCM.selectTestChannel(channelName);
        } else {
            objCM.selectTestChannel(channelType, channelName);
        }


    }

    @Given("^switch to (.*) channel '(.*)'$")
    public void gotoChannelByType(String channelType, String channelName) throws InterruptedException {
        objCM.gotoManageChannels();
        objCM.selectTestChannel(channelType, channelName);
    }


    //This function is used by Bigcommerce, The Iconic, Borderfree, GoogleFeed, Simple Export and Linkshare channels
    @Given("^In Export Items tab, set filter values using these product indexes$")
    public void getQueryProductIDsByDataTable(DataTable dt) {
        List<Integer> productIndexList = dt.asList(Integer.class);
        ArrayList<String> productIDList = new ArrayList<String>();
        for (int i = 0; i < productIndexList.size(); i++) {
            productIDList.add(productIDs[productIndexList.get(i)]);
        }
        queryIDs = productIDList.toArray(new String[0]);
    }


    @Given("^In Export Items tab, filter by (\\w+) with prefix '(.*)'$")
    public void getQueryProductIDsWithWildcard(String type, String prefix) {
        if (type.startsWith("ID")) {
            //Iconic V3, Facebook, Google, Fredhopper using 'ID'
            queryIDs = new String[]{prefix + productIDs[0]};
            log.info("Query ID is set as " + queryIDs[0]);
        } else if (type.startsWith("orderID")) {
            //Magento2, NetSuite order export using 'order ID'
            queryIDs = new String[]{orderSourceID};
        } else {
            //Magento2, Catch, TheMarket using product code
            log.info("value of queryID0 is ..." + queryIDs[0]);
            queryIDs = new String[]{prefix + prodCodeName[0]};
        }
    }


    @When("^trigger (.*)Export job (.*)$")
    public void triggerExportJob(String jobType, String jobID) throws InterruptedException, ParseException {

        //This is for BigCommerceV3 channel. When trigger Product Create job, it will chain a number of other jobs
        int numberOfChainedJobs = 1;
        if (jobType.contains("chained")) {
            numberOfChainedJobs = Integer.parseInt(jobType.substring(jobType.length() - 2, jobType.length() - 1));
        }

        //If export job failed with error "410 Gone", retry 2 times.
        RETRY:
        for (int i = 0; i < 3; i++) {
            objCM.gotoConfigurationTab();
            //Scroll down to reveal the Export Scheduler
            lp.scroll1080();

            objCM.gotoExportScheduler();

            //Trigger product feed first, wait till it finish. Then trigger other job types.
            log.info("Trigger the job by ID " + jobID);
            triggeredTimeString = objCM.triggerExport(jobID);
            try {
                jobTriggeredTimeDate = ccDateFormat.parse(triggeredTimeString);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
            //deactivation in TheIconic V3 channel takes 12 minutes sometime
            exportjobDetails = objCM.waitTillExportComplets(triggeredTimeString, numberOfChainedJobs, EXPORTJOBTIMEOUT);
            if (exportjobDetails[4].equals("Completed")) {
                break;
            } else if (exportjobDetails[4].equals("Failed")) {
                if (objCM.checkErrorMessage().startsWith("410 Gone")) {
                    objCM.restageFailedItems();
                    continue RETRY;
                }
                break;
            }
        }
        //next step is always checking export result in Export Items tab
        objCM.gotoExportItemsTab();
    }


    //This is for non-Simple Export type of channel, which has Export status in the 'Export items' tab
    @Then("^Filter value(.*) in (.*) and Type as '(.*)', (\\d+) new items should be (.*)$")
    public void varifyExportResult(String times, String filter2, String filter1, int numberOfItems, String result) throws InterruptedException, ParseException {
        boolean jobStartTimeIsCorrect = !ccDateFormat.parse(exportjobDetails[1]).before(ccDateFormat.parse(triggeredTimeString));
        String[] actualResult = new String[]{String.valueOf(jobStartTimeIsCorrect), exportjobDetails[4]};

        if (times.equals("s")) {
            //This is the case when needing to use multiple values to filter multiple times to get all test products
            exportInfo = objCM.collectExportResult(false, filter2, filter1, queryIDs, numberOfItems);
        } else {
            //This is the case when using one value in filter to get all test products
            exportInfo = objCM.collectExportResult(true, filter2, filter1, queryIDs, numberOfItems);
        }

        boolean[] channelItemsActual;
        channelItemsActual = objCM.validateExport(false, exportInfo, jobTriggeredTimeDate, numberOfItems, result);

        boolean[] channelItemsExpected = new boolean[numberOfItems];
        Arrays.fill(channelItemsExpected, true);
        Assert.assertArrayEquals(exportjobDetails[0] + " export job failed.", expectedResult, actualResult);
        Assert.assertArrayEquals("Some " + exportjobDetails[0] + " items are not exported.", channelItemsExpected, channelItemsActual);
    }


    //This is for Simple Export type of channel, such as Facebook, Borderfree, Google Feed, Linkshare etc.
    @Then("^Filter values in (.*) and Item Type as '(.*)', (\\d+) new items should be (.*)$")
    public void varifySimpleExportResult(String filter2, String filter1, int numberOfItems, String result) throws InterruptedException, ParseException {
        boolean jobStartTimeIsCorrect = !ccDateFormat.parse(exportjobDetails[1]).before(ccDateFormat.parse(triggeredTimeString));
        String[] actualResult = new String[]{String.valueOf(jobStartTimeIsCorrect), exportjobDetails[4]};

        exportInfo = objCM.collectSimpleExportItems(filter2, filter1, queryIDs, numberOfItems);

        boolean[] channelItemsActual;
        channelItemsActual = objCM.validateExport(true, exportInfo, jobTriggeredTimeDate, numberOfItems, result);

        boolean[] channelItemsExpected = new boolean[numberOfItems];
        Arrays.fill(channelItemsExpected, true);
        Assert.assertArrayEquals(exportjobDetails[0] + " export job failed.", expectedResult, actualResult);
        Assert.assertArrayEquals("Some " + exportjobDetails[0] + " items are not exported.", channelItemsExpected, channelItemsActual);
    }

    //For Borderfree/catch export items check
    //Borderfree channel doesn't update export status after export, so has to check 'Updated At' instead of export status
    @Then("^Filter by (.*) and Type as '(.*)', (\\d+) new items should be (.*)$")
    public void type_as_new_items_should_be_AsExpected(String filter2, String filter1, Integer numberOfItems, String result) throws InterruptedException, ParseException {

        String[][] exportItems;
        Thread.sleep(3000);
        if (filter2.equals("External code")) {
            exportItems = objCM.collectExportResult(true, filter2, filter1, queryIDs, numberOfItems);
        } else {
            //Borderfree use 'Code' to filter
            exportItems = objCM.collectSimpleExportItems(filter2, filter1, queryIDs, numberOfItems);
        }
        for (int i = 0; i < numberOfItems; i++) {
            Assert.assertEquals("Item " + exportItems[i][1] + " is not as expected status", result, exportItems[i][3]);
            Date updatedTime = ccDateFormat.parse(exportItems[i][2]);
            long time = 3 * 60 * 1000;                //3 minutes
            Date begin = new Date(productHeartbeatTriggeredTime.getTime() - time);

            log.info("heartbeat trigger time is : " + productHeartbeatTriggeredTime);
            log.info("product updated time is : " + updatedTime);
            Assert.assertTrue("Item " + exportItems[i][1] + " updated time is not correct", (!updatedTime.before(begin)));
        }
    }


    @Then("Custom attribute mapping fields should display")
    public void custom_attribute_mapping_fields_should_display() {
        String expectedCustomFields = "\"customAttributes\": [\r\n" +
                "    {\r\n" +
                "      \"name\": \"Textfield\",\r\n" +
                "      \"type\": \"text\",\r\n" +
                "      \"value\": \"GoogleFeedContextual\"\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"name\": \"Textfield1\",\r\n" +
                "      \"type\": \"int\",\r\n" +
                "      \"value\": 10\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"name\": \"textfield2\",\r\n" +
                "      \"type\": \"boolean\",\r\n" +
                "      \"value\": true\r\n" +
                "    }\r\n" +
                "  ]";

        Assert.assertTrue(objCM.CustomFieldsExistingInChannelItem(expectedCustomFields, queryIDs[0]));
    }

    // This method uses s3 image location
    @Then("^Channel (.*) Item type '(.*)' should be as expected (.*)$")
    public void channel_Item_should_be_as_expected(String channel, String type, String content) throws InterruptedException {
        String itemContentActual = "";
        String contentExpected = "";
        if (channel.equals("MySale")) {
            if (content.contains("updated")) {
                if (type.equals("Price")) {
                    contentExpected = "\"sell\": {\n" +
                            "      \"currency\": \"AUD\",\n" +
                            "      \"value\": null\n" +
                            "    }";
                } else if (type.equals("Sku image")) {
                    contentExpected = "images\": [\n\n  ]";
                } else if (type.equals("Inventory")) {
                    contentExpected = "\"quantity\": 23";
                }

            } else {
                if (type.equals("Price")) {
                    contentExpected = "\"sell\": {\n" +
                            "      \"currency\": \"AUD\",\n" +
                            "      \"value\": ";
                } else if (type.equals("Sku image")) {
                    contentExpected = "\"merchant_url\": \"https://s3-ap-southeast-2.amazonaws.com/fusionfactory.commerceconnect.iantesting5";
                } else if (type.equals("Inventory")) {
                    contentExpected = "\"quantity\":";
                }
            }
        }

        itemContentActual = objCM.fetchFirstItemContentByType(type);
        log.info("actural : " + itemContentActual);
        log.info("expected : " + contentExpected);
        Assert.assertTrue(itemContentActual.contains(contentExpected));

    }

    //Click the item and check one by one,Borderfree
    @Then("^Price Item should be as expected (.*)$")
    public void price_Item_should_be_as_expected(String priceContent) throws InterruptedException {
        JsonParser parser = new JsonParser();
        JsonElement act = null;
        JsonElement exp = null;
        String itemcontent1 = "{\r\n" +
                "  \"CA\": {\r\n" +
                "    \"sku\": \"%s\",\r\n" +
                "    \"country\": \"CA\",\r\n" +
                "    \"currency\": \"USD\",\r\n" +
                "    \"duty_inclusive\": false,\r\n" +
                "    \"tax_inclusive\": false,\r\n" +
                "    \"original_price\": 50.0,\r\n" +
                "    \"price\": 30.0\r\n" +
                "  },\r\n" +
                "  \"DK\": {\r\n" +
                "    \"sku\": \"%s\",\r\n" +
                "    \"country\": \"DK\",\r\n" +
                "    \"currency\": \"AUD\",\r\n" +
                "    \"duty_inclusive\": false,\r\n" +
                "    \"tax_inclusive\": true,\r\n" +
                "    \"original_price\": 60.0,\r\n" +
                "    \"price\": 40.0\r\n" +
                "  }\r\n" +
                "}";

        String itemcontent2 = "{\r\n" +
                "  \"DK\": {\r\n" +
                "    \"sku\": \"%s\",\r\n" +
                "    \"country\": \"DK\",\r\n" +
                "    \"currency\": \"AUD\",\r\n" +
                "    \"duty_inclusive\": false,\r\n" +
                "    \"tax_inclusive\": true,\r\n" +
                "    \"original_price\": 59.0,\r\n" +
                "    \"price\": 39.0\r\n" +
                "  }\r\n" +
                "}";

        if (priceContent.contains("updated")) {
            itemcontent1 = "{\r\n" +
                    "  \"CA\": {\r\n" +
                    "    \"sku\": \"%s\",\r\n" +
                    "    \"country\": \"CA\",\r\n" +
                    "    \"currency\": \"USD\",\r\n" +
                    "    \"duty_inclusive\": false,\r\n" +
                    "    \"tax_inclusive\": false,\r\n" +
                    "    \"price\": 33.0\r\n" +
                    "  },\r\n" +
                    "  \"DK\": {\r\n" +
                    "    \"sku\": \"%s\",\r\n" +
                    "    \"country\": \"DK\",\r\n" +
                    "    \"currency\": \"AUD\",\r\n" +
                    "    \"duty_inclusive\": false,\r\n" +
                    "    \"tax_inclusive\": true,\r\n" +
                    "    \"price\": 60.0\r\n" +
                    "  }\r\n" +
                    "}";
        }
        for (int i = 0; i < 3; i++) {
            String itemContentActual1 = objCM.fetchItemContent("Display name", queryIDs[i]);
            //log.info("actual: "+itemContentActual1);
            //log.info("expected: "+String.format(itemcontent1, queryIDs[i],queryIDs[i]));
            act = parser.parse(itemContentActual1);
            exp = parser.parse(String.format(itemcontent1, queryIDs[i], queryIDs[i]));
            //log.info("actual json: "+act.toString());
            //log.info("expected json: "+exp.toString());
            Assert.assertEquals("Price Item " + queryIDs[i] + " is not as expected", exp, act);
            //Assert.assertTrue("Price Item "+queryIDs[i]+" is not as expected", itemContentActual1.equals(String.format(itemcontent1, queryIDs[i],queryIDs[i])));
            log.info("Price Item " + queryIDs[i] + " is as expected");
        }
        for (int i = 3; i < 6; i++) {
            String itemContentActual2 = objCM.fetchItemContent("Display name", queryIDs[i]);
            act = parser.parse(itemContentActual2);
            exp = parser.parse(String.format(itemcontent2, queryIDs[i]));
            //log.info("actual json: "+act.toString());
            //log.info("expected json: "+exp.toString());
            Assert.assertEquals("Price Item " + queryIDs[i] + " is not as expected", exp, act);
            log.info("Price Item " + queryIDs[i] + " is as expected");
        }
    }

    /**
     * This is a method to import product
     */
//this step def will be used to import Product
    @Then("^Job result is (.*) in Product Manager and products (.*) and (.*) should get the updated value in PIM (.*)$")
    public void importProducts(String jobResult, String configID, String simpleID, String version) throws InterruptedException, ParseException {
        lp.executeScript_0();

        if (version.equals("Version5")) {
            isVersion5 = true;
        }

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript(String.format("window.scrollBy(0, %s)", -SCREENHEIGHT));
        lp.scrollByScreenHeighUp();

        importJobDetails = objPM.waitTillImportJobCompletes(triggeredTimeString);
        softAssertions = new SoftAssertions();
        softAssertions.assertThat(!ccDateFormat.parse(importJobDetails[0]).before(ccDateFormat.parse(triggeredTimeString)));
        softAssertions.assertThat(importJobDetails[1].equals(jobResult));

        //It's mandatory to have this wait time for product to actually take new value
        Thread.sleep(60000);
        String[] prodURLs = new String[]{CCProdURLPrefix + configID + "/edit", CCProdURLPrefix + simpleID + "/edit#all_prices"};
        String[] valueFromPIM = objPM.checkImportedProducts(isVersion5, prodURLs);

        updateResult1 = MySharedData.getInstance().UPDATERESULT1;
        updateResult2 = MySharedData.getInstance().UPDATERESULT2;
        String[] expectedValues = new String[]{updateResult1[0], updateResult2[0] + ".0"};
        Assert.assertArrayEquals(expectedValues, valueFromPIM);
        softAssertions.assertAll();
    }


    /**
     * Below are the step defs for Order Management
     *
     * @param orderSource
     */


    @Given("^(.*) new order is imported$")
    public void checkNewOrder(String orderSource) {
        lp.executeScript2();
        Assert.assertNotNull(orderSourceID);
    }


    @Then("^new order should be exported$")
    public void checkOrderExportResult() throws InterruptedException, ParseException {
        Assert.assertTrue(exportjobDetails[0].equals("order"));
        Assert.assertTrue(!ccDateFormat.parse(exportjobDetails[1]).before(ccDateFormat.parse(triggeredTimeString)));
        Assert.assertTrue(exportjobDetails[4].equals("Completed"));
        //Assert.assertTrue(jobDetails[2].equals("0"));
    }

    @Then("^contains orderline SKU (.*) and (.*)$")
    public void checkOrderLines(String sku1, String sku2) throws InterruptedException {
        String orderPayload = objCM.fetchItemContent("External code", orderSourceID);
        JsonObject content = new JsonParser().parse(orderPayload).getAsJsonObject();

        String orderlineSku1 = "";
        String orderlineSku2 = "";

        try {
            orderlineSku1 = content.getAsJsonArray("products").get(0).getAsJsonObject().get("sku").getAsString();
            orderlineSku2 = content.getAsJsonArray("products").get(1).getAsJsonObject().get("sku").getAsString();
            log.info("Orderline SKUs are: " + orderlineSku1 + ", " + orderlineSku2);
        } catch (Exception e) {
            log.error("Getting order lines failed.");
        }
        Assert.assertTrue(orderlineSku1.equals(sku1) && orderlineSku2.equals(sku2));
    }

    @Then("^this (.*) order should be imported and job result is Success in Order Manager$")
    public void checkImportResult(String channelType) throws InterruptedException {
        String[] importJobDetailsOM = objOM.checkOrderImportJobResult(importJobDetails[0], orderSourceID);
        objCM.clickChannels();            //this step is to make sure that WebDriver always expands Channel menus even when assert fails

        //don't check ebay order ID because we can't get ebay soure order ID from admin centre
        if (!channelType.equals("ebay")) {
            Assert.assertEquals("New order imported is not the order just created.", orderSourceID, importJobDetailsOM[0]);
        }
        Assert.assertEquals("Order import failed.", "Success", importJobDetailsOM[1]);
        Assert.assertTrue("Order import time is incorrect.", importJobDetailsOM[2].startsWith(importJobDetails[0]));
    }
    /// Complete step defintions


    @When("^a new (\\w+) order is generated$")
    public void generateNewOrder(String market) throws InterruptedException, IOException {

        if (market.equals("Magento2")) {
            orderSourceID = objM2.createNewOrder();
        } else if (market.equals("ebay")) {
            try {
                objEB.gotoListing(EBAYLISTING);
                //ebay doesn't display its internal order source ID on buyer page
                //and order ID starts with item code. The item code of our testing
                //product is 112524331663
                orderSourceID = objEB.makeAPurchase();
            } catch (Exception e) {
                log.error("Exception happened during ebay order generation.");
                e.printStackTrace();
            }
        } else if (market.equals("SFCC")) {
            orderSourceID = objDWBusM.makeAPurchase();
        } else if (market.equals("BigCommerceV3")) {
            orderSourceID = objBigComA.makeAPurchaseV3();
        } else if (market.equals("BigCommerce")) {
            orderSourceID = objBigComA.makeAPurchase();
        }
        log.info(market + " order source ID: " + orderSourceID);

        lp.executeScript_2();
        log.info("Switched back to Channel Manager.");
    }

    @When("^a mock (\\w+) order is generated for (.*)$")
    public void generateMockOrder(String market, String tenant) throws InterruptedException, UnirestException, IOException {
//because this is a mock order, just creating a new tab to sync with other order generation scenarios
        //all other REAL order generation scenarios will create new tab then close it after order is created.
        //  mainWindowHandle = driver.getWindowHandle();
//        ((JavascriptExecutor)driver).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(3));

        lp.executeScript3();

        String mockOrderID = String.format("%06d", new Random().nextInt(1000000));
        String HEADERAUTH = "";

        JtwigTemplate template = JtwigTemplate.classpathTemplate("ebayOrderPayload.json");
        JtwigModel model = JtwigModel.newModel()
                .with("primaryOrderId", "201901250000-16000000" + mockOrderID)
                .with("secondaryOrderId", mockOrderID)
                .with("externalCreatedAt", createdAtFormat.format(new Date()));

        if (tenant.equals("netsuite")) {
            HEADERAUTH = HEADERAUTH1;
        }
        HttpResponse<JsonNode> response = Unirest.post("https://sandbox2-order.commerceconnect.co/api/v2/orders")
                .header("Authorization", HEADERAUTH)
                .header("Content-Type", HEADERCONT)
                .body(template.render(model))
                .asJson();

        JSONObject obj = response.getBody().getObject();
        if (response.getStatus() == 200) {
            orderSourceID = obj.getString("source_primary_order_id");
        }
        Unirest.shutdown();
        log.info("mock " + market + " order source ID: " + orderSourceID);
        //testContext.getDriverFactoryManager().closeDriver();
//        tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(2));
        lp.executeScript_2();
        log.info("Switched back to Channel Manager.");
    }

    @When("^import (.*) job is triggered in channel$")
    public void importOrderOrProduct(String jobType) throws InterruptedException, ParseException {
        triggeredTimeString = objCM.importSome(jobType);
        importJobDetails = objCM.waitTillImportComplete(triggeredTimeString);
        Assert.assertTrue(importJobDetails[1].equals("Completed"));
    }


    // This is magento admin page
    @Given("^(.*) Admin page URL: (.*) and username (.*) and password (.*) to sign in$")
    public void openAdminPage(String target, String URL, String username, String password) throws InterruptedException {
        //if running BigCommerce order test alone, use tabs.get(1) instead
        lp.executeScript3();
        lp.loadUrl(URL);

        if (target.equals("Magento2")) {
            objM2.login(username, password);
        } else if (target.equals("Magento1")) {
            objM1.login(username, password);
        } else if (target.equals("ebay")) {
            objEB.login(username, password);
        } else if (target.equals("SFCC")) {
            //Doesn't need to log in here, because driver got to product purchase page directly. Not Business Manager page.
            log.info("User is navigating to SFCC page...");
        } else if (target.equals("BigCommerce V3")) {
            objBigComA.reset();
            objBigComA.storeLogin(password);
        } else if (target.equals("BigCommerce")) {
            objBigComA.storeLogin(password);
        } else if (target.equals("NetSuite")) {
            //lp.navigateToNetSuitePage();
            objNetSuite.login(username, password);
        }
        log.info("Opened " + target + " Admin webpage.");
    }

}

