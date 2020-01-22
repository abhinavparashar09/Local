package cucumberBase.driverFactory.managers;


import cucumberBase.pageFactory.*;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private WebDriver driver;
    private LoginPage lp;
    private AdvanceSearchPage objAdvSrh;
    private CommonMethods objCommonMethod;
    private ProductManagerPage objPM;
    private HeartBeatPage objHB;
    private ChannelManagerPage objCM;
    private OrderManagerPage objOM;
    private BigCommerceAdminPage objBigComA;
    private NetSuiteAdminPage objNetSuite;
    private DWBusinessManagerPage objDWBusM;
    private Magento1AdminPage objM1;
    private Magento2AdminPage objM2;
    private EbayBuyingPage objEbayBuy;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }


    public LoginPage getLP() {
        if (lp == null) {
            lp = new LoginPage(driver);
        }
        return lp;
        //  return (lp == null) ? lp = new LoginPage(driver) : lp;

    }

    public CommonMethods getCommonMethods() {
        return (objCommonMethod == null) ? objCommonMethod = new CommonMethods(driver) : objCommonMethod;
    }

    public AdvanceSearchPage getAdvSrhPage() {

        return (objAdvSrh == null) ? objAdvSrh = new AdvanceSearchPage(driver) : objAdvSrh;

    }

    public ProductManagerPage getProductManagerPage() {

        return (objPM == null) ? objPM = new ProductManagerPage(driver) : objPM;

    }

    public ChannelManagerPage getChannelManagerPage() {
        return (objCM == null) ? objCM = new ChannelManagerPage(driver) : objCM;
    }

    public OrderManagerPage getOrderManager() {
        return (objOM == null) ? objOM = new OrderManagerPage(driver) : objOM;
    }


    public HeartBeatPage getHeartBeatPage() {

        return (objHB == null) ? objHB = new HeartBeatPage(driver) : objHB;

    }

    public BigCommerceAdminPage getBigComAdminPage() {

        return (objBigComA == null) ? objBigComA = new BigCommerceAdminPage(driver) : objBigComA;

    }

    public NetSuiteAdminPage getNetSuiteAdminPage() {

        return (objNetSuite == null) ? objNetSuite = new NetSuiteAdminPage(driver) : objNetSuite;

    }

    public DWBusinessManagerPage getDWBusinessManagerPage() {

        return (objDWBusM == null) ? objDWBusM = new DWBusinessManagerPage(driver) : objDWBusM;

    }

    public Magento1AdminPage getMagento1AdminPage() {

        return (objM1 == null) ? objM1 = new Magento1AdminPage(driver) : objM1;

    }

    public Magento2AdminPage getMagento2AdminPage() {

        return (objM2 == null) ? objM2 = new Magento2AdminPage(driver) : objM2;

    }

    public EbayBuyingPage getEbayBuyingPage() {

        return (objEbayBuy == null) ? objEbayBuy = new EbayBuyingPage(driver) : objEbayBuy;

    }


}
