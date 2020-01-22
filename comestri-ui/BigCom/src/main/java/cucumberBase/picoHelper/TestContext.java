package cucumberBase.picoHelper;


import cucumberBase.driverFactory.managers.DriverFactoryManager;
import cucumberBase.driverFactory.managers.PageObjectManager;
import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;

public class TestContext {
    public DriverFactoryManager driverFactoryManager;
    public PageObjectManager pageObjectManager;
    public String data;
    private Logger log = LoggerHelper.getLogger(TestContext.class);

    public TestContext() {
        driverFactoryManager = new DriverFactoryManager();
        pageObjectManager = new PageObjectManager(driverFactoryManager.getDriver());
        log.info("Initializing constructor for test context");
    }

    public DriverFactoryManager getDriverFactoryManager() {
        return driverFactoryManager;
    }

    public PageObjectManager getPageObjectManager() {

        return pageObjectManager;
    }


}

