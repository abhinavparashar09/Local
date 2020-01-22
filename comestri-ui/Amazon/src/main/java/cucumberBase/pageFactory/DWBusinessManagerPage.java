package cucumberBase.pageFactory;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static cucumberBase.helpers.wait.WaitHelper.SCREENHEIGHT;
import static cucumberBase.pageFactory.CommonMethods.clickWhenReady;
import static cucumberBase.pageFactory.CommonMethods.getWhenVisible;


public class DWBusinessManagerPage extends PageBase {
    private final Logger log = LoggerHelper.getLogger(DWBusinessManagerPage.class);
    By usernameField = By.name("LoginForm_Login");
    By passwordField = By.name("LoginForm_Password");
    By loginBtn = By.name("login");
    By overviewTitle = By.xpath("//td[2]/table/tbody/tr/td");
    By searchFocus = By.id("searchFocus");
    By exportStatusLink = By.linkText("Export Status:");
    By exportStatusDropdown = By.name("ExportStatus");
    By saveBtn = By.name("saveExportStatus");
    By modalForm = By.xpath("//fieldset/div[2]");
    By quantityField = By.id("Quantity");
    By addToCartButton = By.id("add-to-cart");
    By viewCartLink = By.linkText("View Cart");
    By priceField = By.cssSelector("span.price-sales");
    By checkOutButton = By.xpath("//div[2]/form/fieldset/button");
    By emailAddress = By.xpath("//form[@id='dwfrm_login']/fieldset/div/div/input");
    By password = By.xpath("//form[@id='dwfrm_login']/fieldset/div[2]/div/input");
    By rememberMeCheckBox = By.id("dwfrm_login_rememberme");
    By loginButton = By.name("dwfrm_login_login");
    By continueToBillingBtn = By.xpath("//fieldset[2]/div/button");
    By payPalRadio = By.id("is-PayPal");
    By continueToPlaceOrderBtn = By.xpath("//form/div/button");
    By placeOrderBtn = By.name("submit");
    By orderIDField = By.xpath("//span[2]");

    /**
     * This is constuctor of class
     *
     * @param driver
     */
    public DWBusinessManagerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    //log in process is not used any more, because driver directly goes to product purchase page
    //final String DWUsername = "ian.hong@fusionfactory.com";
    //final String DWPWD = "x4nugQc?7kBqBRUT";
    //final String DWOrderURL = "https://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/on/demandware.store/Sites-Site/default/ViewOrder_52-Dispatch?csrf_token=FbnDz5BQQKPRGWHDRi7JtggxofGO_MukbmFLqnBGE3WBVsur2DLZpCmjw6ab-dzxJXaSYOU_1q7CAs8B86iilohRPq6RBurTHjLKCx9XRz9q81gU_w-mGXLJM3L54kIzRmJmX90r9Zbnpk0oegl0jrg86XwMLXah2_xlhpK961M2cstzEjk";
    //final String DWOrderProductPage = "http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang=default";
    //final String DWOrderID = "00000101";


	
/*public void login() {
		WebElement username = getWhenVisible(usernameField;
	    username.clear();
	    username.sendKeys(DWUsername);
	    WebElement password = getWhenVisible(passwordField;
	    password.clear();
	    password.sendKeys(DWPWD);

	    clickWhenReady(loginBtn;
	    log.info("Click to log in.");
	}*/

    public String getOverviewTitle() {
        String title = getWhenVisible(overviewTitle).getText();

        return title;
    }

    public void gotoMerchantTools() {
        clickWhenReady(By.xpath("//span[2]/img"));
    }

    public void selectSite() {
        clickWhenReady(By.linkText("SiteGenesis"));
    }

	/*public void gotoOrderPage() {
		gotoMerchantTools();
		selectSite();
        driver.get(DWOrderURL);
	}

	public void gotoOrderProductPage() {
        driver.get(DWOrderProductPage);
	}*/

    public String makeAPurchase() {

        getWhenVisible(quantityField).sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");
        clickWhenReady(addToCartButton);
        clickWhenReady(viewCartLink);
        String priceTag = getWhenVisible(priceField).getText();
        if (priceTag.matches("\\$\\d+[.]\\d{2}")) {
            clickWhenReady(checkOutButton);
            log.info("Item demandware_115426Nov18_green_large is priced at: " + priceTag + " USD");
        } else {
            log.error("Item demandware_115426Nov18_green_large doesn't have usd-list-price.");
            return "12345678";            //return a fake order ID
        }

        //log in process
        getWhenVisible(emailAddress).sendKeys(SFCCBuyerEmail);
        getWhenVisible(password).sendKeys(SFCCBuyerPassword);
        clickWhenReady(loginButton);
        waitHelper.waitForJQueryToLoad();
        log.info("Sign in as SFCC channel buyer.");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0, %s)", SCREENHEIGHT));
        clickWhenReady(continueToBillingBtn);
        log.info("Continue to billing.");

        jse.executeScript(String.format("window.scrollBy(0, %s)", SCREENHEIGHT));
        clickWhenReady(payPalRadio);

        //this section is to click 'BillMeLater' button instead of PayPal
	    /*Select birthYearDrop = new Select(getWhenVisible(birthYear);
	    Select birthMonthDrop = new Select(getWhenVisible(birthMonth);
	    Select birthDayDrop = new Select(getWhenVisible(birthDay);
	    birthYearDrop.selectByVisibleText("1989");
	    birthMonthDrop.selectByVisibleText("March");
	    birthDayDrop.selectByVisibleText("06");
	    getWhenVisible(ssn.sendKeys("3333");

	    jse.executeScript(String.format("window.scrollBy(0, %s)", 0.5*SCREENHEIGHT));
	    clickWhenReady(termsCheckBox;*/
        clickWhenReady(continueToPlaceOrderBtn);
        clickWhenReady(placeOrderBtn);

        String orderID = getWhenVisible(orderIDField).getText();
        return orderID;
    }
	
	/*public void changeOrderStatus() {
        
        clickWhenReady(searchFocus;
        log.info("Click 'Find' button.");
        
        clickWhenReady(By.linkText(DWOrderID);
        log.info("Click order ID: "+DWOrderID);
        
        clickWhenReady(exportStatusLink;
        log.info("Click 'Export Status'.");
        
        Select exportStatus = new Select(getWhenVisible(exportStatusDropdown);
        String orderStatus = exportStatus.getFirstSelectedOption().getText();
        log.info("Order status is: "+orderStatus);
        if (orderStatus.equals("Not Exported")){
        	exportStatus.selectByVisibleText("Ready for Export");
        } else {
        	exportStatus.selectByValue("notexported");
        }
           
        clickWhenReady(saveBtn;
        log.info("Save 'Export Status'.");
	}*/
}
