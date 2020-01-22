package cucumberBase.helpers.window;

import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
    private Logger log = LoggerHelper.getLogger(WindowHelper.class);
    private WebDriver driver;

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
        log.info("WindowHelper object has been created....");
    }


}
