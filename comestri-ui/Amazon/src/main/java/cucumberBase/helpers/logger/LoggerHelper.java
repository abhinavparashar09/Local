package cucumberBase.helpers.logger;


import cucumberBase.helpers.resourceHelper.ResourceHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerHelper {

    private static boolean root = false;

    // Method for logging
    public static Logger getLogger(Class cls) {
        if (root) {
            return Logger.getLogger(cls);
        }


        PropertyConfigurator.configure(ResourceHelper.getResourcePath("/src/main/resources/log4j/log4j.properties"));
        root = true;
        return Logger.getLogger(cls);
    }

/*
    public static void main(String[] args) {
        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
        log.info("Logger has been configured....");
        log.info("Logger has been configured....");
        log.info("Logger has been configured....");
    }

 */


}

