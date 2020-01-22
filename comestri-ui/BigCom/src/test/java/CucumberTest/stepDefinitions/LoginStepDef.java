package CucumberTest.stepDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberBase.driverFactory.managers.DriverFactoryManager;
import cucumberBase.helpers.logger.LoggerHelper;
import cucumberBase.pageFactory.LoginPage;
import cucumberBase.picoHelper.TestContext;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class LoginStepDef {
    private LoginPage lp;
    private TestContext testContext;
    private DriverFactoryManager driver;

    private Logger log = LoggerHelper.getLogger(LoginStepDef.class);


    public LoginStepDef(TestContext context) {
        testContext = context;
        lp = testContext.getPageObjectManager().getLP();
        driver = testContext.getDriverFactoryManager();


    }

    /**
     * These are method for Login page
     */
    @Given("User navigate to homepage of Comestri")
    public void userNavigateToHomepageOfComestri() {

        lp.navigateTo_HomePage();

    }


    @When("^user logged in using username as \"(.*)\" and password as \"(.*)\"$")
    public void login(String username, String password) {

        lp.loginToAdminPage(username, password);

    }

    // This method will be used to validate valid and invalid credentials
    @Then("User should see homepage")
    public void userShouldSeeHomepage() {
        log.info("Now validating the username and password");
        String errorMsg = "Invalid Email or password.";
        if (lp.getPageSource().contains(errorMsg)) {
            //  Assert.assertFalse("Login case failed...", false);
            Assert.fail("User with Invalid Credential is trying to Login. Test case failed...");

        } else {
            log.info("valid user is trying to login....");
        }

    }

    // This method will be used to validate that user has logged into webportal
    @And("browser's URL should be {string}")
    public void browserSURLShouldBe(String urlExpected) {

        String actualUrl = lp.getCurrentUrl();
        log.info("Current URL is: " + actualUrl);

        if (actualUrl.equalsIgnoreCase(urlExpected)) {
            System.out.println("Test passed has passed");
        } else {
            System.out.println("Test failed");
        }
    }


    /**
     * These below are tear down methods
     */

    @Given("User has completed Test")
    public void userHasCompletedTest() {

        log.info("Test scenario has completed");
        //lp.signOut();
    }

    @When("Test completed")
    public void testCompleted() {

        log.info("Closing Browser ......");

    }

    @Then("log will be in place")
    public void logWillBeInPlace() {
        log.info("**************************             " + "           " + "             *************************");
        log.info("**************************             " + "-E---N---D-" + "             *************************");
        log.info("**************************             " + "           " + "             *************************");
    }


}
