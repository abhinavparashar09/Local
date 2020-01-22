package cucumberBase.pageFactory;


import cucumberBase.helpers.dropDown.DropDownHelper;
import cucumberBase.helpers.javaScript.JavaScriptHelper;
import cucumberBase.helpers.wait.WaitHelper;
import org.openqa.selenium.WebDriver;

public class PageBase {
    // Contant timeing
    final int CSVUPLOADTIMEOUT = 180;
    final int PRICERULEJOBREFRESH = 20;
    final int CSVREFRESHINTERVAL = 3000;
    final int SEARCHRESULTWAIT = 4000;
    final int IMPORTJOBREFRESHTRIES = 7;
    final int EXPORTREFRESHTRIES = 36;    //6 minutes
    final int EXPORTREFRESHINTERVAL = 10000;
    final int IMPORTREFRESHTRIES = 20;
    final int ORDERIMPORTREFRESHINTERVAL = 5000;
    final int ORDERIMPORTWAIT = 600;
    final int ORDERIMPORTREFRESHINT = 7000;
    final int ORDERGENERATIONWAIT = 180;
    final String Magento2OrderURL = "http://magento2.aws.fusionfactory.com/admin/sales/order/";
    final String CSVSRCPrefix = "src/main/resources/dataCSV/";
    final String NSPRODURL = "https://system.na0.netsuite.com/app/common/item/item.nl?id=%s&e=T&whence=";
    final String frameName = "ext-gen100";
    final String NSUsername = "ming.chen@fusionfactory.com";
    final String NSPWD = "Feb12th2019";
    Boolean isVersion5 = false;
    //URL
    final String CREDITCARDNO = "4111111111111111";
    final String SFCCBuyerEmail = "ian.hong@fusionfactory.com";
    final String SFCCBuyerPassword = "Fusion123";
    protected WebDriver driver;
    WaitHelper waitHelper;
    JavaScriptHelper jsHelper;
    DropDownHelper selectHelper;
    String[] codeAndName;
    String[] triggeredTime = new String[2];
    String BIGUSERNAME = "ian.hong@fusionfactory.com";
    String BIGPWD = "Fusion!23";            //expire every 3 months, last updated on 08Jun/06Sep/06Mar
    String STORETOKEN = "vmshcxy41h";
    String BIGBUYER = "ian.hong@fusionfactory.com";
    String BIGBUYERPWD = "Fusion123";
    String BIGSTORE = "http://bigbang3.mybigcommerce.com/";
    String BUYTHISPRODUCT = "casual-180125mar19";


    public PageBase(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        selectHelper = new DropDownHelper(driver);
        jsHelper = new JavaScriptHelper(driver);


    }
}
