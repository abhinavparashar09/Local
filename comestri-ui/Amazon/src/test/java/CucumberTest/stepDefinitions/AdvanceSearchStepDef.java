package CucumberTest.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.AdvanceSearchPage;
import cucumberBase.picoHelper.TestContext;
import org.apache.log4j.Logger;


public class AdvanceSearchStepDef {
    private TestContext testContext;
    private AdvanceSearchPage objAdvSrh;


    private Logger log = LoggerHelper.getLogger(AdvanceSearchStepDef.class);


    public AdvanceSearchStepDef(TestContext context) {
        testContext = context;
        objAdvSrh = testContext.getPageObjectManager().getAdvSrhPage();


    }


    @When("Click at Advance Search link")
    public void click_at_Advance_Search_link() {


        objAdvSrh.clickAdvancedSearchLink();
        objAdvSrh.clickAdvSearchDropdown();


    }


    // search by Code
    @And("Enter search Code keyword as {string}")
    public void enterSearchCodeKeywordAs(String text1) {
        objAdvSrh.clickLstItemCode();
        objAdvSrh.enterSearchTextCode(text1);
//        objAdvSrh.clickSubmitSearchButton();
    }

    /**
     * Description:earch by name
     *
     * @param index : description select the index of comparitor option
     * @param text1 : description text to be searched
     */
// search by name
    @And("search by Name by selecting filter {int} and enter search keyword as {string}")
    public void searchByNameBySelectingFilterAndEnterSearchKeywordAs(int index, String text1) {
        objAdvSrh.clickLstItemName();
        objAdvSrh.selectComparitorName().selectByIndex(index);
        objAdvSrh.enterSearchTextName(text1);
        objAdvSrh.clickSubmitSearchButton();
    }

    /**
     * These method will be used to select search criteria
     */
    @And("select search by Id from dropdown")
    public void selectSearchByIdFromDropdown() {

        objAdvSrh.clickLstItemId();
    }

    /**
     * Search BY ID: This method will be used to perform search and enter search keyword
     *
     * @param keyword
     */
    @And("enter search ID keyword as {string}")
    public void enterSearchIDKeywordAs(String keyword) {
        objAdvSrh.enterSearchTextId(keyword);
        objAdvSrh.clickSubmitSearchButton();
    }


    // search by name
    @And("enter search keyword as {string}")
    public void enterSearchKeywordAs(String text1) {
        objAdvSrh.clickLstItemId();
        objAdvSrh.enterSearchTextId(text1);
        objAdvSrh.clickSubmitSearchButton();
        // objAdvSrh.clickLstItemName();
        // objAdvSrh.selectComparitorName().selectByIndex(index);
        //  objAdvSrh.enterSearchTextName(text1);
        // objAdvSrh.clickSubmitSearchButton();
    }

    /**
     *
     */

    @And("search by Code by selecting filter {int} and enter search keyword as {string}")
    public void searchByCodeBySelectingFilterAndEnterSearchKeywordAs(int index, String text1) {
        objAdvSrh.clickLstItemCode();
        objAdvSrh.selectComparitorCode().selectByIndex(index);
        objAdvSrh.enterSearchTextCode(text1);
        objAdvSrh.clickSubmitSearchButton();
    }

    // Assertion and validation method for Advance Search
    @Then("User should get some test results")
    public void userShouldGetSomeTestResults() {
        System.out.println("results.........");
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        // to find no of columns of search result table
        WebDriverWait wait = new WebDriverWait(driver, 20);
        List<WebElement> col1 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='product-list-page']/table/thead/tr/th")));


        System.out.println("No of cols are : " + col1.size());

        List<WebElement> totalrows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='product-list-page']/table/tbody/tr/td[3]")));
        System.out.println("No of rows are : " + totalrows.size());
        if (totalrows.size() <25) {
            String Total = driver.findElement(By.xpath("//*[@id=\"products\"]/tfoot/tr/td/div/div[1]/div/b")).getText();
            System.out.println("Total results of the search result are = " + Total);

        } else {
            String Total = driver.findElement(By.xpath("//*[@id=\"products\"]/tfoot/tr/td/div/div[1]/div/b[2]")).getText();
            System.out.println("Total results of the search result are = " + Total);
        }

         */
    }

    // Assertion and validation method for Advance Search
    @And("Atleast one product should be displayed for valid search text")
    public void atleastOneProductShouldBeDisplayedForValidSearchtext() {
        System.out.println("Test complete");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

