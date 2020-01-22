package cucumberBase.pageFactory;


import cucumberBase.driverFactory.managers.FileReaderManager;
import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends PageBase {

    private final Logger log = LoggerHelper.getLogger(LoginPage.class);
    By loginPrompt = By.xpath("//form[@id='new_user']/p");
    /**
     * THese are all locator for Login section
     */
// By userEmail = By.id("user_email");
    @FindBy(id = "user_email")
    private WebElement userEmail;
    // By language = By.id("locale");
    //  By password = By.id("user_password");
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Sign In')]")
    // This is different for sandbox and staging
    private WebElement btnSignIn;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[1]/nav/ul/li[2]/ul")
    private List<WebElement> prd_List;
    @FindBy(xpath = "//div[@class='avatar-label']")
    private WebElement signOutMenu;
    @FindBy(xpath = "//a[contains(.,'Sign Out')]")
    private WebElement signoutLink;

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    /**
     * These are Action methods for Login page elements
     */


    public void setUsername(String strUserName) {
        waitHelper.waitForElementClickable(userEmail, 30);
        userEmail.clear();
        userEmail.sendKeys(strUserName);
        // waitHelper.getWhenVisible(userEmail).sendKeys(usname);

    }

    public void setPassword(String strPassword) {
        waitHelper.waitForElementClickable(password, 30);
        password.clear();
        password.sendKeys(strPassword);
        //   waitHelper.getWhenVisible(password).sendKeys(strPassword);
    }


    // Method to login
    public void clickSigin() {
        waitHelper.waitForElementClickable(btnSignIn, 30);
        btnSignIn.click();
        // driver.get(PMURL);
    }

    public void loginToAdminPage(String strUserName, String strPassword) {
        this.setUsername(strUserName);
        this.setPassword(strPassword);
        this.clickSigin();
        log.info("Clicked to sign in.");
    }

    public void signOut() {
        waitHelper.waitForElementClickable(signOutMenu, 120);
        signOutMenu.click();
        log.info("Clicked at logout menu link.... ");
        signoutLink.click();
        log.info("Clicked at SignOut link.... ");


    }


    //Common Methods:

    // This method launch Login page url for Testing web portal
    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getApplicationUrl());
        driver.manage().window().maximize();
        log.info("Navigated to CC admin page.");


    }

    // This method is used to navigate to comestri link
    public void navigateToComestri() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getComestriUrl());
    }

    // This method redirect user to Product Manager Page
    public void navigateToProductManager() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getProductManager());
    }

    // This method redirect user to OrderManagfer HeartBeat Page
    public void navigateToOrderManagerHB() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getOMHB());
    }

    // This method redirect user to OrderManagfer HeartBeat Page
    public void navigateToNetSuitePage() {
        driver.get(FileReaderManager.getFileReaderManager().getConfigReader().getNSP());
    }

    // This method will be used to get url
    public void loadUrl(String url) {
        driver.get(url);
    }

    // This method used for assertions and get Page Tile
    public String getPageTitle() {
        return driver.getTitle();
    }

    // This method used for validation pageSource content

    public String getPageSource() {
        return driver.getPageSource();
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // This method refresh the page
    public void pageRefresh() {
        driver.navigate().refresh();
    }

    // This method will be used in step definition to handle window
    public void windowHandle() {
        driver.getWindowHandle();
    }

    public void closeWindow() {
        driver.close();
    }

    public int getNumber(int number) {
        return number;
    }

    public String getProductName(int productNumber) {
        return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
    }


    /**
     * These below are JS helper methods will be used in Step Definitions
     */
    // This method redirect to tab0 of browser, product page
    public void executeScript0() {
        //jsHelper.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() < 1) {
            jsHelper.executeScript("window.open()");
            tabs = new ArrayList<String>(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(0));
    }

    // This method redirect to tab0 of browser, back to product page
    public void executeScript_0() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    // This method redirect to tab1 of browser,heartbeat page
    public void executeScript1() {
        //jsHelper.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() < 2) {
            jsHelper.executeScript("window.open()");
            tabs = new ArrayList<String>(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(1));
    }

    public void executeScript_1() {
        //jsHelper.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //if running BigCommerce order test alone, use tabs.get(1) instead
        driver.switchTo().window(tabs.get(1));
    }

    // This method redirect to tab2 of browser, channel manager
    public void executeScript2() {
        //jsHelper.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() < 3) {
            jsHelper.executeScript("window.open()");
            tabs = new ArrayList<String>(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(2));

    }

    // This method redirect to tab2 of browser, back to channel manager
    public void executeScript_2() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));

    }

    // This method redirect to tab3 of browser
    public void executeScript3() {
        //jsHelper.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() < 4) {
            jsHelper.executeScript("window.open()");
            tabs = new ArrayList<String>(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(tabs.size() - 1));

    }

    // This method scroll page by 1080 pixel
    public void scroll1080() {
        jsHelper.scrollDownByPixel();
    }

    // This method scroll page by X pixel
    public void scrollByHeight() {
        jsHelper.scrollByX();
    }

    // This method scroll page by 3X pixel
    public void scrollByScreenHeight3x() {
        jsHelper.scrollByScreenHeight3x();
    }

    // This method scroll to top of page
    public void scrollByScreenHeighUp() {
        jsHelper.scrollByScreenHeightUp();
    }


}


